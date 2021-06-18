package graficos;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

// menu emergente que cuando se haga click derecho en la lamina salga el menu.

public class MarcoMenuEmergente {

	public static void main(String[] args) {
		
		MarcoPopup marcoEmergente= new MarcoPopup();
		marcoEmergente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marcoEmergente.setVisible(true);
		
	}

}

class MarcoPopup extends JFrame {
	
	public MarcoPopup() {
		
		setBounds(350, 250, 450, 400);
		LaminaPopup laminaEmergente = new LaminaPopup();
		add(laminaEmergente);
		
	}
	
}

class LaminaPopup extends JPanel {
	
	public LaminaPopup() {
		
		JPopupMenu emergente = new JPopupMenu();
		
		JMenuItem opcion1 = new JMenuItem("Opcion1");
		JMenuItem opcion2 = new JMenuItem("Opcion2");
		JMenuItem opcion3 = new JMenuItem("Opcion3");
		
		emergente.add(opcion1);
		emergente.add(opcion2);
		emergente.add(opcion3);
		
		// estamos en la lamina, y señalamanos que desde aca va a funcionar
		setComponentPopupMenu(emergente);
		
	}
	
}






