package graficos;

import java.awt.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts {

	public static void main(String[] args) {
		
		MarcoLayout marco = new MarcoLayout();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
		
	}

}

class MarcoLayout extends JFrame {
	
	public MarcoLayout() {
		
		setTitle("Prueba accioens");
		setBounds(500, 350, 600, 300);
		PanelLayout lamina = new PanelLayout();
		
		//antes de añadir la lamina le decimos la disposicion (flowlayout)
		
		//FlowLayout disposicion = new FlowLayout(FlowLayout.RIGHT);
		
		//lamina.setLayout(new FlowLayout(FlowLayout.CENTER)); 	// achicar codigo . center es el por defecto
		
		//lamina.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50)); // ubicacion, a los lados, 50 distancia al borde superior.
		
		PanelLayout2 lamina2 = new PanelLayout2();
		
		
		add(lamina, BorderLayout.NORTH);
		add(lamina2, BorderLayout.SOUTH);
		
	}
	
}

// una lamina con 2 botones y otra lamina con 3

class PanelLayout extends JPanel {
	
	public PanelLayout() {
		
		// aca se suele poner el layout. por ejemplo:
		// setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
		
		//setLayout(new BorderLayout(10, 10)); 	// 10 de separacion horiz y vert.
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		// si utiliza BorderLayout se debe indicar la ubicacion de cada elemento.
		
		//add(new JButton("Amarillo"), BorderLayout.NORTH);
		
		//add(new JButton("Rojo", miIcono), BorderLayout.EAST);
		
		add(new JButton("Amarillo"));
		
		add(new JButton("Rojo", miIcono));

		
	}
	ImageIcon miIcono = new ImageIcon("src/graficos/botonRojo.png");
}

class PanelLayout2 extends JPanel {
	
	public PanelLayout2() {
		
		setLayout(new BorderLayout());
		
		add(new JButton("Azul"), BorderLayout.SOUTH);
		add(new JButton("Verde"), BorderLayout.WEST);
		add(new JButton("Negro"), BorderLayout.CENTER);
		
	}
	
}

