package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EjemploAreaTexto {

	public static void main(String[] args) {
		
		MarcoEjemploAreaTexto miMarco = new MarcoEjemploAreaTexto();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}


class MarcoEjemploAreaTexto extends JFrame{
	
	public MarcoEjemploAreaTexto() {
		
		setBounds(500, 250, 500, 400);
		LaminaEjemploAreaTexto miLamina = new LaminaEjemploAreaTexto();
		add(miLamina);
		setVisible(true);
		
	}
	
	
}

class LaminaEjemploAreaTexto extends JPanel {
	
	public LaminaEjemploAreaTexto() {
		
		miArea = new JTextArea(8, 20); 		// filas, columnas
		miArea.setLineWrap(true); 		// hacemos que tenga saltos de linea automaticos, para que no sea infinito el cuadro. o lo comentamos y se encargara el JScrollPane de hacerle una barra de desplazamiento
		
		
		JScrollPane laminaBarra = new JScrollPane(miArea); 		// incluir el JTextArea dentro de otra lamina tipo JScrollPane para que tenga barra de desplazamiento y se pueda desplazar el cuadro.
		
		
		add(laminaBarra);	// añadimos a la lamina
		
		JButton miBoton = new JButton("Dale");
		miBoton.addActionListener(new GestionaArea()); 		// creo objeto oyente y lo pongo a la escucha
		
		add(miBoton); 		// añadimos boton
	}
	
	private class GestionaArea implements ActionListener { 	// actionlistener click en el boton

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println(miArea.getText());
			
		} 	
		
		
		
	}
	
	private JTextArea miArea;
	
}




