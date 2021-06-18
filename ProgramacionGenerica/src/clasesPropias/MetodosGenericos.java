package clasesPropias;

import java.util.GregorianCalendar;

public class MetodosGenericos {

	public static void main(String[] args) {
		
		String[] nombres = {"Juan", "Mengano", "Fulanito", "Pedrito"};
		
		Integer[] numeros = {22, 14, 1, 44, 33}; 		// int no funciono
		
		GregorianCalendar fechas[] = {new GregorianCalendar(2005, 3, 30), new GregorianCalendar(2000, 8, 18), new GregorianCalendar(1994, 0, 12)};
		// cuando imprime en consola el mes, jan enero arranca en el 0
		
		
		// metodo static recibe parametro de array de string, y almaceno en un string:
		//String elementos = MisMatrices.getElementos(nombres);
		
		//System.out.println(elementos);
		
		/*
		
		// primero nuestro metodo recibe un array de String, luego un array de tipo Empleado
		
		Empleado listaEmpleados[] = {new Empleado("pepe",20, 2020), new Empleado("fulano", 30, 3000)};
		
		System.out.println("La lista de Empleados es: " + MisMatrices.getElementos(listaEmpleados));
		*/
		
		// probar metodo getElementoMenor:
		System.out.println(MisMatrices.getElementoMenor(nombres));
		
		System.out.println(MisMatrices.getElementoMenor(numeros));
		
		System.out.println(MisMatrices.getElementoMenor(fechas).getTime()); 	// getTime para que nos pase a fecha visible el elemento.
		
	}

}

// clase que nos va a devolver la longitud que tenga un array que le pasemos por parametro a 
// nuestro metodo generico, el metodo deberá ser capaz de recibir arrays de distintos tipos.
class MisMatrices {
	
	// publico: para que sea visible desde otras clases, static para no necesitar una instancia para usarlo, <T> por convencion tipos,
	// este nos va a devolver un String. Por parametros recibe un array que no sabemos el tipo.
	/*public static <T> String getElementos(T[] a) {
		
		return "El array tiene: " + a.length + " elementos";
		
	}*/
	
	
	// metodo generico que nos devuelva el objeto menor de un array:
	// T porque es generico lo que va a devolver
	public static <T extends Comparable> T getElementoMenor(T[] a) { 	// para poder utilizar compareTo, que es un metodo
																	// de la interfaz Comparable, debemos indicar que el tipo herede de eso
		if (a.length == 0 || a==null) {								// debe extender. Solo se puede utilizar para instancias de clases que implementes Comparable, por eso no sirve para Empleado, ni tipos int (primitivos)
			
			return null;
			
		}
		
		// comparar objetos genericos entre si con compareTo. T tipo . elementoMenor nombre de variable .
		T elementoMenor = a[0]; // en principio va a ser el de la posicion 0 del array que estamos pasando por parametro
		
		for (int i=1; i < a.length; i++) {
			
			if (elementoMenor.compareTo(a[i]) > 0) {
				
				elementoMenor = a[i];
				
			}
			
		}
		
		return elementoMenor;
		
	}
	
	
}

class Empleado {
	
public Empleado(String nombre, int edad, int sueldo) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
		
	}
	
	public String dameDatos() {
		
		return "El empleado se llama: " + nombre + ". Tiene: " + edad + " años." + " Y su sueldo es de: " + sueldo;
		
	}
	
	private String nombre;
	private int edad, sueldo;
	
}