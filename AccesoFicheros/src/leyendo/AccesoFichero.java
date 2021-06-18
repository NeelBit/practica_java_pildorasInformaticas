package leyendo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AccesoFichero {

	public static void main(String[] args) {
		
		LeerFichero fichero1 = new LeerFichero();
		
		fichero1.lee();
		
	}

}

class LeerFichero {
	
	public void lee() {
		
		try {
			
			//lee archivo
			FileReader entrada = new FileReader("D:/Desktop/ejemplo.txt");
			
			// UTILIZANDO BUFFERED
			BufferedReader miBuffer = new BufferedReader(entrada);
			
			String linea = miBuffer.readLine();
			
			while (linea != null) { 	// salto de linea final interpreta como null
				
				System.out.println(linea);
				// cuando entra el bucle almacena en el string la primera linea del buffer
				linea = miBuffer.readLine();
				
				
				
			}
			
			
			// almacena en c la codificación de los caracteres en bytes. DEVUELVE -1 SI LLEGAMOS AL FINAL
			/*int c = entrada.read();
			
			while (c != -1) {
				
				// casting de bytes a caracteres
				char letra = (char)c;
				
				System.out.print(letra);
				
				// GUARDA EN C Y SE REPITO EL CICLO A MENOS QUE SEA -1 (cuando llega al final del stream devuelve -1)
				c = entrada.read();
				
			}
			*/
			
			
			
			
			// se cierra conexion streams
			entrada.close();
			
		} catch (FileNotFoundException e) { 	// excepcion para FileReader
			
			System.out.println("No se ha encontrado el archivo: " + e.getMessage());
			
		} catch (IOException e) { 				// excepcion para el metodo read() de InputStreamReader
			
			// si cierro el stream en el ciclo while por ejemplo lanza esta excepcion
			System.out.println("No termino de leerse el archivo: " + e.getMessage());
			
		}// NO ES NECESARIO FINALLY YA QUE EL FLUJO DE DATOS SOLO SE VA A ABRIR
		// SI LAS COSAS VAN BIEN. ENTONCES EL LUGAR ADECUADO PARA CERRAR STREAM ES
		// AL FINAL DEL TRY.
		
		
	}
	
}






