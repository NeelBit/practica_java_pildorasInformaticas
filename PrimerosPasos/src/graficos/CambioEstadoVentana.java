package graficos;

import javax.swing.*;
import java.awt.Frame;
import java.awt.event.*;

public class CambioEstadoVentana {

	public static void main(String[] args) {
		
		MarcoEstado miMarco = new MarcoEstado();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}

}

class MarcoEstado extends JFrame {
	
	public MarcoEstado() {
		
		setVisible(true);
		setBounds(300, 200, 500, 300);
		
		CambiaEstado nuevoEstado = new CambiaEstado();
		
		addWindowStateListener(nuevoEstado);
		
		
	}
	
}

class CambiaEstado implements WindowStateListener {
	
	public void windowStateChanged(WindowEvent e) { 	// dentro de este metodo si lo que quiero es que algo se desencadene cuando la ventana cambie su estado.
		
		System.out.println("La ventana cambio de estado");
		
		//System.out.println("El estado de la ventana es: " + e.getNewState()); 	//nos devulve un int con la constante que indica el estado actual.
		
		if (e.getNewState() == Frame.MAXIMIZED_BOTH) { 		// si el nuevo estado de la pantalla es estado completo (6).
			
			System.out.println("La ventana esta a pantalla completa");
			
		}else if (e.getNewState() == Frame.ICONIFIED) { 	// si se minimiza
			System.out.println("Ventana minimizada");
		}
		
		
	}
	
}



