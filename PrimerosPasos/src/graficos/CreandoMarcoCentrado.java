package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CreandoMarcoCentrado {

	public static void main(String[] args) {
		
		MarcoCentrado miMarco = new MarcoCentrado();
		
		
	}

}


class MarcoCentrado extends JFrame {
	
	public MarcoCentrado() {
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		
		Dimension resolucionPantalla = miPantalla.getScreenSize();
		
		int altura = resolucionPantalla.height;
		int ancho = resolucionPantalla.width;
		
		setSize(ancho/2, altura/2);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocation(ancho/4, altura/4);
		
		setTitle("Marco Centrado");
		
		Image miIcono = miPantalla.getImage("src/graficos/icono.png");
		setIconImage(miIcono);
		
	}
	
	
	
}