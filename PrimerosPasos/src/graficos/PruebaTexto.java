package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PruebaTexto {

	public static void main(String[] args) {
		
		MarcoTexto miMarco = new MarcoTexto();
		
		
		
	}

}

class MarcoTexto extends JFrame {
	
	public MarcoTexto() {
		
		setBounds(600, 300, 500, 350);
		LaminaTexto miLamina = new LaminaTexto();
		add(miLamina);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
}

class LaminaTexto extends JPanel {
	
	LaminaTexto() {
		
		setLayout(new BorderLayout()); 		// lamina princial con BorderLayout
		
		JPanel subLamina = new JPanel();	// creamos otra lamina
		
		subLamina.setLayout(new FlowLayout()); 		// la segunda lamina tiene FlowLayout
		
		
		
		resultado = new JLabel("", JLabel.CENTER); 		// constructor que permite alinear la etiqueta
		
		JLabel texto1 = new JLabel("Email: "); 		// texto
		
		subLamina.add(texto1);
		
		campo1 = new JTextField(20); 	// tiene ambito de metodo, se soluciona definiendo la variable dentro de la clase
		
		subLamina.add(campo1);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton miBoton = new JButton("Comprobar");
		
		DameTexto miEvento = new DameTexto(); 	// DameTexto la clase que va a responder al evento click en el boton
		
		miBoton.addActionListener(miEvento); 	// miBoton tiene que estar a la escucha de este evento en concreto.
		
		subLamina.add(miBoton); 			// agregamos boton a la lamina
		
		add(subLamina, BorderLayout.NORTH);			// add admite el segundo parametro para indicar posicion en BorderLayout
		
	}
	
	private class DameTexto implements ActionListener { 	// clase interna

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int correcto = 0;
			boolean punto = false;
			
			String email = campo1.getText().trim();
			
			for(int i=0; i < email.length(); i++) {
				
				if (email.charAt(i) == '@') {
					
					correcto++;			// cada ves que encuentre un @ aumenta uno el int correcto
					
					for(int j=0; j < email.length(); j++) {
						if (email.charAt(j) == '.') {
						
							punto=true;
						}
					}
				}
			}
			
			if (correcto==1 && punto) {
				
				resultado.setText("Correcto!");
				//System.out.println("Correcto!");
				
			}else {
				
				resultado.setText("Incorrecto");
				//System.out.println("Incorrecto");
			}
			
			//System.out.println(campo1.getText().trim()); 	// cuando hacemos click imprime en consola el contenido de campo1.
			
		}
		
		
		
	}
	
	private JTextField campo1;	 	// declaracion en ambito de clase, asi puedo usar en ambos metodos.
	
	private JLabel resultado; 		// 
	
}










