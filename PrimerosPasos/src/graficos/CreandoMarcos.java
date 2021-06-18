package graficos;

import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.*;

public class CreandoMarcos {

	public static void main(String[] args) {
		
		miMarco marco1 = new miMarco();
		
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}


class miMarco extends JFrame {
	
	public miMarco() {
		// setSize(500, 300);
		//setLocation(500, 300);					// arranca desde la esquina superior izquierda
		
		setBounds(500, 100, 600, 500); 				// x (orizontal,y (vertical), ancho, alto
		
		//setResizable(false);						// evitar la redimension de la ventana
		
		//setExtendedState(Frame.MAXIMIZED_BOTH);	// abrir maximizado
		
		setTitle("título título 2");
		
	}
	
}