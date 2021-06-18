package graficos;

import javax.swing.*;
import java.awt.*;


public class EscribiendoEnMarco {

	public static void main(String[] args) {
		
		MarcoConTexto miMarco = new MarcoConTexto();
		
		
	}

}

class MarcoConTexto extends JFrame {
	
	public MarcoConTexto() {
		
		setVisible(true);
		setSize(600, 450);
		setLocation(400, 200);
		setTitle("Primer texto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Lamina MiLamina = new Lamina();
		add(MiLamina);
		
		
	}
	
}

class Lamina extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g); 									// hace lo que tiene que hacer el padre, JComponent porque lo hereda.
		g.drawString("Estamos aprendiendo Swing", 100, 100);		// 100 px del borde izquierdo y 100 px del borde superior, del marco
		
	}
	
}

