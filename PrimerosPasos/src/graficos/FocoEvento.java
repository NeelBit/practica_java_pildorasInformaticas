package graficos;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
// focos en componentes.
public class FocoEvento {

	public static void main(String[] args) {
		
		MarcoFoco miMarco = new MarcoFoco();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoFoco extends JFrame {
	
	public MarcoFoco() {
		
		setBounds(200, 100, 500, 400);
		setVisible(true);
		
//AGREGAR LAMINA AL MARCO
		add(new LaminaFoco());

	}
	
}

class LaminaFoco extends JPanel {
	
	
	public void paintComponent (Graphics g) {
		
		super.paintComponent(g);
		
		setLayout(null); 		// anulamos layout
		
		// instanciamos las dos variables pertenecientes a JTextField
		cuadro1 = new JTextField();
		cuadro2 = new JTextField();
		
		// le damos tamaño y posicion
		cuadro1.setBounds(100, 25, 200, 20);
		cuadro2.setBounds(100, 50, 200, 20);
		
		//agregamos a la lamina
		add(cuadro1);
		add(cuadro2);
		
		LanzaFoco elFoco = new LanzaFoco(); // intancia perteneciente a la clase oyente (LanzaFoco) 
		
		cuadro1.addFocusListener(elFoco); // como oyente utilizamos la intancia de la clase oyente.
		
	}
	
	private class LanzaFoco implements FocusListener { // clase interna para poder acceder a cuadro1 y cuadro2

		@Override
		public void focusGained(FocusEvent e) {
			
			
			
		}

		@Override
		public void focusLost(FocusEvent e) {	// esto sucede cuando el evento es que deje el foco.
			
			// solucion agregar la linea siguiente.
			cuadro1 = (JTextField) e.getSource();
			
			String email = cuadro1.getText();
			
			boolean comprobacion = false;
			
			for (int i=0; i < email.length(); i++) { 	// recorre la palabra
				// verifica @
				if (email.charAt(i) == '@' ) { 
					for (int j=0; j < email.length(); j++) {	// recorre y verifica .
						if (email.charAt(j) == '.' ) {
							comprobacion = true;
						}
					}
					
				}
				
			}
			
			if (comprobacion) {
				System.out.println("El mail introducido en cuadro 1 es correcto");
			}else {
				System.out.println("Mail incorrecto");
			}
			
			System.out.println("introduciste : " + email);
			
		}
	
		
	}
	
	
	
	//creamos/declaramos dos variables objetos pertenecientes a la clase JTextField, 
	//fuera del metodo paintComponent, por los ambitos de variables, es decir, para poder
	//acceder desde fuera del metodo a las variables.
	JTextField cuadro1;
	JTextField cuadro2;
	
	
}






