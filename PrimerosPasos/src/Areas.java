// calcular area de cuadrado, rectangulo, triangulo y circulo

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Areas {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Elija una opcion: \n 1) Cuadrado. \n 2) Rectangulo. \n 3) Triangulo. \n 4) Circulo. ");
		
		int figura = entrada.nextInt();
		
		switch (figura) {
		
		case 1: 
			int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado: "));
			
			System.out.println("el area del cuadrado es: " + Math.pow(lado, 2));
			break;
			
		case 2:
			int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base del rectangulo: "));
			int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura del rectangulo: "));
			
			System.out.println("El area del rectangulo es: " + base*altura);
			break;
			
		case 3:
			base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base: "));
			altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura: "));
			
			System.out.println("El area del triangulo es: " + (base*altura)/2);
			break;
			
		case 4:
			int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio del circulo: "));
			
			System.out.print("El area del circulo es: ");
			System.out.printf("%1.2f", Math.PI*(Math.pow(radio, 2)));
			break;
		
		default: 
			System.out.println("La opcion no es correcta!");
			
		}
		
	}

}
