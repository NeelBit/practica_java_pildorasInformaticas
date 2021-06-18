import javax.swing.JOptionPane;

public class Comprueba_mail_for {

	public static void main(String[] args) {
		
		int arroba = 0;
		
		boolean punto = false;
		
		String mail = JOptionPane.showInputDialog("Introduce mail ");
		
		for (int i = 0; i < mail.length(); i++) {
			
			if (mail.charAt(i) == '@') {
				
				arroba++;
			}
			
			if (mail.charAt(i) == '.') {
				
				punto = true;
				
			}
		}
		
		
		if (arroba == 1 && punto) {
			
			System.out.println("Es correcto!");
			
		} 
		else {
			
			System.out.println("Es falso");
			
		}
	}
}
