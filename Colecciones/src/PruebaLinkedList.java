
import java.util.*;

public class PruebaLinkedList {

	public static void main(String[] args) {
		
		// ListIterator nos permite mover hacia atras y recorrer, ademas de mas metodos.
		
		LinkedList<String> listaVinculadaPersonas = new LinkedList<String>();
		
		listaVinculadaPersonas.add("Pepe");
		listaVinculadaPersonas.add("Fulano");
		listaVinculadaPersonas.add("Sandra");
		listaVinculadaPersonas.add("Ana");
		
		listaVinculadaPersonas.add(2, "Mengano"); 	// añadimos a mengano en 2 despues de fulano
		
		// crear iterador (ListIterator) para añadir un nuevo elemento, suponiendo que no se el index de ese elemento:
		ListIterator<String> itList = listaVinculadaPersonas.listIterator();
		
		itList.next(); 	// avanzo entre 0 y 1
		itList.next();
		itList.next(); 	
		itList.next();	
		itList.add("Cosito");
		
		itList.previous(); 	// vuelvo 5 veces
		itList.previous();
		itList.previous();
		itList.previous();
		itList.previous();
		itList.add("Primer persona primer lugar"); 
		
		
		
		
		System.out.println("La lista tiene: " + listaVinculadaPersonas.size() + " elementos");
		
		System.out.println();
		
		for (String lista : listaVinculadaPersonas) {
			
			System.out.println(lista);
			
		}
		
	}

}
