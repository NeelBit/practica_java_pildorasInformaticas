package graficos;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPanel;

public class EventosTeclado {

	public static void main(String[] args) {
		
		MarcoConTeclas miMarco = new MarcoConTeclas();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoConTeclas extends JFrame{
	
	public MarcoConTeclas() {
		
		setVisible(true);
		setBounds(400, 200, 600, 450);
		
// indicar el objeto oyente (de la clase oyente que es la que implementa KeyListener en este caso):
		EventoDeTeclado tecla = new EventoDeTeclado();
		addKeyListener(tecla); 		// poner a nuestro objeto a la escucha
		
		
	}
	
}


class EventoDeTeclado implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		
		char letraPulsada = e.getKeyChar();
		System.out.println("La letra pulsada es: " + letraPulsada);
		
	}

	@Override
	public void keyPressed(KeyEvent e) { 	
		
		int codigoDeTecla = e.getKeyCode();
		System.out.println("El código de la tecla presionada es: " + codigoDeTecla);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	
	
}



