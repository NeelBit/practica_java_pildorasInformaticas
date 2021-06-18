
import java.util.*;

public class PruebaTreeSet {

	public static void main(String[] args) {
		
		// TreeSet ordenado por defecto!
		
		/*TreeSet<String> ordenaPersonas = new TreeSet<String>();
		
		ordenaPersonas.add("Estefani");
		ordenaPersonas.add("Diana");
		ordenaPersonas.add("Sandra");
		ordenaPersonas.add("Amanda");
		
		System.out.println(ordenaPersonas); 	// [Amanda, Diana, Estefani, Sandra] IMPRIME ORDENADO!
		
		for (String oP : ordenaPersonas) {
			
			System.out.println(oP);
			
		}
		*/
		
		TreeSet<Articulo> articulosListaArbol = new TreeSet<Articulo>();
		
		Articulo art1 = new Articulo(1, "primer articulo");
		Articulo art2 = new Articulo(2, "segundo articulo");
		Articulo art3 = new Articulo(3, "tercer articulo");
		Articulo art4 = new Articulo(4, "cuarto articulo");
		
		articulosListaArbol.add(art4);
		articulosListaArbol.add(art1);
		articulosListaArbol.add(art3);
		articulosListaArbol.add(art2);
		
		for (Articulo a : articulosListaArbol) {
			
			System.out.println(a.getDescripcion()); 	// imprime ordenado!
			
		}
		
		//Articulo comparadorArticulo = new Articulo(); // objeto comparator
		//TreeSet<Articulo> articulosListaArbolAlfabetico = new TreeSet<Articulo>(comparadorArticulo);
		
		// creamos nuevo comparador en base a la clase nueva:
		//ComparadorArticulo comparador = new ComparadorArticulo();
		//TreeSet
		//TreeSet<Articulo> articulosListaArbolAlfabetico = new TreeSet<Articulo>(comparador);
		
		// hacemos lo de arriba pero con clases internas anonimas:
		TreeSet<Articulo> articulosListaArbolAlfabetico = new TreeSet<Articulo>(new Comparator<Articulo>() {

			@Override
			public int compare(Articulo o1, Articulo o2) {
				
				String descrA = o1.getDescripcion();
				String descrB = o2.getDescripcion();
				
				return descrA.compareToIgnoreCase(descrB);
				
			}
			
		});
		
		// agregamos nuestros articulos al treeset:
		articulosListaArbolAlfabetico.add(art1);
		articulosListaArbolAlfabetico.add(art2);
		articulosListaArbolAlfabetico.add(art3);
		articulosListaArbolAlfabetico.add(art4);
		
		System.out.println();
		
		for(Articulo alfabetico : articulosListaArbolAlfabetico) {
			
			System.out.println(alfabetico.getDescripcion());
			
		}
		
		
		
	}

}

// si queremos que nuestros objetos puedar ordenarse, implementar Comparable , 
class Articulo implements Comparable<Articulo> {	 	//, Comparator<Articulo> {
	
	// necesito crear constructor por defecto para poder utilizar el metodo de Comparator
	//public Articulo() {};
	
	public Articulo(int num, String descripcion) {
		
		numeroArticulo = num;
		this.descripcion = descripcion;
		
	}
	
	
	@Override
	public int compareTo(Articulo o) { 	// Comparable
		
		// ordenar los articulos de a cuerdo a el numero de articulo
		return numeroArticulo - o.numeroArticulo;
		//return o.numeroArticulo - numeroArticulo; 	// para ordenar de mayor a menor
		
	}
	
	public String getDescripcion() {
		
		return descripcion;
		
	}
	
	private int numeroArticulo;
	private String descripcion;
	
	/*
	@Override 	// Comparator
	public int compare(Articulo o1, Articulo o2) {

		String descripcionA = o1.getDescripcion();
		String descripcionB = o2.getDescripcion();
		
		return descripcionA.compareToIgnoreCase(descripcionB);
		
	}*/
	
}

/*
class ComparadorArticulo implements Comparator<Articulo> {

	@Override
	public int compare(Articulo o1, Articulo o2) {

		String descrA = o1.getDescripcion();
		String descrB = o2.getDescripcion();
		
		return descrA.compareToIgnoreCase(descrB);
		
	}
	
	
	
}
*/

