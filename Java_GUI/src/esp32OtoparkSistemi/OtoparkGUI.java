package esp32OtoparkSistemi;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class OtoparkGUI extends JFrame {

	private JPanel contentPane;
	private JPanel park1, park2, park3; 
	private JTextArea txtHareketSensoru, txtGazSensoru, txtBariyerServo, txtBuzzer, txtOledEkranMesaji; 
	private JTextField txtPark1, textField1Time, txtPark2, textField2Time, txtPark3, textField3Time;
	SerialManager sm;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtoparkGUI frame = new OtoparkGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OtoparkGUI() {
		sm = new SerialManager(this);
		
		setTitle("Akilli Otopark Takip Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 450, 630);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel parkAlanlari = new JPanel();
		parkAlanlari.setBackground(Color.LIGHT_GRAY);
		parkAlanlari.setBounds(10, 10, 430, 180);
		panel.add(parkAlanlari);
		parkAlanlari.setLayout(null);
		
		JTextArea txtrBaslikParkAlanlari = new JTextArea();
		txtrBaslikParkAlanlari.setEditable(false);
		txtrBaslikParkAlanlari.setBackground(Color.LIGHT_GRAY);
		txtrBaslikParkAlanlari.setForeground(Color.BLACK);
		txtrBaslikParkAlanlari.setBounds(10, 10, 155, 25);
		parkAlanlari.add(txtrBaslikParkAlanlari);
		txtrBaslikParkAlanlari.setText("PARK ALANLARI");
		txtrBaslikParkAlanlari.setFont(new Font("Monospaced", Font.BOLD, 15));
		
		// PARK 1
		park1 = new JPanel();
		park1.setBackground(Color.GREEN);
		park1.setBounds(20, 45, 90, 115);
		parkAlanlari.add(park1);
		park1.setLayout(null);
		
		txtPark1 = new JTextField();
		txtPark1.setBackground(new Color(255, 255, 255));
		txtPark1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPark1.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtPark1.setEditable(false);
		txtPark1.setText("PARK 1");
		txtPark1.setBounds(0, 100, 90, 15);
		park1.add(txtPark1);
		
		textField1Time = new JTextField();
		textField1Time.setBackground(new Color(255, 255, 255));
		textField1Time.setHorizontalAlignment(SwingConstants.CENTER);
		textField1Time.setBorder(BorderFactory.createEmptyBorder());
		textField1Time.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField1Time.setEditable(false);
		textField1Time.setBounds(0, 85, 90, 15);
		park1.add(textField1Time);
		
		// PARK 2
		park2 = new JPanel();
		park2.setBackground(Color.GREEN);
		park2.setLayout(null);
		park2.setBounds(170, 45, 90, 115);
		parkAlanlari.add(park2);
		
		txtPark2 = new JTextField();
		txtPark2.setText("PARK 2");
		txtPark2.setHorizontalAlignment(SwingConstants.CENTER);
		txtPark2.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtPark2.setEditable(false);
		txtPark2.setBounds(0, 100, 90, 15);
		park2.add(txtPark2);
		
		textField2Time = new JTextField();
		textField2Time.setHorizontalAlignment(SwingConstants.CENTER);
		textField2Time.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField2Time.setEditable(false);
		textField2Time.setBounds(0, 85, 90, 15);
		park2.add(textField2Time);
		
		// PARK 3
		park3 = new JPanel();
		park3.setBackground(Color.GREEN);
		park3.setLayout(null);
		park3.setBounds(320, 45, 90, 115);
		parkAlanlari.add(park3);
		
		txtPark3 = new JTextField();
		txtPark3.setText("PARK 3");
		txtPark3.setHorizontalAlignment(SwingConstants.CENTER);
		txtPark3.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtPark3.setEditable(false);
		txtPark3.setBounds(0, 100, 90, 15);
		park3.add(txtPark3);
		
		textField3Time = new JTextField();
		textField3Time.setHorizontalAlignment(SwingConstants.CENTER);
		textField3Time.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField3Time.setEditable(false);
		textField3Time.setBounds(0, 85, 90, 15);
		park3.add(textField3Time);
		
		JPanel girisKontrol = new JPanel();
		girisKontrol.setBackground(Color.LIGHT_GRAY);
		girisKontrol.setBounds(10, 200, 430, 160);
		panel.add(girisKontrol);
		girisKontrol.setLayout(null);
		
		JTextArea txtBaslikGirisKontrol = new JTextArea();
		txtBaslikGirisKontrol.setEditable(false);
		txtBaslikGirisKontrol.setBackground(Color.LIGHT_GRAY);
		txtBaslikGirisKontrol.setText("GİRİŞ KONTROL");
		txtBaslikGirisKontrol.setFont(new Font("Monospaced", Font.BOLD, 15));
		txtBaslikGirisKontrol.setBounds(10, 10, 155, 25);
		girisKontrol.add(txtBaslikGirisKontrol);
		
		txtHareketSensoru = new JTextArea();
		txtHareketSensoru.setText("HAREKET SENSÖRÜ: 0 cm");
		txtHareketSensoru.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtHareketSensoru.setBackground(Color.LIGHT_GRAY);
		txtHareketSensoru.setBounds(20, 45, 400, 25);
		girisKontrol.add(txtHareketSensoru);
		
		txtBariyerServo = new JTextArea();
		txtBariyerServo.setText("BARİYER SERVO: KAPALI");
		txtBariyerServo.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtBariyerServo.setBackground(Color.LIGHT_GRAY);
		txtBariyerServo.setBounds(20, 80, 401, 25);
		girisKontrol.add(txtBariyerServo);
		
		JButton btnBariyerAc = new JButton("BARİYER AÇ");
		btnBariyerAc.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBariyerAc.setBounds(20, 115, 165, 25);
		girisKontrol.add(btnBariyerAc);
		
		JButton btnBariyerKapat = new JButton("BARİYER KAPAT");
		btnBariyerKapat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBariyerKapat.setBounds(205, 115, 165, 25);
		girisKontrol.add(btnBariyerKapat);
		
		JPanel güvenlik = new JPanel();
		güvenlik.setLayout(null);
		güvenlik.setBackground(Color.LIGHT_GRAY);
		güvenlik.setBounds(10, 370, 430, 160);
		panel.add(güvenlik);
		
		JTextArea txtBaslikGuvenlik = new JTextArea();
		txtBaslikGuvenlik.setEditable(false);
		txtBaslikGuvenlik.setText("GÜVENLİK");
		txtBaslikGuvenlik.setFont(new Font("Monospaced", Font.BOLD, 15));
		txtBaslikGuvenlik.setBackground(Color.LIGHT_GRAY);
		txtBaslikGuvenlik.setBounds(10, 10, 155, 25);
		güvenlik.add(txtBaslikGuvenlik);
		
		txtGazSensoru = new JTextArea();
		txtGazSensoru.setText("GAZ SENSÖRÜ:");
		txtGazSensoru.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtGazSensoru.setBackground(Color.LIGHT_GRAY);
		txtGazSensoru.setBounds(20, 45, 400, 25);
		güvenlik.add(txtGazSensoru);
		
		txtBuzzer = new JTextArea();
		txtBuzzer.setText("BUZZER: PASİF");
		txtBuzzer.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtBuzzer.setBackground(Color.LIGHT_GRAY);
		txtBuzzer.setBounds(20, 80, 401, 25);
		güvenlik.add(txtBuzzer);
		
		JButton btnAlarmAc = new JButton("ALARM AÇ");
		btnAlarmAc.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAlarmAc.setBounds(20, 115, 165, 25);
		güvenlik.add(btnAlarmAc);
		
		JButton btnAlarmKapat = new JButton("ALARM KAPAT");
		btnAlarmKapat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAlarmKapat.setBounds(205, 115, 165, 25);
		güvenlik.add(btnAlarmKapat);
		
		JPanel oledEkranMesajiPanel = new JPanel();
		oledEkranMesajiPanel.setLayout(null);
		oledEkranMesajiPanel.setBackground(Color.LIGHT_GRAY);
		oledEkranMesajiPanel.setBounds(10, 540, 430, 80);
		panel.add(oledEkranMesajiPanel);
		
		JTextArea txtBaslikOledEkranMesaji = new JTextArea();
		txtBaslikOledEkranMesaji.setEditable(false);
		txtBaslikOledEkranMesaji.setText("OLED EKRAN MESAJI");
		txtBaslikOledEkranMesaji.setFont(new Font("Monospaced", Font.BOLD, 15));
		txtBaslikOledEkranMesaji.setBackground(Color.LIGHT_GRAY);
		txtBaslikOledEkranMesaji.setBounds(10, 10, 155, 25);
		oledEkranMesajiPanel.add(txtBaslikOledEkranMesaji);
		
		txtOledEkranMesaji = new JTextArea();
		txtOledEkranMesaji.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtOledEkranMesaji.setBackground(Color.WHITE);
		txtOledEkranMesaji.setBounds(10, 45, 410, 25);
		txtOledEkranMesaji.setText("Sistem Beklemede...");
		oledEkranMesajiPanel.add(txtOledEkranMesaji);

		btnBariyerAc.addActionListener(e -> { sm.veriGonder("A"); txtBariyerServo.setText("BARİYER SERVO: AÇIK"); });
		btnBariyerKapat.addActionListener(e -> { sm.veriGonder("K"); txtBariyerServo.setText("BARİYER SERVO: KAPALI"); });
		btnAlarmAc.addActionListener(e -> { sm.veriGonder("B"); txtBuzzer.setText("BUZZER: AKTİF"); });
		btnAlarmKapat.addActionListener(e -> { sm.veriGonder("S"); txtBuzzer.setText("BUZZER: PASİF"); });

		sm.baglan("COM5", 115200); 
	}
	
	public void verileriGuncelle(String veri) {
	    if (veri == null || veri.trim().isEmpty()) return; // Boş veriyi direkt atla

	    try {
	        String[] parcalar = veri.split(",");
	        
	        if (parcalar.length == 5) {
	            javax.swing.SwingUtilities.invokeLater(() -> {
	                try {
	                    JPanel[] parkPanelleri = {park1, park2, park3};
	                    
	                    for(int i = 0; i < 3; i++) {
	                        String durum = parcalar[i];
	                        parkPanelleri[i].setBackground(durum.equals("1") ? Color.RED : Color.GREEN);
	                    }

	                    int mesafe = Integer.parseInt(parcalar[3]);
	                    if (mesafe < 10) {
	                    	txtHareketSensoru.setText("HAREKET SENSÖRÜ: " + mesafe + " cm");	
						}else {
							txtHareketSensoru.setText("HAREKET SENSÖRÜ: " + "0 cm");
						}
	                    
	                    String gazHam = parcalar[4];
	                    if(!gazHam.isEmpty()){
	                        int gazVal = Integer.parseInt(gazHam);
	                        txtGazSensoru.setText("GAZ SENSÖRÜ: " + gazVal);
	                        
	                        if(gazVal > 2000) {
	                            txtGazSensoru.setForeground(Color.RED);
	                            txtBuzzer.setText("BUZZER: !!! ALARM !!!");
	                        } else {
	                            txtGazSensoru.setForeground(Color.BLACK);
	                        }
	                    }
	                } catch (Exception innerE) {
	                    
	                }
	            });
	        }
	    } catch (Exception e) {
	        System.out.println("Hatalı paket atlandı..."); 
	        
	    }
	}
}