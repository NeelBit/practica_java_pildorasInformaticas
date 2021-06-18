package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.*;

public class CampoPassword {

	public static void main(String[] args) {
		
		MarcoPassword miMarco = new MarcoPassword();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}

class MarcoPassword extends JFrame {
	
	public MarcoPassword() {
		
		setBounds(500, 250, 500, 400);
		LaminaPassword miLamina = new LaminaPassword();
		add(miLamina);
		setVisible(true);
	}
	
}

class LaminaPassword extends JPanel {
	
	public LaminaPassword() {
		
		setLayout(new BorderLayout()); 		// lamina principal tipo BorderLayout
		
		JPanel laminaSuperior = new JPanel(); 	// creamos otra lamina para poner grilayout
		laminaSuperior.setLayout(new GridLayout(2, 2)); 	// GridLayout de 2 x 2
		add(laminaSuperior, BorderLayout.NORTH); 	// añadimos y le decimos que la segunda lamina va a estar en el borde superior.
		
		// JLabel para crear etiquetas:
		JLabel etiqueta1 = new JLabel("Usuario: ");
		JLabel etiqueta2 = new JLabel("Password: ");
		
		//cuadro de texto JTextField
		JTextField c_usuario = new JTextField(15); 
		
		//contraseña --> salen arteriscos en ves de contraseña
		c_contra = new JPasswordField(15);
		
		// PONER A LA ESCUCHA EL EVENTO EN EL CUADRO DE CONTRASEÑA:
		CompruebaPass miEvento = new CompruebaPass();
		c_contra.getDocument().addDocumentListener(miEvento); 		// en un mismo paso
		
		
		//añadir elementos a la lamina superior (gridlayout)
		laminaSuperior.add(etiqueta1);
		laminaSuperior.add(c_usuario);
		laminaSuperior.add(etiqueta2);
		laminaSuperior.add(c_contra);
		
		// boton abajo en la lamina principal:
		JButton enviar = new JButton("Enviar");
		add(enviar, BorderLayout.SOUTH);
		
	}
	
	private class CompruebaPass implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {		// comprobar la longitud de la contraseña
			
			colores();
			/*
			char [] pass; 		// getPassword devuelve array de char
			pass = c_contra.getPassword();
			
			
			//evaluar longitud del array:
			if(pass.length < 8 || pass.length > 12) { // si pass es menor que 8 ó pass es mayor que 12
				
				// en caso de que sea verdad resaltar en rojo.
				c_contra.setBackground(Color.RED);
				
			}else {		// si no le decimos esto lo va a resaltar en rojo igual
				
				c_contra.setBackground(Color.WHITE);
				
			}
			*/
			/*
			caracteres++;
			if (caracteres < 8 || caracteres > 12) {
				c_contra.setBackground(Color.RED);
			}else {
				c_contra.setBackground(Color.WHITE);
			}
			*/
		}

		@Override
		public void removeUpdate(DocumentEvent e) { 		// para comprobar cuando se borra tambien
			/*
			char [] pass; 		// getPassword devuelve array de char
			pass = c_contra.getPassword();
			
			//evaluar longitud del array:
			if(pass.length < 8 || pass.length > 12) { // si pass es menor que 8 ó pass es mayor que 12
				
				// en caso de que sea verdad resaltar en rojo.
				c_contra.setBackground(Color.RED);
				
			}else {		// si no le decimos esto lo va a resaltar en rojo igual
				
				c_contra.setBackground(Color.WHITE);
				
			}
			*/
			//caracteres--;
			colores();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			
			
			
		} 	
		
		//private int caracteres;
		
	}
	
	JPasswordField c_contra; // tiene que declararse aca para poder usarse en varios metodos.
	
	private void colores() { 		// PROPIO, hago una sola función y la llamo cuando sea necesario.
		
		char [] pass; 		// getPassword devuelve array de char
		pass = c_contra.getPassword();
		
		//evaluar longitud del array:
		if(pass.length < 8 || pass.length > 12) { // si pass es menor que 8 ó pass es mayor que 12
			
			// en caso de que sea verdad resaltar en rojo.
			c_contra.setBackground(Color.RED);
			
		}else {		// si no le decimos esto lo va a resaltar en rojo igual
			
			c_contra.setBackground(Color.WHITE);
			
		}
		
	}
	
}








