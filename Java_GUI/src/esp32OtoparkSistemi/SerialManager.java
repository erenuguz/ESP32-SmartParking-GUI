package esp32OtoparkSistemi;

import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

public class SerialManager {
    private SerialPort comPort;
    private Thread readThread;
    private OtoparkGUI gui;

    public SerialManager(OtoparkGUI gui) {
        this.gui = gui;
    }

    public boolean baglan(String portAdi, int baudRate) {
        comPort = SerialPort.getCommPort(portAdi);
        comPort.setBaudRate(baudRate);
        
        if (comPort.openPort()) {
            System.out.println("Bağlantı başarılı: " + portAdi);
            verileriDinlemeyeBasla();
            return true;
        }
        return false;
    }

    private void verileriDinlemeyeBasla() {
        readThread = new Thread(() -> {
            java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.InputStreamReader(comPort.getInputStream())
            );
            while (comPort.isOpen()) {
                try {
                    if (comPort.bytesAvailable() > 0) {
                        Scanner scanner = new Scanner(comPort.getInputStream());
                        if (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line != null && line.contains(",")) {
                                gui.verileriGuncelle(line);
                            }
                        }
                    }
                    Thread.sleep(50);
                } catch (Exception e) {
                    System.out.println("Bozuk paket atlandı, okumaya devam ediliyor...");
                }
            }
            
        });
        readThread.start();
    }

    public void veriGonder(String komut) {
        if (comPort != null && comPort.isOpen()) {
            byte[] b = komut.getBytes();
            comPort.writeBytes(b, b.length);
        }
    }
}