package graficos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MarcoJSliderPractica {

	public static void main(String[] args) {
		
		FrameJSliderPractica miMarco = new FrameJSliderPractica();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
	}

}

class FrameJSliderPractica extends JFrame {
	
	public FrameJSliderPractica() {
		
		setBounds(500, 250, 550, 350);
		LaminaJSliderPractica miLamina = new LaminaJSliderPractica();
		add(miLamina);
		
	}
	
}

class LaminaJSliderPractica extends JPanel {
	
	public LaminaJSliderPractica() {
		
		setLayout(new BorderLayout());
		rotulo = new JLabel("En un lugar de la Mancha, cuyo nombre...");
		add(rotulo,BorderLayout.CENTER);
		
		control = new JSlider(8, 48, 12); 	// tamaño minimo, tamaño maximo, la letra por defecto
		control.setMajorTickSpacing(10);
		control.setMinorTickSpacing(2);
		control.setPaintTicks(true); 		// que pinte las marcas
		control.setPaintLabels(true); 		// que pinte los rotulos
		control.setFont(new Font("Serif", Font.ITALIC, 10)); 	// modificamos apariencia de los indicadores
		
		// ponemos a la escucha del evento ChangeListener
		control.addChangeListener(new EventoJSlider());
		
		// creamos segunda lamina donde poner el Slider
		JPanel laminaSlider = new JPanel();
		laminaSlider.add(control); 	// colocamos JSlider en la segunda lamina
		
		// añadimos segunda lamina al norte de la lamina principal
		add(laminaSlider, BorderLayout.NORTH);
		
		
		
	}
	
	private class EventoJSlider implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) { 	// este es el metodo que se va a ejecutar cada ves que arrastremos el JSlider
			/*
			contador++;
			System.out.println("Estas manipulando el deslisante: " + contador);
			System.out.println("posicion : " + control.getValue());
			*/
			
			rotulo.setFont(new Font("Serif", Font.BOLD, control.getValue()));
			
		}
		
	}
	
	private JLabel rotulo;
	private JSlider control;
	
	//private static int contador;
	
}






