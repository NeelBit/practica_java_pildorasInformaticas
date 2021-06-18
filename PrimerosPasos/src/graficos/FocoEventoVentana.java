package graficos;


import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class FocoEventoVentana extends JFrame implements WindowFocusListener{

	public static void main(String[] args) {
		
		FocoEventoVentana miV = new FocoEventoVentana();
		miV.iniciar();
		
	}
	
	public void iniciar() {		// metodo para construir los marcos
		
		marco1 = new FocoEventoVentana();
		marco2 = new FocoEventoVentana();
		
		marco1.setVisible(true);
		marco2.setVisible(true);
		
		marco1.setBounds(150, 100, 400, 300);
		marco2.setBounds(600, 100, 400, 300);
		
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // dispose_on_close para que no cierre el programa
		
		marco1.addWindowFocusListener(this); 	//para indicar que es propio objeto la propia clase.
		marco2.addWindowFocusListener(this);
		
		
	}
	

	@Override
	public void windowGainedFocus(WindowEvent e) {	// ganar el foco
		
		if (e.getSource() == marco1) {
			marco1.setTitle("foco en el marco1");
		}else {
			marco2.setTitle("Tengo el foco");
		}
	}

	@Override
	public void windowLostFocus(WindowEvent e) {	// perder el foco
		
		if (e.getSource() == marco1) {
			marco1.setTitle("");
		}else {
			marco2.setTitle("");
		}
		
	}

	
	FocoEventoVentana marco1;
	FocoEventoVentana marco2;
	
	
}
