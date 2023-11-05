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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UiVender extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public UiVender() {
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
		
		JLabel lblDigiteElNombre_1_1 = new JLabel("Precio total");
		lblDigiteElNombre_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDigiteElNombre_1_1.setBounds(317, 363, 99, 27);
		contentPane.add(lblDigiteElNombre_1_1);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\set-of-different-vegetables-cartoon-free-vector (1).jpg"));
		lblNewLabel_1.setBounds(224, 514, 256, 160);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Vender");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 22));
		btnNewButton_1.setBounds(235, 458, 271, 46);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\_151ffaa0-4b7c-49df-b556-84b0c53a7366__1_-removebg-preview.png"));
		lblNewLabel_2.setBounds(10, 10, 125, 110);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cooperativa Agricola del Este  s.a");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(131, 10, 541, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Papa", "Chayote", "Ayote", "Camote", "Tomates", "Platanos", "Bananos", "Cebolla", "Fresas", "Limones", "Sapayo", "Lechuga", "Coliflor", "Remolacha", "Repollo verde", "Repollo morado", "Zanahoria", "Maiz", "Rabano"}));
		comboBox.setBounds(264, 142, 217, 40);
		contentPane.add(comboBox);
		
		JLabel lblDigiteElNombre_1_1_1 = new JLabel("Precio por unidad");
		lblDigiteElNombre_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDigiteElNombre_1_1_1.setBounds(298, 282, 149, 27);
		contentPane.add(lblDigiteElNombre_1_1_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(266, 317, 214, 36);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(263, 395, 217, 38);
		contentPane.add(panel_1);
	}

}
