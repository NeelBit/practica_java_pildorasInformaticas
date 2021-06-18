package poo;

import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class PruebaTemporizador {

	public static void main(String[] args) {

		
		DameLaHora oyente = new DameLaHora(); 			//da lo mismo:  ActionListener oyente = new DameLaHora();
		
		Timer miTemporizador = new Timer(5000, oyente);
		
		miTemporizador.start();
		
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");
		
		System.exit(0);
		
	}

}

class DameLaHora implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		Date ahora = new Date();
		
		System.out.println("Te pongo la hora cada 5 segundos: " + ahora);
		
	}
	
}