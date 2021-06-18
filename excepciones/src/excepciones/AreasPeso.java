package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

// el uso mas común de finally es para cerrar una conexion.

public class AreasPeso {

	public static void main(String[] args) {
		
		int base, altura, lado, radio;
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Elige una opción: \n1_ Cuadrado \n2_ Rectángulo \n3_ Triángulo \n4_ Círculo");
		
		try {
			
			figura = entrada.nextInt();

			//entrada.close();
			
		}catch (InputMismatchException e) {
			
			System.out.println("No ingresaste un numero entero");
			
		}finally { 	// intruccion que se va a ejecutar si o si, se lance o no la excepcion.
			
			entrada.close();
			
		}
		
		
		
		switch (figura) {
			
		case 1:
			
			lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce lado"));
			
			System.out.println(Math.pow(lado, 2));
			
			break;
			
		case 2: 
			
			base = Integer.parseInt(JOptionPane.showInputDialog("Introduce base"));
			altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce altura"));
			
			System.out.println("El área del rectangulo es: " + base*altura);
			
			break;
			
		case 3:
			
			base = Integer.parseInt(JOptionPane.showInputDialog("Introduce base"));
			altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce altura"));
			
			System.out.println("La área del triangulo es: " + (base*altura)/2);
			
			break;
			
		case 4:
			
			radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio: "));
			
            System.out.println("El área del círculo es: " + Math.PI*(Math.pow(radio, 2)));

            break;
            
        default:
            System.out.println("La opción no es correcta.");
			
		}
		
		// -------------
		
		altura = Integer.parseInt(JOptionPane.showInputDialog("ingresa tu altura en cm: "));
		
		System.out.println("Si eres hombre tu peso ideal es: " + (altura-110) + " Kg.");
		
		System.out.println("Si eres mujer tu peso ideal es: " + (altura-120) + " Kg.");
		
		
		
	}
	
	static int figura;

}
