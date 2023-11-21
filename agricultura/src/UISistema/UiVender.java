package UISistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Mongo.InventarioRepository;
import Objetos.SistemaCentralizado;

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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UiVender extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	boolean preciosCalculados = false;
	float costoXunidad;
	float valorTotal;

	
	public UiVender() {
		SistemaCentralizado sistema = SistemaCentralizado.getSistemaCentralizado();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 767);
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
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(282, 682, 165, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblDigiteElNombre_1 = new JLabel("Digite el nombre del cultivo a vender");
		lblDigiteElNombre_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDigiteElNombre_1.setBounds(245, 107, 261, 27);
		contentPane.add(lblDigiteElNombre_1);
		
		
		
		JLabel lblDigiteLaCantidad_1 = new JLabel("Digite la cantidad de kilos a vender\r\n");
		lblDigiteLaCantidad_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDigiteLaCantidad_1.setBounds(245, 195, 293, 27);
		contentPane.add(lblDigiteLaCantidad_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBackground(new Color(255, 255, 255));
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner.setFont(new Font("Arial", Font.PLAIN, 16));
		spinner.setBounds(263, 232, 217, 40);
		contentPane.add(spinner);
		
		//JLabel lblNewLabel_1 = new JLabel("New label");
		//lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\set-of-different-vegetables-cartoon-free-vector (1).jpg"));
		//lblNewLabel_1.setBounds(224, 514, 256, 160);
		//contentPane.add(lblNewLabel_1);
		
		
		//JLabel lblNewLabel_2 = new JLabel("New label");
		//lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\_151ffaa0-4b7c-49df-b556-84b0c53a7366__1_-removebg-preview.png"));
		//lblNewLabel_2.setBounds(10, 10, 125, 110);
		//contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cooperativa Agricola del Este  s.a");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(131, 10, 541, 39);
		contentPane.add(lblNewLabel_1_1);
		
		ArrayList<String> listaProducto = sistema.obtenerListaNombreProducto();
		String[] productos = listaProducto.toArray(new String[listaProducto.size()]);
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(productos));
		comboBox.setBounds(264, 142, 217, 40);
		contentPane.add(comboBox);
		
		JLabel costoUnidadLabel = new JLabel("Precio por kilo");
		costoUnidadLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		costoUnidadLabel.setBounds(225, 282, 149, 27);
		contentPane.add(costoUnidadLabel);
		
		JLabel costoUnidad = new JLabel("");
		costoUnidad.setBounds(255, 310, 50, 36);
		contentPane.add(costoUnidad);
		
		JLabel totalLabel = new JLabel("Precio total");
		totalLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		totalLabel.setBounds(445, 282, 99, 27);
		contentPane.add(totalLabel);
		
		JLabel total = new JLabel("");
		total.setBounds(470, 310, 50, 38);
		contentPane.add(total);
		
		JLabel gananciaCoopeLabel = new JLabel("Ganancia Coope");
		gananciaCoopeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		gananciaCoopeLabel.setBounds(225, 350, 149, 27);
		contentPane.add(gananciaCoopeLabel);
		
		JLabel gananciaCoope = new JLabel("");
		gananciaCoope.setBounds(255, 380, 50, 36);
		contentPane.add(gananciaCoope);
		
		JLabel gananciaAgriLabel = new JLabel("Ganancia Agricultor");
		gananciaAgriLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		gananciaAgriLabel.setBounds(445, 350, 149, 27);
		contentPane.add(gananciaAgriLabel);
		
		JLabel gananciaAgri = new JLabel("");
		gananciaAgri.setBounds(470, 380, 50, 36);
		contentPane.add(gananciaAgri);
		
		JButton btnNewButton_1 = new JButton("Calcular");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cultivo = (String) comboBox.getSelectedItem();
				int cantidad = (int) spinner.getValue(); 
				costoXunidad = sistema.calcularPrecioXKilo(cultivo, cantidad); 
				valorTotal = (costoXunidad * cantidad) * 2; 
				float gananciaCoopeValor = 15;
				float gananciaAgricultorValor = 15;
				if (costoXunidad != 0)
				{
					costoUnidad.setText(String.valueOf(costoXunidad));    
					total.setText(String.valueOf(valorTotal)); 
					gananciaCoope.setText(String.valueOf(gananciaCoopeValor));
					gananciaAgri.setText(String.valueOf(gananciaAgricultorValor)); 
					preciosCalculados = true;
				}
			}
		});
		
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 22));
		btnNewButton_1.setBounds(235, 458, 271, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2= new JButton("Vender");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (preciosCalculados)
				{
					String cultivo = (String) comboBox.getSelectedItem();
					int cantidad = (int) spinner.getValue(); 
					sistema.VenderCultivo(cultivo, cantidad);
					total.setText("");
					costoUnidad.setText("");
					gananciaAgri.setText("");
					gananciaCoope.setText("");
					preciosCalculados = false; 
				}
			}
		});
		
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(0, 128, 255));
		btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 22));
		btnNewButton_2.setBounds(235, 558, 271, 46);
		contentPane.add(btnNewButton_2);
	}

}
