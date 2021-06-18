package ficheros_Directorios;

import java.io.File;

public class Eliminar {

	public static void main(String[] args) {
		
		File ficheroAEliminar = new File("D:/Desktop/Nueva carpeta/ArchivoCreadoJava.txt");
		
		System.out.println(ficheroAEliminar.exists());
		
		ficheroAEliminar.delete();
		
	}

}
