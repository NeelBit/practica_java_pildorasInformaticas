public class Calculos_conMath {

	public static void main(String[] args) {
		
		//double raiz = Math.sqrt(9);
		//System.out.println(raiz);
		
		/*
		double num1 = 5.85;
		int resultado = (int)Math.round(num1);
		
		System.out.println(resultado);
		*/
		
		double base = 5;
		double exponente = 3;
		
		int resultado = (int)Math.pow(base, exponente);
		System.out.println("El resutlado de " + base + " elevado a " + exponente + " es: " + resultado);
		
		
	}

}
