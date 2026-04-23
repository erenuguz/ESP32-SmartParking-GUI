package esp32OtoparkSistemi;

import com.fazecast.jSerialComm.SerialPort;

public class PortTest {
    public static void main(String[] args) {
        SerialPort[] ports = SerialPort.getCommPorts();
        System.out.println("Mevcut Portlar:");
        for (SerialPort port : ports) {
            System.out.println("- " + port.getSystemPortName() + " (" + port.getDescriptivePortName() + ")");
        }
    }
}
