package ficheros_Directorios;

import java.io.*;

public class AccesoFicheros {

	public static void main(String[] args) {
		
		// para hacer rutas independiente de la plataforma se puede usar:
		// "D:" + File.separator + "Desktop" + File.separator + "Nueva carpeta"
		File ruta = new File("D:/Desktop/Nueva carpeta");
		
		// mostrar ruta e imprimir si existe o no:
		System.out.println(ruta.getAbsolutePath());
		System.out.println(ruta.exists());
		
		// guardamos en un array la lista de los nombres de archivos y directorios que hay en el objeto ruta
		String[] nombresArchivos = ruta.list();
		
		// imprimimos en consola el contenido de nombresArchivos, con for each
		for (String lista: nombresArchivos) {
			
			System.out.println(lista);
			
			//		ruta padre, ruta
			File f = new File(ruta.getAbsoluteFile(), lista);
			
			if (f.isDirectory()) {
				
				// guardamos en un array el contenido de la subCarpeta
				String[] archivosSubCarpeta = f.list();
				
				// recorremos el array anterior:
				for (String listaSubCarpeta: archivosSubCarpeta) {
								// puse los espacios para distinguir por ejemplo que se encuentran dentro
					System.out.println("   " + listaSubCarpeta);
					
					
				}
				
			}
			
		}
		
	}

}
