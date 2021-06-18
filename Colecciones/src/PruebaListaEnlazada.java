
import java.util.*;

public class PruebaListaEnlazada {

	public static void main(String[] args) {
		
		LinkedList<String> paises = new LinkedList<String>();
		
		paises.add("España");
		paises.add("Colombia");
		paises.add("Mexico");
		paises.add("Perú");
		
		LinkedList<String> capitales = new LinkedList<String>();
		
		capitales.add("Madrid");
		capitales.add("Bogota");
		capitales.add("DF");
		capitales.add("Lima");
		
		
		System.out.println(paises);
		System.out.println();
		System.out.println(capitales);
		
		// creamos ambos listiterator
		ListIterator<String> itLPaises = paises.listIterator();
		ListIterator<String> itLCapitales = capitales.listIterator();
		
		// agregamos el primer elemento de capitales a continuacion del de paises.
		while(itLCapitales.hasNext()) { 	// comprobar si hay un siguiente elemento dentro de la lista a evaluar
			
			if (itLPaises.hasNext()) { 		// comprobar tambien si hay un elemento siguiente en la lista de paises
				
				itLPaises.next(); 	// salto la lista paises un elemento
				
			}
			
			itLPaises.add(itLCapitales.next()); 	// agrega el primer elemento de capitales
			
		}
		
		System.out.println();
		
		System.out.println(paises); 	// [España, Madrid, Colombia, Bogota, Mexico, DF, Perú, Lima]
		
		
		// volvemos a inicializar (NO DECLARAR) iterador de capiales para que vuelva el iterador al comienzo:
		itLCapitales = capitales.listIterator();
		
		// eliminar elementos pares del iterador de capitales:
		while (itLCapitales.hasNext()) {
			
			itLCapitales.next(); 	// si hay elementos, salta a la siguiente posicion
			
			if (itLCapitales.hasNext()) { 	// evalua si hay otra posicion
				
				itLCapitales.next(); 	// salto el segundo
				
				itLCapitales.remove(); 	// elimino el segundo elemento por ejemplo
				
				
			}
			
		}
		
		//  imprimo capitales habiendo eliminado elemento 2 y 4, (posiciones 1 y 3)
		System.out.println(capitales); 	// imprime 0 y 2, osea [Madrid, DF]
		
		// REMOVER: remover las capitales de paises. ELIMINA MADRID Y DF
		paises.removeAll(capitales); 	// elimina los elementos que coincidan de un LinkedList en otro.
		
		System.out.println(paises);
		
	}

}
