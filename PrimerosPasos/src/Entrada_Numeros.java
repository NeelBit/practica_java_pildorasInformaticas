import javax.swing.JOptionPane;

public class Entrada_Numeros {

	public static void main(String[] args) {
		
		double x = 10000.0;
		
		System.out.printf("%1.2f", x/3);		// printf formato . primer parametro el formato que aplique, despues de la coma el valor al que aplica
		// el .2 son los decimales
		
		
		String num1 = JOptionPane.showInputDialog("Introduce un numero: ");
		
		double num2 = Double.parseDouble(num1);		// pasar String a double
		
		System.out.print("La raiz cuadrada de " + num2 + " es ");
		
		System.out.printf("%1.4f", Math.sqrt(num2));
		
	}

}
