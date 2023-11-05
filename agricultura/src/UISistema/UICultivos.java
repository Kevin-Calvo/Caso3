package UISistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UICultivos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;

	
	public UICultivos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 637);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				btnNewButton.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(10, 556, 165, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblCultivos = new JLabel("Agregar Cultivos\r\n");
		lblCultivos.setForeground(new Color(0, 64, 0));
		lblCultivos.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblCultivos.setBounds(304, 28, 283, 40);
		contentPane.add(lblCultivos);
		
		JLabel lblDigiteElNombre = new JLabel("Digite el nombre del cultivo");
		lblDigiteElNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDigiteElNombre.setBounds(316, 62, 216, 27);
		contentPane.add(lblDigiteElNombre);
		
		JLabel lblDigiteElPrecio = new JLabel("Digite el costo que va a tener el cultivo");
		lblDigiteElPrecio.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDigiteElPrecio.setBounds(277, 139, 293, 27);
		contentPane.add(lblDigiteElPrecio);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_1.setBounds(302, 188, 216, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDigiteLaCantidad = new JLabel("Digite la cantidad de cultivos a agregar");
		lblDigiteLaCantidad.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDigiteLaCantidad.setBounds(277, 244, 293, 27);
		contentPane.add(lblDigiteLaCantidad);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Arial", Font.PLAIN, 16));
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner.setBounds(305, 281, 216, 38);
		contentPane.add(spinner);
		
		JButton btnNewButton_1 = new JButton("Agregar");
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		btnNewButton_1.setBounds(274, 510, 293, 47);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\_151ffaa0-4b7c-49df-b556-84b0c53a7366__1_-removebg-preview.png"));
		lblNewLabel_2.setBounds(0, -2, 125, 110);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cooperativa Agricola del Este  s.a");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(164, 0, 541, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Papa", "Chayote", "Tomate", "Yuca", "Camote", "Ayote", "Sapayos", "Fresas", "Pejibayes"}));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(308, 91, 210, 38);
		contentPane.add(comboBox);
		
		JLabel lblDigiteLaFecha = new JLabel("Digite la fecha de la cosecha del cultivo");
		lblDigiteLaFecha.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDigiteLaFecha.setBounds(277, 329, 293, 27);
		contentPane.add(lblDigiteLaFecha);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(306, 356, 216, 38);
		contentPane.add(textField);
		
		JLabel lblSeleccioneElNombre = new JLabel("Seleccione el nombre del agricultor");
		lblSeleccioneElNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSeleccioneElNombre.setBounds(302, 404, 265, 27);
		contentPane.add(lblSeleccioneElNombre);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(316, 441, 216, 38);
		contentPane.add(comboBox_1);
	}
}
