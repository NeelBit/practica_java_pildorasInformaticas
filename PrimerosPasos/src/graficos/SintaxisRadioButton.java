package graficos;

import javax.swing.*;


public class SintaxisRadioButton {

	public static void main(String[] args) {
		
		MarcoRadioSintaxis miMarco = new MarcoRadioSintaxis();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
	}

}

class MarcoRadioSintaxis extends JFrame {
	
	public MarcoRadioSintaxis() {
		
		setBounds(450, 250, 500, 400);
		LaminaRadioSintaxis miLamina = new LaminaRadioSintaxis();
		add(miLamina);
		
	}
	
}

class LaminaRadioSintaxis extends JPanel {
	
	public LaminaRadioSintaxis() {
	
		//creamos grupo
		ButtonGroup miGrupo1 = new ButtonGroup();
		
		ButtonGroup miGrupo2 = new ButtonGroup();
		
		//creamos JRadioButton
		JRadioButton btn1 = new JRadioButton("Azul", false); 	// el texto que acompaña, y si viene tildado por defecto
		JRadioButton btn2 = new JRadioButton("Rojo", true); 	// viene seleccionado por defecto
		JRadioButton btn3 = new JRadioButton("Verde", false);
		
		JRadioButton btn4 = new JRadioButton("Masculino", false);
		JRadioButton btn5 = new JRadioButton("Femenino", false);
		
		//decirle que los botones van a estar asociados a un grupo, osea que sólo una pueda ser seleccionado
		miGrupo1.add(btn1);
		miGrupo1.add(btn2);
		miGrupo1.add(btn3);
		
		miGrupo2.add(btn4);
		miGrupo2.add(btn5);
		
		// EL GRUPO NO SE AGREGA A LA LAMINA, SE AGREGAN LOS BOTONES!
		add(new JLabel("Colores")); 		// ejemplo propio
		add(btn1);
		add(btn2);
		add(btn3);
		
		add(new JLabel("Genero"));			// ejemplo propio 
		add(btn4);
		add(btn5);
		
	}
	
}







