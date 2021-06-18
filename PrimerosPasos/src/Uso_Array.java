
public class Uso_Array {

	public static void main(String[] args) {
		
		/*
		int [] mi_array = new int [5];	// declaracion de array de 5 elementos
		
		mi_array[0] = 5;
		mi_array[1] = 38;
		mi_array[2] = -15;
		mi_array[3] = 92;
		mi_array[4] = 71;
		
		System.out.println(mi_array[3]);	// debera imprimir 92
		
		System.out.println("Contenido de mi_array recorrido con ciclo for");
		
		*/
		
		int mi_array[] = {5, 38, -15, 92, 71};	// declaracion en una sola linea
		
		
		for (int i = 0; i < mi_array.length; i++) {

			System.out.println("Valor del indice " + i + " es igual a: " + mi_array[i]);
			  
		}
		
		
	}

}
