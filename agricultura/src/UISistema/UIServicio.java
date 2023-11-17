package UISistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import UISistema.UIServicioDisponible;
public class UIServicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public UIServicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 399);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblServicios = new JLabel("Servicios que le ofrecemos\r\n");
		lblServicios.setForeground(new Color(0, 64, 0));
		lblServicios.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblServicios.setBounds(201, 56, 470, 40);
		contentPane.add(lblServicios);
		
		//JLabel lblNewLabel_2 = new JLabel("New label");
		//lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\_151ffaa0-4b7c-49df-b556-84b0c53a7366__1_-removebg-preview.png"));
		//lblNewLabel_2.setBounds(10, -15, 126, 136);
		//contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cooperativa Agricola del Este  s.a");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(191, 10, 541, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Regresar");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_2_1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnNewButton_2_1.setBackground(new Color(0, 102, 0));
		btnNewButton_2_1.setBounds(283, 173, 270, 61);
		contentPane.add(btnNewButton_2_1);
		
		//JLabel lblNewLabel_5 = new JLabel("New label");
		//lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\customer_service_icon_800_wht (1).jpg"));
		//lblNewLabel_5.setBounds(337, 244, 149, 132);
		//contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Prestamos y pedidos");
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIServicioDisponible cult=new UIServicioDisponible();
				cult.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 18));
		btnNewButton.setBounds(230, 102, 368, 61);
		contentPane.add(btnNewButton);
	}
}
