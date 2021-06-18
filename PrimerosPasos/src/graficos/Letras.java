package graficos;

import java.awt.GraphicsEnvironment;
import javax.swing.*;

public class Letras {

	public static void main(String[] args) {
		
		String fuente = JOptionPane.showInputDialog("Introduce fuente: ");
		
		boolean estaLaFuente = false;
		
		
		
		String [] nombresDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for (String nombreDeLaFuente: nombresDeFuentes) {
			
			if (nombreDeLaFuente.equalsIgnoreCase(fuente)) {
				estaLaFuente = true;
			}
			
		}
		
		if (estaLaFuente) {
			System.out.println("Fuente instalada!");
		}else {
			System.out.println("Fuente NO encontrada!");
		}
		
	}

}
