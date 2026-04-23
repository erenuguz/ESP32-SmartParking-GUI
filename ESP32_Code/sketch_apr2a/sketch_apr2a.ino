#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>
#include <ESP32Servo.h>

#define PARK1_PIN 32
#define PARK2_PIN 33
#define PARK3_PIN 25
#define TRIG_PIN 5
#define ECHO_PIN 18
#define MQ2_PIN 34
#define BUZZER_PIN 26
#define SERVO_PIN 13

#define SCREEN_WIDTH 128
#define SCREEN_HEIGHT 64
Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, -1);

Servo bariyer;
unsigned long bariyerAcilmaZamani = 0;
bool bariyerAcikMi = false;

void setup() {
  Serial.begin(115200);

  // Pin Modları
  pinMode(PARK1_PIN, INPUT);
  pinMode(PARK2_PIN, INPUT);
  pinMode(PARK3_PIN, INPUT);
  pinMode(TRIG_PIN, OUTPUT);
  pinMode(ECHO_PIN, INPUT);
  pinMode(BUZZER_PIN, OUTPUT);
  pinMode(MQ2_PIN, INPUT);

  if(!display.begin(SSD1306_SWITCHCAPVCC, 0x3C)) {
    Serial.println(F("OLED Hatasi!"));
  }
  
  display.clearDisplay();
  display.setTextSize(1);
  display.setTextColor(WHITE);
  display.setCursor(20, 20);
  display.println("SISTEM ACILIYOR...");
  display.display();
  delay(2000);
}

void loop() {
  // 1. Java'dan gelen komutları oku
  if (Serial.available() > 0) {
    char komut = Serial.read();
    if (komut == 'A') {
  bariyer.attach(SERVO_PIN);
  delay(50);
  bariyer.write(90);
}
    else if (komut == 'K') {
      bariyer.write(0);
      delay(500);
      bariyer.detach();
    }
  }

  // Mesafe Ölçümü
  digitalWrite(TRIG_PIN, LOW); delayMicroseconds(2);
  digitalWrite(TRIG_PIN, HIGH); delayMicroseconds(10);
  digitalWrite(TRIG_PIN, LOW);
  long sure = pulseIn(ECHO_PIN, HIGH, 30000);
  int mesafe = sure * 0.034 / 2;

  // Park ve Gaz Oku
  int p1 = digitalRead(PARK1_PIN);
  int p2 = digitalRead(PARK2_PIN);
  int p3 = digitalRead(PARK3_PIN);
  int gaz = analogRead(MQ2_PIN);

  
  if (mesafe > 0 && mesafe < 10 && !bariyerAcikMi) {
    bariyer.attach(SERVO_PIN);
    bariyer.write(90);
    bariyerAcikMi = true;
    bariyerAcilmaZamani = millis();
  }

  if (bariyerAcikMi && (millis() - bariyerAcilmaZamani > 3000)) {
    bariyer.write(0);
    delay(500);
    bariyer.detach();
    bariyerAcikMi = false;
  }

  // Gaz Alarmı
  if (gaz > 2500) {
    digitalWrite(BUZZER_PIN, HIGH);
  } else {
    digitalWrite(BUZZER_PIN, LOW);
  }

  // OLED Güncelleme
  display.clearDisplay();
  display.setCursor(0,0);
  display.print("P1: "); display.println(p1 == LOW ? "DOLU" : "BOS");
  display.print("P2: "); display.println(p2 == LOW ? "DOLU" : "BOS");
  display.print("P3: "); display.println(p3 == LOW ? "DOLU" : "BOS");
  display.print("Mesafe: "); display.print(mesafe); display.println("cm");
  display.display();

  // Java GUI'ye Veri Gönder
  Serial.print(p1 == LOW ? "1" : "0"); Serial.print(",");
  Serial.print(p2 == LOW ? "1" : "0"); Serial.print(",");
  Serial.print(p3 == LOW ? "1" : "0"); Serial.print(",");
  Serial.print(mesafe); Serial.print(",");
  Serial.println(gaz);

  delay(200);
}