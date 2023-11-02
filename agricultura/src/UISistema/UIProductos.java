package UISistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;

public class UIProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtAgregar;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public UIProductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 523);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(10, 538, 165, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblProductos = new JLabel("Registrar Productos\r\n");
		lblProductos.setForeground(new Color(0, 64, 0));
		lblProductos.setFont(new Font("Arial Black", Font.PLAIN, 40));
		lblProductos.setBounds(219, 51, 507, 55);
		contentPane.add(lblProductos);
		
		JLabel lblNewLabel = new JLabel("Digite el nombre del producto\r\n");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(315, 116, 216, 27);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(315, 239, 216, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDigiteElCosto = new JLabel("Digite el costo del producto\r\n");
		lblDigiteElCosto.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDigiteElCosto.setBounds(315, 192, 216, 27);
		contentPane.add(lblDigiteElCosto);
		
		txtAgregar = new JTextField();
		txtAgregar.setBounds(314, 155, 217, 27);
		contentPane.add(txtAgregar);
		txtAgregar.setColumns(10);
		
		JLabel lblDigiteLaCantidad = new JLabel("Digite la cantidad de productos a agregar\r\n\r\n");
		lblDigiteLaCantidad.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDigiteLaCantidad.setBounds(282, 275, 300, 27);
		contentPane.add(lblDigiteLaCantidad);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner.setFont(new Font("Arial", Font.PLAIN, 16));
		spinner.setBounds(315, 313, 227, 27);
		contentPane.add(spinner);
		
		JButton btnNewButton_1 = new JButton("Agregar");
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnNewButton_1.setBounds(282, 350, 300, 55);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Regresar");
		btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnNewButton_2.setBackground(new Color(0, 128, 0));
		btnNewButton_2.setBounds(24, 421, 145, 55);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\_151ffaa0-4b7c-49df-b556-84b0c53a7366__1_-removebg-preview.png"));
		lblNewLabel_2.setBounds(20, 10, 125, 110);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\depositphotos_483669338-stock-il.png"));
		lblNewLabel_1.setBounds(661, 314, 165, 162);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cooperativa Agricola del Este  s.a");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 31));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(155, 10, 591, 39);
		contentPane.add(lblNewLabel_1_1);
	}
}