package Controllers;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Objetos.SistemaCentralizado;

public class AgricultorController {
	private SistemaCentralizado sistema = SistemaCentralizado.getSistemaCentralizado();
	
	public AgricultorController(){
		
	}
	
	public Object[][] obtenerTablaAgricultores() {
		return sistema.mostrarAgricultoresTabla();
	}
	
	public void agregarAgricultor(JTextField nombre, JTextField apellidos, JTextField identificacion, JTextField numero, JTextField zona, JTextField fecha, JTable table) {
		String nombreAgricultor = nombre.getText();
		String apellidoAgricultor = apellidos.getText();
		int identifiacionAgricultor = 0;
		int numeroAgricultor = 0;
		String zonaAgricultor = zona.getText();
		String fechaAgricultor = fecha.getText();
		try {
			identifiacionAgricultor = Integer.parseInt(identificacion.getText());
		} catch (NumberFormatException e1) {
			System.out.println("Identificacion no es formato numerico");
			e1.printStackTrace();
			return;
		}
		
		try {
			numeroAgricultor = Integer.parseInt(numero.getText());
		} catch (NumberFormatException e1) {
			System.out.println("Numero Telefonico no es formato numerico");
			e1.printStackTrace();
			return;
		}
		
		if ((nombreAgricultor != "") && (apellidoAgricultor != "") && (zonaAgricultor != "") && (fechaAgricultor != ""))
		{
			sistema.agregarAgricultor(nombreAgricultor, apellidoAgricultor, identifiacionAgricultor, numeroAgricultor, zonaAgricultor, fechaAgricultor);
			
			nombre.setText("");
			apellidos.setText("");
			identificacion.setText("");
			numero.setText("");
			zona.setText("");
			fecha.setText("");
			
			table.setModel(new DefaultTableModel(
					obtenerTablaAgricultores(),
				new String[] {
					"Nombre", "Apellidos", "Identificacion", "Numero de Telefono", "Zona", "Fecha de Registro"
				}
			));
		}
	}
	
	
}
