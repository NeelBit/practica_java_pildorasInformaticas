package calculadoraJar;

import javax.swing.JFrame;

public class MarcoCalculadora extends JFrame {
		
		public MarcoCalculadora() {
			
			//centrar marco:
			/*Toolkit miPantalla = Toolkit.getDefaultToolkit();
			Dimension resolucionPantalla = miPantalla.getScreenSize();
			int altura = resolucionPantalla.height;
			int ancho = resolucionPantalla.width;
			*/
			//setBounds(ancho/4, altura/4, ancho/2, altura/2);
			
			setBounds(500, 200, 300, 350);
			
			setTitle("Calculadora");
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			add(new LaminaCalculadora()); 	// añadimos una instancia de la lamina principal
			
			setVisible(true);
			//pack(); 		// acomoda los botones y tamaño
		}
	
}
