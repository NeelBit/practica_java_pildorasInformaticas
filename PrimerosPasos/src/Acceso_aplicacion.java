import javax.swing.JOptionPane;

public class Acceso_aplicacion {

	public static void main(String[] args) {
		
		String clave = "Nelson";
		
		String pass = "";
		
		while (clave.equals(pass) == false) {		// si clave no es igual a pass... por eso == false
													// false == false --> true
													// true == false --> false
			pass = JOptionPane.showInputDialog("Introduce la contrase�a: ");
			
			if (clave.equals(pass) == false) {
				
				System.out.println("Contrase�a incorrecta!");
				
			}
			
			
		}
		
		System.out.println("Contrase�a correcta! Acceso permitido");
		
	}

}
