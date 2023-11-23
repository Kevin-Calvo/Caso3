package UISistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import Controllers.AgricultorController;
import Controllers.ServiciosController;
import Objetos.SistemaCentralizado;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class UIServicioDisponible extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	int total;
	private ServiciosController controller = new ServiciosController(); 


	public UIServicioDisponible() {	
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cooperativa Agricola del Este  s.a");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(186, 10, 541, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Prestamos y Pedidos");
		lblNewLabel_1_1_1.setForeground(new Color(0, 64, 0));
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(263, 59, 314, 39);
		contentPane.add(lblNewLabel_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 122, 668, 220);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				controller.obtenerTablaTransacciones(),
			new String[] {
				"Fecha", "Agricultor", "Producto", "Precio por unidad", "Cantidad", "Total"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(96);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		//lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\_151ffaa0-4b7c-49df-b556-84b0c53a7366__1___1_-removebg-preview.png"));
		//lblNewLabel_2.setBounds(0, -18, 126, 136);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setVisible(true);
				dispose();	
			}	
		});
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 24));
		btnNewButton.setBounds(26, 461, 199, 61);
		contentPane.add(btnNewButton);
		
		JTextField fecha_textfield = new JTextField();
		fecha_textfield.setFont(new Font("Arial", Font.PLAIN, 16));
		fecha_textfield.setBounds(140, 350, 100, 28);
		contentPane.add(fecha_textfield);
		fecha_textfield.setColumns(10);
		
		
		String[] agricultores = controller.obtenerListaAgricultor();
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(250, 350, 100, 28);
		comboBox_1.setModel(new DefaultComboBoxModel(agricultores));
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(comboBox_1);
		
		JTextField producto_textfield = new JTextField();
		producto_textfield.setFont(new Font("Arial", Font.PLAIN, 16));
		producto_textfield.setBounds(360, 350, 100, 28);
		contentPane.add(producto_textfield);
		producto_textfield.setColumns(10);
		
		JTextField precioU_textfield = new JTextField();
		precioU_textfield.setFont(new Font("Arial", Font.PLAIN, 16));
		precioU_textfield.setBounds(470, 350, 120, 28);
		contentPane.add(precioU_textfield);
		precioU_textfield.setColumns(10);
		
		JTextField cantidad_textfield = new JTextField();
		cantidad_textfield.setFont(new Font("Arial", Font.PLAIN, 16));
		cantidad_textfield.setBounds(595, 350, 100, 28);
		contentPane.add(cantidad_textfield);
		cantidad_textfield.setColumns(10);
		
		JLabel totalLabel = new JLabel("");
		totalLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		totalLabel.setBounds(700, 350, 100, 28);
		contentPane.add(totalLabel);
		Border borde = BorderFactory.createLineBorder(Color.BLACK, 1);
		totalLabel.setBorder(borde);
		
		JButton btnNewButton2 = new JButton("Calcular");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.calcularTotalTransaccion(cantidad_textfield, precioU_textfield, totalLabel); 
			}
			
		}); 
		
		btnNewButton2.setBackground(new Color(0, 128, 0));
		btnNewButton2.setFont(new Font("Arial Black", Font.PLAIN, 24));
		btnNewButton2.setBounds(700, 390, 199, 61);
		contentPane.add(btnNewButton2);
		
		JButton btnNewButton1 = new JButton("Agregar");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.registrarTransaccion(fecha_textfield, cantidad_textfield, precioU_textfield, comboBox_1, producto_textfield, table, totalLabel);
			}}); 
		
		btnNewButton1.setBackground(new Color(0, 128, 0));
		btnNewButton1.setFont(new Font("Arial Black", Font.PLAIN, 24));
		btnNewButton1.setBounds(700, 461, 199, 61);
		contentPane.add(btnNewButton1);
		   
	}
}
