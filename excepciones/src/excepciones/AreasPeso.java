package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

// el uso mas com�n de finally es para cerrar una conexion.

public class AreasPeso {

	public static void main(String[] args) {
		
		int base, altura, lado, radio;
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Elige una opci�n: \n1_ Cuadrado \n2_ Rect�ngulo \n3_ Tri�ngulo \n4_ C�rculo");
		
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
			
			System.out.println("El �rea del rectangulo es: " + base*altura);
			
			break;
			
		case 3:
			
			base = Integer.parseInt(JOptionPane.showInputDialog("Introduce base"));
			altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce altura"));
			
			System.out.println("La �rea del triangulo es: " + (base*altura)/2);
			
			break;
			
		case 4:
			
			radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio: "));
			
            System.out.println("El �rea del c�rculo es: " + Math.PI*(Math.pow(radio, 2)));

            break;
            
        default:
            System.out.println("La opci�n no es correcta.");
			
		}
		
		// -------------
		
		altura = Integer.parseInt(JOptionPane.showInputDialog("ingresa tu altura en cm: "));
		
		System.out.println("Si eres hombre tu peso ideal es: " + (altura-110) + " Kg.");
		
		System.out.println("Si eres mujer tu peso ideal es: " + (altura-120) + " Kg.");
		
		
		
	}
	
	static int figura;

}
