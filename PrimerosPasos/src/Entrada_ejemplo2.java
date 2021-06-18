import javax.swing.*;

public class Entrada_ejemplo2 {

	public static void main(String[] args) {
		
		String nombre_usuario = JOptionPane.showInputDialog("Introduce tu nombre");
		
		String edad_usuario = JOptionPane.showInputDialog("Introduce tu edad");
		
		int edad = Integer.parseInt(edad_usuario);		// tranformar String a int
		
		System.out.println("Hola " + nombre_usuario + ". Tienes " + edad_usuario + " años. El año que viene tendras "
				+ (edad + 1) + " años");
		
	}

}
