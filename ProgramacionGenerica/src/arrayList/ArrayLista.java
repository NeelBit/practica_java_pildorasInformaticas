package arrayList;

public class ArrayLista {

	public ArrayLista(int z) { 		// numero de elementos
		
		datosElemento = new Object[z];
		
	}
	
	public Object get(int i) {		// devolver elemento en concreto
		
		return datosElemento[i];
		
	}
	
	public void add(Object o) {		// añadir elemento en posicion siguiente
		
		datosElemento[i] = o;
		
		i++;			// contador
		
	}
	
	
	private Object[] datosElemento;
	private int i=0; 	// contador
	
}
