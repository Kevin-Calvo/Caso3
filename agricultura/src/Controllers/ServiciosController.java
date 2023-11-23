package Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Objetos.SistemaCentralizado;

public class ServiciosController {
	private SistemaCentralizado sistema = SistemaCentralizado.getSistemaCentralizado();
	int total;
	
	public ServiciosController() {}; 
	
	public Object[][] obtenerTablaTransacciones() {
		return sistema.mostrarTransaccionesTabla();
	}
	
	public String[] obtenerListaAgricultor() {
		ArrayList<String> lista = sistema.obtenerListaNombreAgricultor(); 
		return lista.toArray(new String[lista.size()]);
	}
	
	public void calcularTotalTransaccion(JTextField cantidad_textfield, JTextField precioU_textfield, JLabel totalLabel) {
		int cantidad;
		try {
			 cantidad = Integer.parseInt(cantidad_textfield.getText());
		} catch (NumberFormatException e1) {
			System.out.println("Cantidad no es formato numerico");
			e1.printStackTrace();
			return;
		}
		
		int precioU;
		try {
			precioU = Integer.parseInt(precioU_textfield.getText());
		} catch (NumberFormatException e1) {
			System.out.println("Cantidad no es formato numerico");
			e1.printStackTrace();
			return;
		}
		
		total = cantidad * precioU; 
		String totalStr = String.valueOf(total);
		totalLabel.setText(totalStr);
	}
	
	public void registrarTransaccion(JTextField fecha_textfield, JTextField cantidad_textfield, JTextField precioU_textfield, JComboBox agricultorComboBox, JTextField producto_textfield, JTable table, JLabel totalLabel) {
		Date fecha = null;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fecha = formato.parse(fecha_textfield.getText());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		int cantidad;
		try {
			 cantidad = Integer.parseInt(cantidad_textfield.getText());
		} catch (NumberFormatException e1) {
			System.out.println("Cantidad no es formato numerico");
			e1.printStackTrace();
			return;
		}
		
		int precioU;
		try {
			precioU = Integer.parseInt(precioU_textfield.getText());
		} catch (NumberFormatException e1) {
			System.out.println("Cantidad no es formato numerico");
			e1.printStackTrace();
			return;
		}
		
		String agricultor = (String) agricultorComboBox.getSelectedItem();
		String producto = producto_textfield.getText(); 
		 
		
		if (producto != "") {
			sistema.agregarTransaccion(fecha, agricultor, producto, precioU, cantidad, total);
			producto_textfield.setText("");
			table.setModel(new DefaultTableModel(
					sistema.mostrarTransaccionesTabla(),
				new String[] {
					"Fecha", "Agricultor", "Producto", "Precio por unidad", "Cantidad", "Total"
				}
			));
			
		fecha_textfield.setText("");
		producto_textfield.setText("");
		precioU_textfield.setText("");
		cantidad_textfield.setText("");
		totalLabel.setText("");
		}
	}
}
