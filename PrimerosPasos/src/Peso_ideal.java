import javax.swing.*;

public class Peso_ideal {

	public static void main(String[] args) {
		
		String genero = "";
		
		do {
			
			genero = JOptionPane.showInputDialog("Introduce tu genero: (H/M)");
			
		}
		while(genero.equalsIgnoreCase("H") == false && genero.equalsIgnoreCase("M") == false);
		
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce altura en Cmtros.: "));
		
		int pesoIdeal = 0;
		
		if (genero.equalsIgnoreCase("H")) {
			
			pesoIdeal = altura - 110;
			
		}
		else {
			pesoIdeal = altura - 120;
		}
		
		System.out.println("su peso ideal es: " + pesoIdeal + "Kgrms.");
		
	}

}
