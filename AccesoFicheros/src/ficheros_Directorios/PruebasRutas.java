package ficheros_Directorios;

import java.io.File;

public class PruebasRutas {

	public static void main(String[] args) {
		
		// creamos objeto, si inventamos un nombre no crea fichero y nos devuelva false mas abajo.
						// si comprobamos un directorio/fichero como bin, devolvera true. Por defecto 
		// comprueba desde el directorio del proyecto.
		File archivo = new File("bin");
		
		// nos imprime la ruta absoluta del archivo
		System.out.println(archivo.getAbsolutePath());
		
		// comprobar que fichero existe o no existe: true o false
		System.out.println(archivo.exists());
		
	}

}
