package graficos;

import java.awt.*;
import java.awt.geom.*;


import javax.swing.*;
import javax.swing.*;

public class PruebaDibujo {

	public static void main(String[] args) {
		
		MarcoConDibujos miMarco = new MarcoConDibujos();
		
		
	}

}

class MarcoConDibujos extends JFrame {
	
	public MarcoConDibujos() {
		
		setTitle("Prueba de dibujo");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		LaminasConFiguras miLamina = new LaminasConFiguras();
		add(miLamina);
		
		//miLamina.setBackground(Color.WHITE); 		// color al panel
		
		// pone color de fondo por defecto del sistema a la lamina
		miLamina.setBackground(SystemColor.window);
		
	}
	
}

class LaminasConFiguras extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		//g.drawRect(50, 50, 200, 200);			// 50 50 hacen referencia al punto de inicio de la figura.
												// 200 200 al tamaño de la figura.
		//g.drawLine(100, 100, 300, 200);		// dibuja una linea
		//g.drawArc(50, 100, 100, 200, 120, 150);
		
		Graphics2D g2 = (Graphics2D)g; 			// refundición, convertir un objeto Graphics a Graphics2D.
		
		// rectangulo
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
		
		g2.setPaint(Color.BLACK);
		
		// g2.draw(rectangulo); 			// dibuja los trazos de afuera
		g2.draw(rectangulo);		//color negro
		
		g2.setPaint(Color.RED);		// color rojo contorno
		g2.fill(rectangulo);				// fill --> dibuja contorno
		
		// circulo interno
		Ellipse2D elipse = new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		
		//Color miColor = new Color(0,0,0);
		
		// g2.draw(elipse); 							// brighter() - darker() --> da o quita brillo, varias veces de seguido
		g2.setPaint(new Color(50, 150, 20).brighter()); 	// creo objeto de color con constructor RGB
		//g2.setPaint(miColor);
		g2.fill(elipse);					// dibujo contorno elipse interna azul
		
		// linea
		g2.setPaint(Color.BLACK);
		g2.draw(new Line2D.Double(100, 100, 300, 250));
		
		
		
		// circulo externo
		double centroEnX = rectangulo.getCenterX();
		double centroEnY = rectangulo.getCenterY();
		double radio = 150;
		
		Ellipse2D circulo = new Ellipse2D.Double();
		circulo.setFrameFromCenter(centroEnX, centroEnY, centroEnX+radio, centroEnY+radio);
		g2.draw(circulo);
		
	}
	
}


