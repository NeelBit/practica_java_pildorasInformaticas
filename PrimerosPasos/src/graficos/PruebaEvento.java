package graficos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PruebaEvento {

	public static void main(String[] args) {
		
		MarcoBotones miMarco = new MarcoBotones();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
		
		
	}

}

class MarcoBotones extends JFrame {
	
	public MarcoBotones() {
		
		setTitle("Botones y eventos");
		setBounds(500, 300, 500, 400);
		LaminaBotones miLamina = new LaminaBotones();
		add(miLamina);
		
		
	}
	
}

class LaminaBotones extends JPanel implements ActionListener { // la propia lamina recibe el evento, por eso se implementa aca.
	
	JButton botonAzul = new JButton("Azul");
	JButton botonAmarillo = new JButton("Amarillo");
	JButton botonRojo = new JButton("Rojo");
	// cuando hacemos click en el boton, java construye un objeto de tipo evento
	// y ese objeto, va al objeto de tipo ActionEvent e
	
	public LaminaBotones() { 		// constructor
		
		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);
		
		botonAzul.addActionListener(this); 		// this hago referencia a la lamina
		botonAmarillo.addActionListener(this);
		botonRojo.addActionListener(this);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) { 	// sobreescribir el metodo de la imprementacion. ActionEvent es un evento del tipo raton (hacer click), se lo llama e por convencion
		
		Object botonPulsado = e.getSource(); 	// obtengo la fuente (desencadenan la accion)
		
		if (botonPulsado == botonAzul) {
			setBackground(Color.BLUE);
		}
		else if (botonPulsado == botonAmarillo) {
			setBackground(Color.YELLOW);
		}
		else if (botonPulsado == botonRojo) {
			setBackground(Color.RED);
		}

		
	}
	
}
