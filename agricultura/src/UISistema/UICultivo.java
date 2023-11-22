package UISistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Mongo.*;
import Objetos.SistemaCentralizado;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UICultivo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;

	
	public UICultivo() {
		SistemaCentralizado sistema = SistemaCentralizado.getSistemaCentralizado();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 637);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		textField_1.setBounds(302, 168, 216, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel gananciaCoopeLabel = new JLabel("Digite el porcentaje de ganancia de la Coope");
		gananciaCoopeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		gananciaCoopeLabel.setBounds(257, 205, 323, 27);
		contentPane.add(gananciaCoopeLabel);
		
		JSpinner spinner1 = new JSpinner();
		spinner1.setFont(new Font("Arial", Font.PLAIN, 16));
		spinner1.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner1.setBounds(302, 235, 216, 38);
		contentPane.add(spinner1);
		
		JLabel lblDigiteLaCantidad = new JLabel("Digite la cantidad de cultivos a agregar");
		lblDigiteLaCantidad.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDigiteLaCantidad.setBounds(277, 284, 293, 27);
		contentPane.add(lblDigiteLaCantidad);
		
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
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Arial", Font.PLAIN, 16));
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner.setBounds(305, 321, 216, 38);
		contentPane.add(spinner);
		
		JButton btnNewButton_1 = new JButton("Agregar");
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		btnNewButton_1.setBounds(274, 540, 293, 47);
		contentPane.add(btnNewButton_1);
		
		//JLabel lblNewLabel_2 = new JLabel("New label");
		//lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\_151ffaa0-4b7c-49df-b556-84b0c53a7366__1_-removebg-preview.png"));
		//lblNewLabel_2.setBounds(0, -2, 125, 110);
		//contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cooperativa Agricola del Este  s.a");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(164, 0, 541, 39);
		contentPane.add(lblNewLabel_1_1);
		
		ArrayList<String> listaProducto = sistema.obtenerListaNombreProducto();
		String[] productos = listaProducto.toArray(new String[listaProducto.size()]);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(productos)); 
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(308, 91, 210, 38);
		contentPane.add(comboBox);
		
		JTextField textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_2.setBounds(50, 68, 140, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Agregar Tipo Producto");
		btnNewButton_2.setBackground(new Color(0, 128, 255));
		btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnNewButton_2.setBounds(37, 108, 160, 47);
		contentPane.add(btnNewButton_2);
		
		JLabel lblDigiteLaFecha = new JLabel("Digite la fecha de la cosecha del cultivo");
		lblDigiteLaFecha.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDigiteLaFecha.setBounds(277, 369, 293, 27);
		contentPane.add(lblDigiteLaFecha);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(306, 396, 216, 38);
		contentPane.add(textField);
		
		JLabel lblSeleccioneElNombre = new JLabel("Seleccione el nombre del agricultor");
		lblSeleccioneElNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSeleccioneElNombre.setBounds(302, 444, 265, 27);
		contentPane.add(lblSeleccioneElNombre);
		
		ArrayList<String> lista = sistema.obtenerListaNombreAgricultor(); 
		String[] agricultores = lista.toArray(new String[lista.size()]); 
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(316, 481, 216, 38);
		comboBox_1.setModel(new DefaultComboBoxModel(agricultores));
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(comboBox_1);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date cosecha = null;
				int costo = 0;
				String cultivo = (String) comboBox.getSelectedItem();
				
				int cantidad = (int) spinner.getValue(); 
				int porcentaje = (int) spinner1.getValue();
				
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				try {
					cosecha = formato.parse(textField.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					System.out.println("Fecha no en formato correcto");
					e1.printStackTrace();
					return;
				}
				
				try {
					costo = Integer.parseInt(textField_1.getText()); 
				} catch (NumberFormatException e1) {
					System.out.println("Costo no es formato numerico");
					e1.printStackTrace();
					return; 
				}
				
				String agricultor = (String) comboBox_1.getSelectedItem();
				
				sistema.AgregarCultivoAIventarioYTransaccion(cultivo, costo, cantidad, cosecha, porcentaje, agricultor); 
				
				btnNewButton.setVisible(true);
				dispose();
				
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (!(textField_2.getText()).isEmpty())
				{
					sistema.AgregarProducto(textField_2.getText());
					textField_2.setText(""); 
				}
			}
		});
			
	}
}
