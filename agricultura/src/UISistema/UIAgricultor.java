package UISistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UIAgricultor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	
	public UIAgricultor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 761);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Agricultor");
		lblNewLabel_1_1_1.setForeground(new Color(0, 128, 64));
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.PLAIN, 40));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(349, 31, 228, 58);
		contentPane.add(lblNewLabel_1_1_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(25, 99, 898, 566);
		contentPane.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Agregar", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Cooperativa Agricola del Este  s.a");
		lblNewLabel_1_1_2.setForeground(new Color(0, 64, 0));
		lblNewLabel_1_1_2.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblNewLabel_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_1_2.setBounds(182, 10, 541, 39);
		panel_3.add(lblNewLabel_1_1_2);
		
		JLabel lblAgregarAgricultor = new JLabel("Agregar Agricultor");
		lblAgregarAgricultor.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblAgregarAgricultor.setBounds(332, 52, 194, 26);
		panel_3.add(lblAgregarAgricultor);
		
		JLabel lblNewLabel_1 = new JLabel("Digite el nombre del agricultor");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(313, 88, 258, 22);
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		textField.setBounds(313, 207, 212, 39);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Digite la identificacion del asociado");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(295, 175, 258, 22);
		panel_3.add(lblNewLabel_1_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_1.setBounds(313, 124, 212, 41);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnNewButton.setBounds(313, 285, 212, 49);
		panel_3.add(btnNewButton);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\_151ffaa0-4b7c-49df-b556-84b0c53a7366__1___1_-removebg-preview.png"));
		lblNewLabel_2_1.setBounds(10, 410, 140, 119);
		panel_3.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\user_add (1).png"));
		lblNewLabel_3.setBounds(351, 354, 149, 132);
		panel_3.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Eliminar", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Cooperativa Agricola del Este  s.a");
		lblNewLabel_1_1_2_1.setForeground(new Color(0, 64, 0));
		lblNewLabel_1_1_2_1.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblNewLabel_1_1_2_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_1.setBounds(183, 0, 541, 39);
		panel_2.add(lblNewLabel_1_1_2_1);
		
		JLabel lblEliminarAgricultor = new JLabel("Eliminar Agricultor");
		lblEliminarAgricultor.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblEliminarAgricultor.setBounds(349, 49, 194, 26);
		panel_2.add(lblEliminarAgricultor);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Digite la identificacion del asociado");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(317, 96, 258, 22);
		panel_2.add(lblNewLabel_1_2_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_2.setBounds(317, 137, 258, 39);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\_151ffaa0-4b7c-49df-b556-84b0c53a7366__1___1_-removebg-preview.png"));
		lblNewLabel_2_1_1.setBounds(10, 410, 140, 119);
		panel_2.add(lblNewLabel_2_1_1);
		
		JButton btnNewButton_4 = new JButton("Eliminar");
		btnNewButton_4.setBackground(new Color(0, 255, 0));
		btnNewButton_4.setFont(new Font("Arial Black", Font.PLAIN, 21));
		btnNewButton_4.setBounds(317, 193, 258, 39);
		panel_2.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\user_delete (1).png"));
		lblNewLabel.setBounds(371, 252, 149, 132);
		panel_2.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Consultar", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("Cooperativa Agricola del Este  s.a");
		lblNewLabel_1_1_2_2.setForeground(new Color(0, 64, 0));
		lblNewLabel_1_1_2_2.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblNewLabel_1_1_2_2.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_2.setBounds(207, 10, 541, 39);
		panel_1.add(lblNewLabel_1_1_2_2);
		
		JLabel lblConsultarAgricultor = new JLabel("Consultar Agricultor");
		lblConsultarAgricultor.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblConsultarAgricultor.setBounds(348, 59, 210, 26);
		panel_1.add(lblConsultarAgricultor);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Digite la identificacion del asociado");
		lblNewLabel_1_2_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2_1_2.setBounds(322, 109, 258, 22);
		panel_1.add(lblNewLabel_1_2_1_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_4.setBounds(322, 141, 250, 39);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\_151ffaa0-4b7c-49df-b556-84b0c53a7366__1___1_-removebg-preview.png"));
		lblNewLabel_2_1_1_1.setBounds(10, 410, 140, 119);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		JButton btnNewButton_2 = new JButton("Consultar");
		btnNewButton_2.setBackground(new Color(0, 255, 0));
		btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 21));
		btnNewButton_2.setBounds(322, 206, 250, 44);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\user_information (1).png"));
		lblNewLabel_5.setBounds(375, 260, 149, 132);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Modificar", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\_151ffaa0-4b7c-49df-b556-84b0c53a7366__1___1_-removebg-preview.png"));
		lblNewLabel_2.setBounds(10, 410, 140, 119);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cooperativa Agricola del Este  s.a");
		lblNewLabel_1_1.setBounds(186, 10, 541, 39);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(0, 64, 0));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		
		JLabel lblModificarAgricultor = new JLabel("Modificar Agricultor");
		lblModificarAgricultor.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblModificarAgricultor.setBounds(352, 59, 215, 26);
		panel.add(lblModificarAgricultor);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Digite la identificacion del asociado");
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1.setBounds(323, 105, 258, 22);
		panel.add(lblNewLabel_1_2_1_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_3.setBounds(322, 137, 258, 39);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Modificar");
		btnNewButton_3.setBackground(new Color(0, 255, 0));
		btnNewButton_3.setFont(new Font("Arial Black", Font.PLAIN, 21));
		btnNewButton_3.setBounds(323, 188, 258, 39);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\users3_edit (1).png"));
		lblNewLabel_4.setBounds(387, 242, 149, 132);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Regresar");
		btnNewButton_1.setBackground(new Color(0, 128, 0));
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 24));
		btnNewButton_1.setBounds(25, 675, 204, 39);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\_151ffaa0-4b7c-49df-b556-84b0c53a7366__1___1_-removebg-preview.png"));
		lblNewLabel_2_1_1_1_1.setBounds(10, -18, 140, 119);
		contentPane.add(lblNewLabel_2_1_1_1_1);
	}
}
