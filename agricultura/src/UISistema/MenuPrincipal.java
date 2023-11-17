package UISistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import UISistema.UICultivo;

import UISistema.UIServicio;

import UISistema.UIServicioDisponible;
import UISistema.UiVender;

import UISistema.UIAgricultor;
import javax.swing.ImageIcon;
public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 491);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Principal");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 40));
		lblNewLabel.setBounds(80, 36, 359, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnNewButton.setBounds(176, 226, 140, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cultivos");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 128, 0));
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UICultivo cult=new UICultivo();
				cult.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(104, 168, 145, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Servicios");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 128, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UIServicio serv=new UIServicio();
				serv.setVisible(true);
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnNewButton_3.setBounds(270, 168, 140, 51);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Vender");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(0, 128, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UiVender vend=new UiVender();
				vend.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnNewButton_4.setBounds(104, 110, 145, 48);
		contentPane.add(btnNewButton_4);
		
		//JLabel lblNewLabel_2 = new JLabel("New label");
		//lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\_151ffaa0-4b7c-49df-b556-84b0c53a7366__1___1_-removebg-preview.png"));
		//lblNewLabel_2.setBounds(192, 286, 140, 119);
		//contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cooperativa Agricola del Este  s.a");
		lblNewLabel_1_1.setForeground(new Color(0, 64, 0));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(10, 0, 541, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton_5 = new JButton("Agricultor");
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(0, 128, 0));
		btnNewButton_5.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIAgricultor serv=new UIAgricultor();
				serv.setVisible(true);
			}
			
		});
		btnNewButton_5.setBounds(270, 110, 140, 48);
		contentPane.add(btnNewButton_5);
	}
}
