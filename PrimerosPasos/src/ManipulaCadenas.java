public class ManipulaCadenas {

	public static void main(String[] args) {
		
		String nombre = "Nelson";
		
		System.out.println("Mi nombre es: " + nombre);
		
		System.out.println("mi nombre tiene: " + nombre.length() + " letras");
		
		System.out.println("La primera letra de mi nombre es: " + nombre.charAt(0));
		
		// Para que imprima la ultima letra de cualquier valor de la variable nombre
		int ultima_letra = nombre.length();
		
		System.out.println("La ultima letra de " + nombre + " es: " + nombre.charAt(ultima_letra -1 ));
		
		
		
	}

}
