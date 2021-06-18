import java.util.Scanner;
public class Adivina_Numero {

	public static void main(String[] args) {
		
		//System.out.println(Math.random()); devuelve numero double aleatorio
		
		int aleatorio = (int)(Math.random() * 100);
		
		Scanner entrada = new Scanner(System.in);
		
		
		int numero = 0;
		
		int intentos = 0;
		
		while (numero != aleatorio) {
			
			System.out.println("Introdusca un numero entre 1 y 100");
			numero = entrada.nextInt();
			
			if (aleatorio < numero) {
				
				System.out.println("EL numero es MENOR");
				
			}
			else {
				System.out.println("El numero es MAYOR");
			}
			intentos++;
		}
		
		System.out.println("Acertaste!! el numero de intentos fue: " + intentos);
	}

}
