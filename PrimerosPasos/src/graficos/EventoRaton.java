package graficos;

import java.awt.event.*;

import javax.swing.JFrame;

public class EventoRaton {

	public static void main(String[] args) {
		
		MarcoRaton miMarco = new MarcoRaton();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoRaton extends JFrame { 	// OBJETO FUENTE (marco), por eso de aca se pone a la escucha
	
	public MarcoRaton() {
		
		setVisible(true);
		setBounds(300,150, 600,450);
		
// crear una instancia perteneciente a la clase que implementa MouseListener 
// indicar el objeto oyente.. pone a la escucha al oyente.
		EventosDeRaton eventoRaton = new EventosDeRaton();
		addMouseListener(eventoRaton); 		// añado evento a la escucha.
		
		addMouseMotionListener(eventoRaton); // PONER A LA ESCUCHA.
	}
	
}

//PUDEO HEREDAR DE MouseAdapter, para no implementar todos los metodos.
class EventosDeRaton implements MouseListener, MouseMotionListener { 	// oyente

	@Override
	public void mouseClicked(MouseEvent e) {
		/*
		System.out.println("Haz hecho click con el raton! por " + numero + "º ves");
		// variable de clase ejemplo propio.
		numero++;
		
		System.out.println("Coordenadas del click: " + "\n x= " + e.getX() + "\n y= " + e.getY());
		
		System.out.println("Contador de click seguidos: " + e.getClickCount());
		*/
	}

	@Override
	public void mousePressed(MouseEvent e) {
		/*
		System.out.println("se tiene presionada un boton del mouse");
		*/
		
		//System.out.println("Boton del mouse presionado (click izq, click der, o rueda central) : ");
		System.out.println("click: " + e.getModifiersEx());
		
		if (e.getModifiersEx() == 1024) {
			System.out.println("Haz hecho click izquierdo");
		}else if (e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK) { // constantes de clase, en ves de utilizar el numero.
			System.out.println("Haz hecho click con la rueda del mouse");
		}else if (e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) {
			System.out.println("Haz hecho click derecho");
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		System.out.println("levantaste el dedo del boton del mouse");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		System.out.println("acabas de entrar");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		System.out.println("Acabas de salir");
		
	}

// METODOS DE MouseMotionListener
	@Override
	public void mouseDragged(MouseEvent e) { // arrastrar
		
		System.out.println("Estas arrastrando el raton");
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) { // mover el raton
		
		System.out.println("estas moviendo el raton");
		
	}
	
	// variable de clase ejemplo propio
	//public static int numero = 1;
	
}

// SI QUERES MANEJAR SOLAMENTE UNO DE LOS METODOS O NO TODOS, DEBES EXTENDER DE 
// LA CLASE MouseAdapter.




