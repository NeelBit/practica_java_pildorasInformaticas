
public class ManipulaCadenas2 {

	public static void main(String[] args) {
		
		String frase = "Hoy es un estupendo dia para aprender a programar en Java";
		String frase_resumen = frase.substring(29, 57) + " e irnos a la playa";		// el segundo parametro: la posicion desde la que no quiero extraer
		
		String frase_resumen2 = frase.substring(0, 29) + "irnos a la playa y " + frase.substring(29, 57);
		
		System.out.println(frase_resumen);

		System.out.println(frase_resumen2);
		
		
	}

}
