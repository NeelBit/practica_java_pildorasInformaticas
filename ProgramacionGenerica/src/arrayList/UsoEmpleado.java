package arrayList;

import java.util.*;

public class UsoEmpleado {

	public static void main(String[] args) {
		/*
		Empleado listaEmpleados[] = new Empleado[3];
		
		listaEmpleados[0] = new Empleado("Ana", 45, 2500);
		listaEmpleados[1] = new Empleado("Antonio", 55, 2000);
		listaEmpleados[2] = new Empleado("Maria", 25, 2600);
		*/
		
		// no olvidar parentesis al final, es porque tiene distintos constructores!
		ArrayList <Empleado> listaEmpleados = new ArrayList <Empleado>();
		
		//listaEmpleados.ensureCapacity(11); se utiliza para indicar la capacidad inicial. si vas
		// a utilizar mas de 10 elementos (que es el por defecto para el constructor vacio). 
		// mejorar rendimiento. lo que hace es reservar mas espacio en memoria inicial, pero mejora rendimiento dependiendo del caso.
		
		// añadir elementos a arraylist
		listaEmpleados.add(new Empleado("Ana", 45, 2500));
		
		Empleado Antonio = new Empleado("Antonio", 55, 2000);
		listaEmpleados.add(Antonio);
		
		listaEmpleados.add(new Empleado("Maria", 25, 2600));
		
		listaEmpleados.add(new Empleado("Jose", 35, 3000));
		
		// add(orden, elemento) orden desde 0 en adelante como todo array
		listaEmpleados.add(3, new Empleado("nel 3(4)", 25, 25000));
		
		// SET REEMPLAZA A ELEMENTO
		//listaEmpleados.set(4, new Empleado("nel5º", 26, 30000)); 
		
		//listaEmpleados.trimToSize(); si se esta seguro que no van a haber mas elementos, se usa para optimizar
		
		
		for (Empleado e: listaEmpleados) {
			
			System.out.println(e.dameDatos());
			
		}
		
		System.out.println("");
		
		System.out.println("La cantidad de elementos es: " + listaEmpleados.size());
		
		// metodos set y get de arraylist:
		System.out.println("En la posicion 0 de arraylist esta: " + listaEmpleados.get(0).dameDatos()); // posicion 0, ana
		
		//listaEmpleados.set(0, Antonio); 		// pongo(copio) en la posicion 0 a Antonio(1), y reemplaza a ana
		
		//System.out.println(listaEmpleados.get(0).dameDatos()); // pido nuevamente datos de la posicion 0, en este caso antonio
		
		System.out.println("");
		
		// recorrer arraylist con bucle for convencional:
		for (int i=0; i<listaEmpleados.size(); i++) {
			
			Empleado e = listaEmpleados.get(i);
			
			System.out.println(e.dameDatos());
			
		}
		
		// copiar arraylist a array normal:
		Empleado array[] = new Empleado[listaEmpleados.size()];
		
		listaEmpleados.toArray(array);
		
		System.out.println("");
		
		// RECORRER ARRAYLIST CON ITERATOR:
		
		Iterator <Empleado> miIterador = listaEmpleados.iterator();
		
		while (miIterador.hasNext()) { 	// mientras tenga elemento siguiente devuelve true
			
			System.out.println(miIterador.next().dameDatos()); 	// recorro elementos.
			
		}
		
		
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




