package ficheros_Directorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creando {

	public static void main(String[] args) {
		
		File nuevoFichero = new File("D:" + File.separator + "Desktop" + File.separator + "Nueva carpeta" + File.separator + "ArchivoCreadoJava.txt");
		
		String archivoDestino = nuevoFichero.getAbsolutePath();
		
		// crear directorio, CarpetaCreada
		//nuevoFichero.mkdir();
		
		// crear fichero:
		try {
			
			nuevoFichero.createNewFile();
			
		} catch (IOException e) {
			
			System.out.println("Error: " + e.getMessage());
			
		}
		
		// escribir en fichero:
		Escribiendo accedeEscribe = new Escribiendo();
		
		accedeEscribe.escribir(archivoDestino);
		
		
	}

}

class Escribiendo {
	
	public void escribir(String rutaArchivo) {
		
		String frase = "Esto es un ejemplo!";
		
		try {
			
			// indicamos que vamos a escribir
			FileWriter escritura = new FileWriter(rutaArchivo);
			
			// recorrer con bucle for:
			
			// no es necesario el bucle (?)
			
			/*for (int i=0; i<frase.length(); i++) {
				
				//escritura.write(frase);
				escritura.write(frase.charAt(i));
				
				
				
			}*/
			escritura.write(frase);
			
			escritura.close();
			
		} catch (IOException e) {

			System.out.println("Error: " + e.getMessage());
			
		}
		
		
		
	}
	
}





