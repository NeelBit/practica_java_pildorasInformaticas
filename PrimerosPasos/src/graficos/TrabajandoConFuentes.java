package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class TrabajandoConFuentes {

	public static void main(String[] args) {
		
		MarcoConFuentes miMarco = new MarcoConFuentes();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
		
		
	}

}

class MarcoConFuentes extends JFrame {
	
	public MarcoConFuentes() {
		
		setTitle("Pueba con fuentes");
		setSize(400, 400);
		LaminaConFuentes miLamina = new LaminaConFuentes();
		add(miLamina);
		
		miLamina.setForeground(Color.GREEN); 			// establecer un color por defecto para todo lo que dibujemos en la lamina
		
	}
	

	
}

class LaminaConFuentes extends JPanel {
	//public void paintComponent(Graphics g) CON MINUSCULA LA PRIMER LETRA
	public void paintComponent(Graphics g) {

		super.paintComponents(g);
		Graphics2D g2= (Graphics2D) g;
		
		Font miFuente = new Font("Arial", Font.BOLD, 26);
		
		g2.setFont(miFuente);
		 
		//g2.setColor(Color.RED); 			// setColor y setPaint aparentemente sirven de la misma manera
		 
		g2.drawString("Nelson", 100, 200);
		
		g2.setFont(new Font("Courier", Font.ITALIC, 32));
		//g2.setColor(Color.BLUE); 			// new Color(50,50,50) --> por ejemplo para instanciar un objeto de tipo color con RGB
		g2.drawString("hola de nuevo", 50, 250);
		
		
		
	}
}