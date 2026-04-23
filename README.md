# 🚗 Smart Parking Management System

This project is a real-time smart parking solution that integrates an **ESP32** microcontroller with a **Java-based GUI** for monitoring and control.

## ✨ Features

- **Live Parking Occupancy:** 3 IR sensors monitor slot availability in real-time.
- **Automated Barrier:** A servo-controlled barrier opens automatically when a car is detected by the ultrasonic sensor.
- **Gas Leakage Alarm:** MQ2 sensor detects hazardous gases and triggers a buzzer alarm.
- **Real-time Monitoring:** An OLED display on the ESP32 and a Java Swing GUI on the PC show all sensor data simultaneously.

## 🛠️ Hardware Components

- **ESP32 DevKit V1**
- **3x IR Obstacle Sensors** (Parking Slots)
- **HC-SR04 Ultrasonic Sensor** (Distance Measurement)
- **MQ2 Gas Sensor** (Safety)
- **SG90 Servo Motor** (Gate/Barrier)
- **Active Buzzer** (Alarm)
- **SSD1306 OLED Display** (128x64 I2C)

## 💻 Tech Stack

- **Firmware:** C++ (Arduino IDE)
- **Software:** Java (Swing Library)
- **Communication:** Serial (jSerialComm library)

## 🔧 Installation

### 1. ESP32 Setup
- Install `Adafruit_SSD1306` and `ESP32Servo` libraries in Arduino IDE.
- Upload the `.ino` file to your ESP32.

### 2. Java GUI Setup
- Import the project into **Eclipse** or **IntelliJ**.
- Add `jSerialComm.jar` to your Build Path.
- Update the COM port in `SerialManager.java` to match your ESP32's port.
- Run `OtoparkGUI.java`.

---
Developed as a student project for Embedded Systems & Java Programming.
