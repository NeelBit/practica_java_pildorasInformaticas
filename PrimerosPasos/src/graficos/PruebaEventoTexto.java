package graficos;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;


public class PruebaEventoTexto {

	public static void main(String[] args) {
		
		MarcoPruebaEventoTexto miMarcoPrueba = new MarcoPruebaEventoTexto();
		miMarcoPrueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}


class MarcoPruebaEventoTexto extends JFrame {
	
	public MarcoPruebaEventoTexto() {
		
		setBounds(500, 100, 500, 400);
		LaminaPruebaEventoTexto miLaminaPrueba = new LaminaPruebaEventoTexto();
		add(miLaminaPrueba);
		setVisible(true);
		
	}
	
}

class LaminaPruebaEventoTexto extends JPanel {
	
	public LaminaPruebaEventoTexto() {
		
		JTextField miCampo = new JTextField(20);
		
		EscuchaTexto evento = new EscuchaTexto(); 		// objeto evento
		
		//poner a la escucha doc 
		Document miDoc = miCampo.getDocument(); 		// almacenar en un objeto tipo Document el contenido del JTextField
		miDoc.addDocumentListener(evento);			
		
		
		
		add(miCampo);
		
		
	}
	
	private class EscuchaTexto implements DocumentListener { 	// escuchar eventos de JTextField

		@Override
		public void insertUpdate(DocumentEvent e) {

			System.out.println("Haz introducido texto");
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {

			System.out.println("Haz borrado texto");
			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {

			
			
		}
		
		
		
	}
	
	
}




