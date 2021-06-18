package graficos;

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

// DIBUJAR IMAGEN EN MARCO Y QUE AL EXTENDER SIGA APARECIENDO.
// CONTIENE EXCEPCIONES.

public class PruebaImagenes {

	public static void main(String[] args) {
		
		MarcoConImagen miMarco = new MarcoConImagen();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
		
	}

}


class MarcoConImagen extends JFrame {
	
	public MarcoConImagen() {
		
		setTitle("Marco con imagen");
		setBounds(550, 300, 400, 350);
		LaminaConImagen miLamina = new LaminaConImagen();
		add(miLamina);									// NO OLVIDAR AÑADIR LA LAMINA(PANEL) AL MARCO(FRAME)
		// cada ves que se instancia esa lamina se construye con el código de su constructor.
		
	}
	
}

class LaminaConImagen extends JPanel {
	
	public LaminaConImagen() {
		
		try {
			imagen = ImageIO.read(new File("src/graficos/imagen2.png"));
			}
			catch (IOException e) {
				System.out.println("La imagen no se encuentra o tiene otro nombre!");
			}
		
	}
	
	
	public void paintComponent(Graphics g) throws NullPointerException{
		
		super.paintComponent(g);
		
		// EXCEPCION DEL TIPO RUNTIME EXCEPTION, SI NO EnCUENTRA LA IMAGEN, NO ESTA DECLARADA Y NO PUEDE DIBUJAR NULL
		
			
		try {
			
		
		
		//File miImagen = new File("src/graficos/imagen1.jpg");
		
		// código del try catch iba aca pero se traslado al constructor.
		
		//en caso de desconocer las dimensiones se hace esto:
		int anchuraImagen = imagen.getWidth(this); 		// this hace referencia al objeto donde me encuentro (lamina)
		int alturaImagen = imagen.getHeight(this);
		
		g.drawImage(imagen, 0, 0, null); 	// hace el primer dibujo
		
		for (int i=0; i<300; i++) {
			
			for (int j=0; j<300; j++) {
				
				if (i + j > 0) { 		// para no hacer la primer copia encima del primer dibujo.
				
				//g.copyArea(0, 0, imagen.getWidth(null), 128, imagen.getWidth(null) * i, 128 *j);
				g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen * i, alturaImagen *j);
				}
			}
			
		}
		
		// g.copyArea(0, 0, 128, 128, 250, 150);
		
		} catch (NullPointerException e) {
			
			g.drawString("no se encontro la imagen", 10, 10);
			
		}
		
		
	}
	
	private Image imagen;
	
	
	
}



