package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PruebaComboBox {

	public static void main(String[] args) {
		
		MarcoCombo miMarco = new MarcoCombo();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
	}

}

class MarcoCombo extends JFrame {
	
	public MarcoCombo() {
		
		setBounds(500, 300, 500, 350);
		LaminaCombo miLamina = new LaminaCombo();
		add(miLamina);
		
	}
	
}

class LaminaCombo extends JPanel {
	
	public LaminaCombo() {
		
		setLayout(new BorderLayout()); 	// lamina principal tipo borderlayout
		texto = new JLabel("En un lugar de la Mancha cuyo nombre no recuerdo..."); 	// texto
		texto.setFont(new Font("Serif", Font.PLAIN, 18)); 	// propiedades de la letra del texto
		add(texto, BorderLayout.CENTER); 	// ubicamos el texto en el centro de la lamina principal
		
		// creamos segunda lamina donde va a estar el JComboBox
		JPanel laminaNorte = new JPanel();
		
		// iniciamos combo
		miCombo = new JComboBox();
		
		miCombo.setEditable(true); 	// --> ESTO ES PARA HACER EDITABLE LOS ITEMS
		
		// agregamos items al combo
		miCombo.addItem("Serif");
		miCombo.addItem("Arial");
		miCombo.addItem("Sans Serif");
		miCombo.addItem("Monospaced");
		miCombo.addItem("Dialog");
		
		/* ponemos a la escucha miCombo
		EventoCombo miEvento = new EventoCombo();
		miCombo.addActionListener(miEvento);
		*/
		
		// agregamos a la laminaNorte
		laminaNorte.add(miCombo);
		
		// agregamos laminaNorte a la lamina principal.
		add(laminaNorte, BorderLayout.NORTH);
		
		// ponemos al combo a la escucha de un evento click, en una linea
		miCombo.addActionListener(new EventoCombo());
		
	}
	
	//clase interna para gestionar eventos.
	private class EventoCombo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			texto.setFont(new Font((String)miCombo.getSelectedItem(), Font.PLAIN, 18));
			
		}
		
	}
	
	private JLabel texto;
	private JComboBox miCombo; 	// declaramos combobox
	
}







