package excepciones;

import javax.swing.JOptionPane;

public class VariasExcepciones {

	public static void main(String[] args) {
		
		try {
			
			division();
			
		}catch (ArithmeticException e) {
			
			JOptionPane.showMessageDialog(null, "Introduciste un cero");
			
		}catch (NumberFormatException e) {
			
			JOptionPane.showMessageDialog(null,  "Introduciste un caracter no válido");
			
		}
		
		
	}
	
	static void division() throws ArithmeticException, NumberFormatException {  // es opcional? poner esto?
		
		int n1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce dividendo: "));
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce divisor: "));
		
		JOptionPane.showMessageDialog(null, "El resultado es: " + n1/n2);
		
	}
	
	
}
