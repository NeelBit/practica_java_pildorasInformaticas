package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

public class EventosVentanas {

	public static void main(String[] args) {
		
		MarcoVentana miMarco = new MarcoVentana();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setTitle("Frame 1");
		miMarco.setBounds(200, 200, 400, 350);
		
		
		MarcoVentana miMarco2 = new MarcoVentana();
		miMarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		miMarco2.setTitle("Frame 2");
		miMarco2.setBounds(700, 200, 400, 350);
		
		
	}

}

class MarcoVentana extends JFrame {
	
	public MarcoVentana() {
		
		//setTitle("Respondiendo");
		//setBounds(400, 250, 500, 400);
		setVisible(true);
		
		/*
		M_Ventana oyenteVentana = new M_Ventana(); 	// intancia de la la clase que implementa WindowListener
		
		addWindowListener(oyenteVentana); 	// pone a nuestra ventana a la escucha
		*/
		
		// simplificar código:
		addWindowListener(new M_Ventana());
		
		
	}
	
	
	
}


class M_Ventana extends WindowAdapter { 		// WindowAdapter para no escribir todos los metodos de una interfaz
	
	public void windowIconified (WindowEvent e) {
		
		System.out.println("Ventana minimizada");
		
	}
	
	/*
	public void windowActivated(WindowEvent e) {
		
		System.out.println("Ventana activada!");
		
	}
	
	public void windowClosed(WindowEvent e) {
		
		System.out.println("La ventana ha sido cerrada");
		
	}
	
	public void windowClosing(WindowEvent e) {
		
		System.out.println("Cerrando ventana");
		
	}
	
	public void windowDeactivated(WindowEvent e) {
		
		System.out.println("Ventana desactivada");
		
	}
	
	public void windowDeiconified(WindowEvent e) {
		
		System.out.println("Ventana restaurada");
		
	}
	
	public void windowIconified(WindowEvent e) {
		
		System.out.println("Ventana minimizada!!");
		
	}
	
	public void windowOpened(WindowEvent e) {
		
		System.out.println("Ventana abierta");
		
	}
	
	*/
	
}



