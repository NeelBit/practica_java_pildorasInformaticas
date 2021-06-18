package excepciones;

import javax.swing.JOptionPane;

public class CompruebaMailCreandoExcepcion {

	public static void main(String[] args) {
		
		String mail = JOptionPane.showInputDialog("Introduce mail: ");
		
		// al heredar de la clase Exception nuestra excepcion, nos obliga a utilizar try catch
		try { 	
			examinaMail(mail);
		}catch (LongitudMailExceptionPropia e) {
			
			System.out.println("La longitud del mail no es valida, ingresó menos de 5 caracteres");
			
			e.printStackTrace(); 	// imprime la pila de llamadas de ese error.
			
		}
		
		
	}

	
	static void examinaMail(String mail ) throws LongitudMailExceptionPropia {
		
		int arroba = 0;
		boolean punto = false;
		
		if (mail.length() <= 4) {
			
			// indicamos cuando tiene que lanzar la exception propia
			
			// si nuestra clase hereda de RuntimeException y no capturamos con try/catch, en la consola devuelve:
			// Exception in thread "main" excepciones.LongitudMailExceptionPropia: Numero de caracteres inferiores a 5
			
			throw new LongitudMailExceptionPropia("Numero de caracteres inferiores a 5"); // si queres personalizar el msg de error utilizar el constructor con String
			
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

// si queremos obligar a que capturen el error, hay que heredar de Exception.

class LongitudMailExceptionPropia extends Exception { // al heredar de la clase exception nos obliga a utilizar try catch
	
	// se suele hacen 2 constructores uno sin parametros y otro con String
	
	public LongitudMailExceptionPropia() {}
	
	public LongitudMailExceptionPropia(String msjError) {
		
		super(msjError); 	// le pasamos al constructor de la clase padre (Exception)
		
		
	}
	
}



