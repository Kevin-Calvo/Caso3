package UISistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UiVender extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	
	public UiVender() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 657);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vender Productos\r\n");
		lblNewLabel.setForeground(new Color(0, 64, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblNewLabel.setBounds(235, 59, 314, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(10, 572, 165, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblDigiteElNombre_1 = new JLabel("Digite el nombre del cultivo a vender");
		lblDigiteElNombre_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDigiteElNombre_1.setBounds(245, 107, 261, 27);
		contentPane.add(lblDigiteElNombre_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		textField.setBounds(264, 230, 217, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDigiteElNombre_1_1 = new JLabel("Digite precio del cultivo a vender para el consumidor final");
		lblDigiteElNombre_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDigiteElNombre_1_1.setBounds(203, 193, 432, 27);
		contentPane.add(lblDigiteElNombre_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_1.setBounds(264, 144, 226, 40);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDigiteLaCantidad_1 = new JLabel("Digite la cantidad de cultivos a vender\r\n");
		lblDigiteLaCantidad_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDigiteLaCantidad_1.setBounds(235, 277, 293, 27);
		contentPane.add(lblDigiteLaCantidad_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner.setFont(new Font("Arial", Font.PLAIN, 16));
		spinner.setBounds(261, 314, 217, 40);
		contentPane.add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\set-of-different-vegetables-cartoon-free-vector (1).jpg"));
		lblNewLabel_1.setBounds(240, 432, 256, 160);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Vender");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 22));
		btnNewButton_1.setBounds(240, 369, 248, 46);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\_151ffaa0-4b7c-49df-b556-84b0c53a7366__1_-removebg-preview.png"));
		lblNewLabel_2.setBounds(-4, 0, 125, 110);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cooperativa Agricola del Este  s.a");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(131, 10, 541, 39);
		contentPane.add(lblNewLabel_1_1);
	}

}
