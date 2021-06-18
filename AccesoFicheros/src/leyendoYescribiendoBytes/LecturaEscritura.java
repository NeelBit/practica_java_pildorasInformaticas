package leyendoYescribiendoBytes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LecturaEscritura {

	public static void main(String[] args) {
		
		int contador = 0;
		
		int datosEntrada[] = new int[59929]; 	// se almacena la copia del archivo en bytes
		
		try {
			
			FileInputStream miImagenLectura = new FileInputStream("D:/Desktop/imagen.png");
			
			boolean finalArchivo = false;
			
			while (!finalArchivo) { 	// osea mientras finalArchivo true
				
				int byteEntrada = miImagenLectura.read(); 	// almacena byte a byte. al final devuelve -1
				
				if (byteEntrada != -1) {
					
					datosEntrada[contador] = byteEntrada;
					
				}else {	// si llega al final, osea byteEntrada == -1:
					
					finalArchivo = true;
					
				}
				
				/*if (byteEntrada == -1) {
					
					finalArchivo = true;
					
				}*/
				
				System.out.println(datosEntrada[contador]);
				
				contador++;
				
			}
			
			miImagenLectura.close();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Archivo no encontrado: " + e.getMessage());
			
		} catch (IOException e) {
			
			System.out.println("Excepcion de tipo I/O: " + e.getMessage());
			
		}
		
		System.out.println();
		
		System.out.println(contador);
		
		// creamos fichero nuevo, copia del primero:
		creaFichero(datosEntrada);
		
	}
	
	// static porque el main es estatico (?)
	static void creaFichero(int datosNuevosFicheros[] ) {
		
		try {
			
			FileOutputStream ficheroNuevo = new FileOutputStream("D:/Desktop/copiaDeImagen.png"); // donde se creara el fichero nuevo
			
			for (int i=0; i<datosNuevosFicheros.length; i++) {
				
				ficheroNuevo.write(datosNuevosFicheros[i]);
				
			}
			
			ficheroNuevo.close();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Archivo no encontrado: " + e.getMessage());
			
		} catch (IOException e) {

			System.out.println("Excepcion de I/O: " + e.getMessage());
		}
		
	}
	
}
