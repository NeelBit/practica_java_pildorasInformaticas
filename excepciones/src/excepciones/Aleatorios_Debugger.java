package excepciones;

import javax.swing.JOptionPane;

public class Aleatorios_Debugger {

	public static void main(String[] args) {
		
		int elementos = Integer.parseInt(JOptionPane.showInputDialog("Introduce cantidad de elementos de la matriz: "));
		
		int numAleat[] = new int[elementos];
		
		for (int i=0; i<numAleat.length; i++) {
			
								// entre parentesis para que haga el casting al resultado de random
								// por cien, no solo a random. 
			numAleat[i] = (int)(Math.random() * 100);
			
		}
		
		for (int elem: numAleat) {
			
			System.out.println(elem);
			
		}
		
		System.out.println(Math.random()*100);
	}

}
