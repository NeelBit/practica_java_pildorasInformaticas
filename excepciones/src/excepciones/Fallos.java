package excepciones;

import javax.swing.JOptionPane;

public class Fallos {

	public static void main(String[] args) {
		
		int [] miMatriz = new int[5];
		
		miMatriz[0] = 5;
		miMatriz[1] = 38;
		miMatriz[2] = -15;
		miMatriz[3] = 92;
		miMatriz[4] = 71;
		// miMatriz[5] = 68; permite colocar, sin embargo tira una excepcion y no ejecuta el codigo de abajo
		// ArrayIndexOutOfBoundsException   --> runtimeException (excepcion no comprobada)
		
		for (int i = 0; i<5; i++) {
			
			System.out.println("Posición: " + i + " valor: " + miMatriz[i]);
			
		}
		
		//peticion de datos personales:
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre: ");
		
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad: "));
		
		System.out.println("Hola " + nombre + " tienes " + edad + " años." + " El programa finalizó");
		
	}

	
	
	// cuando java tiene un error comprobado, osea IOException, nos obliga a tratar el error. (try/catch)
	
	// si la excepcion hereda de RuntimeException es una excepcion no comprobada, entonces esta en nuestras manos 
	// solucionarlo, y no lo detecta java antes de compilar, ni el IDE.
}
