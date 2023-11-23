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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controllers.AgricultorController;
import Objetos.SistemaCentralizado;

import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;

public class UIAgricultor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField nombre;
	private JTextField apellidos;
	private JTextField identificacion;
	private JTextField numero;
	private JTextField zona;
	private JTextField fecha;
	private AgricultorController controller = new AgricultorController(); 
	
	public UIAgricultor() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 761);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Agricultor");
		lblNewLabel_1_1_1.setForeground(new Color(0, 64, 0));
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.PLAIN, 40));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(336, 41, 228, 58);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton_1 = new JButton("Regresar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 128, 0));
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 24));
		btnNewButton_1.setBounds(25, 675, 204, 39);
		contentPane.add(btnNewButton_1);
		
		//JLabel lblNewLabel_2_1_1_1_1 = new JLabel("New label");
		//lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\_151ffaa0-4b7c-49df-b556-84b0c53a7366__1___1_-removebg-preview.png"));
		//lblNewLabel_2_1_1_1_1.setBounds(10, -18, 140, 119);
		//contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 109, 898, 480);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				controller.obtenerTablaAgricultores(),
			new String[] {
				"Nombre", "Apellidos", "Identificacion", "Numero de Telefono", "Zona", "Fecha de Registro"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(104);
		table.getColumnModel().getColumn(4).setPreferredWidth(76);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cooperativa Agricola del Este  s.a");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 31));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(189, 13, 591, 39);
		contentPane.add(lblNewLabel_1_1);
		
		nombre = new JTextField();
		nombre.setFont(new Font("Arial", Font.PLAIN, 16));
		nombre.setBounds(25, 600, 135, 28);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		apellidos = new JTextField();
		apellidos.setFont(new Font("Arial", Font.PLAIN, 16));
		apellidos.setBounds(165, 600, 135, 28);
		contentPane.add(apellidos);
		apellidos.setColumns(10);
		
		identificacion = new JTextField();
		identificacion.setFont(new Font("Arial", Font.PLAIN, 16));
		identificacion.setBounds(305, 600, 130, 28);
		contentPane.add(identificacion);
		identificacion.setColumns(10);
		
		numero = new JTextField();
		numero.setFont(new Font("Arial", Font.PLAIN, 16));
		numero.setBounds(440, 600, 160, 28);
		contentPane.add(numero);
		numero.setColumns(10);
		
		zona = new JTextField();
		zona.setFont(new Font("Arial", Font.PLAIN, 16));
		zona.setBounds(607, 600, 135, 28);
		contentPane.add(zona);
		zona.setColumns(10);
		
		fecha = new JTextField();
		fecha.setFont(new Font("Arial", Font.PLAIN, 16));
		fecha.setBounds(747, 600, 160, 28);
		contentPane.add(fecha);
		fecha.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.agregarAgricultor(nombre, apellidos, identificacion, numero, zona, fecha, table); 
				btnNewButton.setVisible(true);
			}
		});
		
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 24));
		btnNewButton.setBounds(685, 675, 204, 39);
		contentPane.add(btnNewButton);
			
	}
}
