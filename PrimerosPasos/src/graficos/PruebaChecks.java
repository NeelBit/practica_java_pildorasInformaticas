package graficos;

import java.awt.*;
import java.awt.event.*; 		// checkBox tienen que estar a la escucha
import javax.swing.*;

public class PruebaChecks {

	public static void main(String[] args) {
		
		MarcoCheck miMarco = new MarcoCheck();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoCheck extends JFrame {
	
	public MarcoCheck() {
		
		setBounds(500, 250, 550, 300);
		LaminaCheck miLamina = new LaminaCheck();
		add(miLamina);
		setVisible(true);
	}
	
}

class LaminaCheck extends JPanel {
	
	public LaminaCheck() {
		
		setLayout(new BorderLayout());
		
		Font miLetra = new Font("Serif", Font.PLAIN, 24);
		
		texto = new JLabel("En un lugar de la mancha de cuyo nombre..."); 	// esta es la frase a la que vamos a cambiar las características.
		
		texto.setFont(miLetra); 		// le decimos a texto que tenga la letra que le dijimos.
		
		JPanel laminaTexto = new JPanel();
		
		laminaTexto.add(texto); 		// añadimos JLabel texto a lamina texto.
		
		add(laminaTexto, BorderLayout.CENTER);
		
		// añadimos checkbox ahora a otra lamina y lo ponemos en la zona sur
		check1 = new JCheckBox("Negrita");
		check2 = new JCheckBox("Cursiva");
		
		// ponemos a la escucha los checks
		check1.addActionListener(new ManejaChecks());
		check2.addActionListener(new ManejaChecks());
		
		//creamos la lamina donde van a ir estos JCheckBox
		JPanel laminaChecks = new JPanel();
		//añadimos
		laminaChecks.add(check1);
		laminaChecks.add(check2);
		
		add(laminaChecks, BorderLayout.SOUTH);
		
	}
	
	private class ManejaChecks implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int tipo = 0; 		// al ser constantes de clase que devuelven entero se puede hacer esto para hacer mas efectivo.
			
			if (check1.isSelected()) {
				
				tipo += Font.BOLD;
				
			}
			
			if (check2.isSelected()) {
				
				tipo += Font.ITALIC;
				
			}
			
			texto.setFont(new Font("Serif", tipo, 24));
			
		}
		
		
		
	}
	
	private JLabel texto;
	private JCheckBox check1, check2;
	
}




