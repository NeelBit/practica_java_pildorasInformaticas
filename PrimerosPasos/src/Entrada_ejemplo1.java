import java.util.Scanner;

public class Entrada_ejemplo1 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		
		System.out.println("Introduce tu nombre: ");
		
		String nombre_usuario = entrada.nextLine();
		
		
		System.out.println("Introduce edad: ");
		
		int edad_usuario = entrada.nextInt();
		
		
		System.out.print("Hola " + nombre_usuario + ". El año que viene tendras: " + (edad_usuario + 1) + " años");
		
		
	}

}
