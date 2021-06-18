package excepciones;

import javax.swing.JOptionPane;

public class CompruebaMail {

	public static void main(String[] args) {
		
		String mail = JOptionPane.showInputDialog("Introduce mail: ");
		
		// Maneja la excepcion que generamos, ArrayIndexOutOfBoundsException si mail es <=4
		try {
			
			examinaMail(mail);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			
			JOptionPane.showMessageDialog(null, "El mail contiene pocos caracteres para ser válido");
			
		}
		
	}

	static void examinaMail(String mail ) throws ArrayIndexOutOfBoundsException { // si utilizamos throw, deberiamos indicar que puede lanzar una excepcion con throws
		
		int arroba = 0;
		boolean punto = false;
		
		// clausula throw  NO THROWS - generar un maneja de error manualmente (excepciones de clases conocidos)
		if (mail.length() <= 4) {
			
			// no es la mas aducuada por sirve de ejemplo:
			// si escribimos un mail <=4 caracteres nos tira la exception de abajo
			
			/*
			ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException();
			throw e;
			*/
			
			// en una linea, es mas comun hacerlo:
			throw new ArrayIndexOutOfBoundsException();
			
		}else {
			
			for (int i = 0; i < mail.length(); i++) {
				
				if (mail.charAt(i) == '@') {
					
					arroba++;
					
				}
				
				if (mail.charAt(i) == '.') {
					
					punto=true;
					
				}
			}
			
			if ((arroba==1) && (punto == true)) {
				
				JOptionPane.showMessageDialog(null, "El mail es correcto");
				
			}else {
				
				JOptionPane.showMessageDialog(null, "El mail es Incorrecto", "error" , JOptionPane.ERROR_MESSAGE);
				
			}
		}
		
	}
	
	
	
}
