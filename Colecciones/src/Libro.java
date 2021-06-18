
public class Libro {
	
	public Libro(String titulo, String autor, int ISBN) {
		
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = ISBN;
		
	}
	
	public String getDatos() {
		
		return "El titulo es: " + titulo + ". El autor es: " + autor + ". El ISBN es: " + ISBN;
		
	}
	
	// sobreescribimos metodo equals para poder comparar objetos libro a nuestro antojo
	public boolean equals(Object obj) {
		
		// instanceof para ver si una instancia pertenece a cierta clase.
		 if(obj instanceof Libro) {
			 
			 Libro l1 = (Libro)obj;
			 
			 if (this.ISBN == l1.ISBN) {
				 
				 return true;
				 
			 }else {
				 
				 return false;
				 
			 }
			 
		 }else {
			 
			 return false;
			 
		 }
		
		
	}
	
	
	
	
	private String titulo, autor;
	private int ISBN;
	
}
