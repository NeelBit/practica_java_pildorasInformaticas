package arrayList;

import java.io.*;

public class UsoArraylista {

	private static char[] nombrePersona;

	public static void main(String[] args) {
		
		ArrayLista archivos = new ArrayLista(5);	// cantidad de elementos de tipo Object
		
		
		archivos.add("Juan");	// almaceno objeto tipo String
		
		archivos.add("pepito");
		archivos.add("fulanito");
		archivos.add("Menganito");
		
		// error de conversion, error en tiempo de ejecucion
		//archivos.add(new File("D:/Desktop/Nueva carpeta/texto prueba.txt"));
		
		
		String nombrePersona = (String)archivos.get(2);
			
		
		/* 
		
		archivos.add(new File("D:/Desktop/Nueva carpeta/Nuevo Documento de Word.docx"));
		archivos.add(new File("D:/Desktop/Nueva carpeta/texto prueba.txt"));
		
		File nombrePersona = (File)archivos.get(1);
		*/
		
		
		System.out.println(nombrePersona);
		
		
	}

}
