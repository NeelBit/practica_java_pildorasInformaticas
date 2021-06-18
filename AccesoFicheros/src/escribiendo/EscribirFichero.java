package escribiendo;

import java.io.*;

public class EscribirFichero {

	public static void main(String[] args) {
		
		escribiendo texto = new escribiendo();
		texto.escribe();
		
	}

}

class escribiendo {
	
	public void escribe() {
		
		String frase = "Esto es una prueba de escritura";
		
		try {
											// si ya existe el fichero con , true como segundo parametro agrega el texto al final
			FileWriter escritura = new FileWriter("D:/Desktop/ejemploEscritura.txt");
			
			// escritura.write(frase); NO ES NECESARIO EL BUCLE FOR creo.
			
			// haciendo con buffered:
			
			BufferedWriter bufferEscritura = new BufferedWriter(escritura);
			
			
			bufferEscritura.write(frase);
			
			bufferEscritura.flush();
			
			
			/*/
			for (int i=0; i<frase.length(); i++) {
				
				escritura.write(frase.charAt(i));
				
			}
			*/
			bufferEscritura.close(); // no se si hay que cerrar tambien?
			escritura.close();
			
		} catch (IOException e) {
			
			System.out.println("El fichero no se pudo crear: " + e.getMessage());
			
		}
			
			
		
	}
	
}