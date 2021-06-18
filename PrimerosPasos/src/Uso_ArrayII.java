
import javax.swing.JOptionPane;

public class Uso_ArrayII {

	public static void main(String[] args) {
		
		String [] paises = new String [8];
		
		/*
		paises[0] = "España";
		paises[1] = "Mexico";
		paises[2] = "Colombia";
		paises[3] = "Peru";
		paises[4] = "Chile";
		paises[5] = "Argentina";
		paises[6] = "Ecuador";
		paises[7] = "Venezuela";
		*/
		
		// declaracion e iniciacion de array en una linea
		//String [] paises = {"España", "Mexico", "Colombia", "Peru", "Chile", "Argentina", "Ecuador", "Venezuela"};
		
		/*for(int i = 0; i < paises.length; i++) {
			
			System.out.println("Pais " + (i+1) + " " + paises[i]);
			
		}
		*/
		
		
		for (int j = 0; j < 8; j++) {
			
			paises[j] = JOptionPane.showInputDialog("Ingrese pais " + (j+1));
			
		}
		
		
		for(String k: paises) {		//for each --> tipoDeMatriz nombre : nombreDeMatriz
		
			System.out.println("Pais: " + k);
			
		}	
		
		
		
	}

}
