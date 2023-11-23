package Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import Objetos.SistemaCentralizado;

public class CultivoController {
	private SistemaCentralizado sistema = SistemaCentralizado.getSistemaCentralizado();
	
	public CultivoController(){
		
	}
	
	public String[] obtenerListaNombreProducto() {
		ArrayList<String> listaProducto = sistema.obtenerListaNombreProducto();
		return listaProducto.toArray(new String[listaProducto.size()]);
	}
	
	public String[] obtenerListaAgricultores() {
		ArrayList<String> lista = sistema.obtenerListaNombreAgricultor(); 
		return lista.toArray(new String[lista.size()]);
	}
	
	public void agregarCultivoInventario(JComboBox cultivoComboBox, JTextField costoTextField, JSpinner cantidadSpinner, JTextField cosechaTextField, JSpinner porcentajeSpinner, JComboBox agricultorComboBox) {
		Date cosecha = null;
		int costo = 0;
		String cultivo = (String) cultivoComboBox.getSelectedItem();
		
		int cantidad = (int) cantidadSpinner.getValue(); 
		int porcentaje = (int) porcentajeSpinner.getValue();
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		try {
			cosecha = formato.parse(cosechaTextField.getText());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			System.out.println("Fecha no en formato correcto");
			e1.printStackTrace();
			return;
		}
		
		try {
			costo = Integer.parseInt(costoTextField.getText()); 
		} catch (NumberFormatException e1) {
			System.out.println("Costo no es formato numerico");
			e1.printStackTrace();
			return; 
		}
		
		String agricultor = (String) agricultorComboBox.getSelectedItem();
		
		sistema.AgregarCultivoAIventarioYTransaccion(cultivo, costo, cantidad, cosecha, porcentaje, agricultor);
	}
	
	public void agregarTipoCultivo(JTextField productoTextField) {
		if (!(productoTextField.getText()).isEmpty())
		{
			sistema.AgregarProducto(productoTextField.getText());
			productoTextField.setText(""); 
		}
	}
}
