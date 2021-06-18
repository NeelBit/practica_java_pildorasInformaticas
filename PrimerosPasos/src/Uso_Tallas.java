import java.util.*;

public class Uso_Tallas {

	
	// enum talla {MINI, MEDIANO, GRANDE, MUY_GRANDE};
	
	enum Talla {
		
		MINI("S"), MEDIANO("M"), GRANDE("L"), MUY_GRANDE("XL");
		
		private Talla(String abreviatura) {
			
			this.abreviatura = abreviatura;
			
		}
		
		public String getAbreviatura() {
			return abreviatura;
		}
		
		private String abreviatura;

	}
	
	public static void main(String[] args) {
		/*
		talla s = talla.MINI;
		talla m = talla.MEDIANO;
		talla l = talla.GRANDE;
		talla xl = talla.MUY_GRANDE;
		*/
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese talla: MINI, MEDIANO, GRANDE, MUY_GRANDE");
		
		String entradaDatos = entrada.nextLine().toUpperCase(); 	// pasa a mayuscula lo que el usuario ingrese por consola
		
		Talla laTalla = Enum.valueOf(Talla.class, entradaDatos); 	// metodo de enum valueOf
		
		System.out.println("Talla = " + laTalla);
		System.out.println("La abreviatura correspondiente es: " + laTalla.getAbreviatura());
		
	}

}
