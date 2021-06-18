package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class EntradaDatos {

	public static void main(String[] args) {
		
		System.out.println("Que desea hacer: ");
		System.out.println("1. Introducir datos.");
		System.out.println("2. Salir.");
		
		Scanner entrada = new Scanner(System.in);
		
		int desicion = entrada.nextInt();
		
		// lo logico es que la captura de la escepcion se haga al llamar al metodo
		
		if (desicion == 1) {
			
			try {
				
				pedirDatos();
				
			}catch (InputMismatchException e) {
				
				System.out.println("Introduce un dato valido!");
				
			}
			
		}else {
			
			System.out.println("Adios!");
			System.exit(0);
			
		}
		
		entrada.close();
		
		
	}

	static void pedirDatos() throws InputMismatchException{ 	// metodo que lanza excepcion. con try catch lo capturamos.
		
		// no tiene sentido capturar excepciones dentro de metodos.
		//try {
			
		Scanner entrada = new Scanner (System.in);
		
		System.out.println("Introduce tu nombre: ");
		String nombre = entrada.nextLine();
		
		System.out.println("Introduce tu edad: ");
		int edad = entrada.nextInt();
		
		System.out.println("Hola " + nombre + " el año que viene tendras " + (edad+1) + " años.");
		
		entrada.close();
		
		
		
		//}catch(InputMismatchException e) { 	// Exception e (si no te queres complicar la vida)
			
		//	System.out.println("Introduce un dato válido");
			
			
		//}
		
		System.out.println("Hemos terminado!");
		
	}
	
	
}
