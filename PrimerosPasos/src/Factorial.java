import javax.swing.JOptionPane;
public class Factorial {

	public static void main(String[] args) {
		
		int resultado = 1;
		
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce numero "));
		
		for (int i = numero; i > 0; i--) {
			
			resultado = resultado * i;
			
		}
		
		System.out.println("El factorial de " +  numero + " es: " + resultado );
		
	}

}
