package graficos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// EN EL MISMO PAQUETE NO PUEDE HABER MISMOS NOMBRES DE CLASES

public class PruebaEventoMejorada {

	public static void main(String[] args) {
		
		MarcoBotones miMarco = new MarcoBotones();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
		
		
	}

}

class MarcoBotonesMejorada extends JFrame {
	
	public MarcoBotonesMejorada() {
		
		setTitle("Botones y eventos");
		setBounds(500, 300, 500, 400);
		LaminaBotones miLamina = new LaminaBotones();
		add(miLamina);
		
		
	}
	
}

class LaminaBotonesMejorada extends JPanel { 
	
	JButton botonAzul = new JButton("Azul");
	JButton botonAmarillo = new JButton("Amarillo");
	JButton botonRojo = new JButton("Rojo");
	
	public LaminaBotonesMejorada() { 		// constructor
		
		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);
		
		ColorFondo azul = new ColorFondo(Color.BLUE);
		ColorFondo amarillo = new ColorFondo(Color.YELLOW);
		ColorFondo rojo = new ColorFondo(Color.RED);
		
		// paso por parametro los objetos de ColorFondo que implementa ActionListener
		botonAzul.addActionListener(azul); 	
		botonAmarillo.addActionListener(amarillo);
		botonRojo.addActionListener(rojo);
		
		
		
	}
	
	// CLASE INTERNA
	private class ColorFondo implements ActionListener { 	// es el oyente
		
		public ColorFondo(Color c) { 	// constructor que recibe un parametro de tipo Color
			
			colorDeFondo = c;
			
		}
		

		
		public void actionPerformed(ActionEvent e) {
			
			setBackground(colorDeFondo);
			
		}
		
		private Color colorDeFondo;
	}
	
}





