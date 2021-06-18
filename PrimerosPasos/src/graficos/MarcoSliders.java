package graficos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MarcoSliders {

	public static void main(String[] args) {
		
		FrameSlider miMarco = new FrameSlider();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class FrameSlider extends JFrame {
	
	public FrameSlider() {
		
		setBounds(550, 300, 550, 350);
		LaminaSlider miLamina = new LaminaSlider();
		add(miLamina);
		setVisible(true);
		
	}
	
}

class LaminaSlider extends JPanel {
	
	public LaminaSlider() {
		
		//JSlider control = new JSlider(SwingConstants.VERTICAL ,0, 200, 150); 		
		//control.setOrientation(SwingConstants.HORIZONTAL); 		// cambiar la orientacion.
		
		JSlider control = new JSlider(); // por defecto horizontal. 0, 100, 50 (por defecto)
		
		control.setMajorTickSpacing(25); 		// marcas mayores
		control.setMinorTickSpacing(5); 		// cada cuanto van las marcas menores
		
		control.setPaintTicks(true); 		// imprima las marcas.
		
		control.setPaintLabels(true); 		// imprime los numeros indicadores
		
		control.setFont(new Font("Serif", Font.ITALIC, 12)); 		// modificar el tipo de letra
		
		// añadir funcionalidad de iman:
		control.setSnapToTicks(true);
		
		add(control);
		
		
	}
	
	
	
}






