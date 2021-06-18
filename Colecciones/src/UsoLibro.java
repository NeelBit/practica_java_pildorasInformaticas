
public class UsoLibro {

	public static void main(String[] args) {
		
		Libro libro1 = new Libro("Fulano", "autor", 0001);
		
		Libro libro2 = new Libro("Mengano", "autor2", 0002);
		
		Libro libro3 = new Libro("Fulano", "autor", 0001);
		
		Libro libro4 = libro1; 	// true
		
		
		System.out.println("Son iguales? 1 y 4 : " + libro1.equals(libro4));
		
		System.out.println("HashCode libro1: " + libro1.hashCode());
		
		System.out.println("HashCode libro3: " + libro3.hashCode());
		
		System.out.println("Son iguales? 1 y 3 : " + libro1.equals(libro3)); // sobre escribimos el metodo equals() para que cuando tengo el mismo ISBN sean iguales.
		
	}

}
