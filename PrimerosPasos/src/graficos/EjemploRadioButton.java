package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

// marco con una lamina tipo BordelLayout, con un texto en el centro, el cual
// vamos a cambiar de tamaño con botones JRadioButton, en el sur.

public class EjemploRadioButton {

	public static void main(String[] args) {
		
		MarcoRadioButton miMarco = new MarcoRadioButton();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
	}

}

class MarcoRadioButton extends JFrame {
	
	public MarcoRadioButton() {
		
		setBounds(600, 200, 500, 350);
		LaminaRadio miLamina = new LaminaRadio();
		add(miLamina);
		
	}
	
}

class LaminaRadio extends JPanel {
	
	public LaminaRadio() {
		
		setLayout(new BorderLayout()); 		// la lamina principal sera tipo borderlayout
		
		texto = new JLabel("En un lugar de la mancha de cuyo nombre..."); 	// texto al que vamos a cambiar de tamaño
		
		texto.setFont(new Font("Serif", Font.PLAIN, 12)); 	// achicando codigo
		
		add(texto, BorderLayout.CENTER); 	// lo ponemos en el centro
		
		laminaBoton = new JPanel();		// achicando codigo faltaba iniciar
		
		miGrupo = new ButtonGroup();	// achicando codigo, faltaba iniciar
		
		/* 		ESTO ESTA COMENTADO PARA VER COMO AHORRAR CODIGO
		ButtonGroup miGrupo = new ButtonGroup(); 	// creamos grupo
		btn1 = new JRadioButton("Pequeño", false);
		btn2 = new JRadioButton("Mediano", true); 	// por defecto activado el mediano
		btn3 = new JRadioButton("Grande", false);
		btn4 = new JRadioButton("Extra Grande", false);
		
		// creamos una segunda lamina
		JPanel laminaRadio = new JPanel();
		
		// ponemos a la escucha:
		EventoRadio miEvento = new EventoRadio(); 	// creamos objeto oyente
		btn1.addActionListener(miEvento); 		// ponemos btn1 a la escucha del evento
		btn2.addActionListener(miEvento);
		btn3.addActionListener(miEvento);
		btn4.addActionListener(miEvento);
		
		
		// añadimos botones al grupo
		miGrupo.add(btn1);
		miGrupo.add(btn2);
		miGrupo.add(btn3);
		miGrupo.add(btn4);
		
		// agregamos botones a la segunda lamina
		laminaRadio.add(btn1);
		laminaRadio.add(btn2);
		laminaRadio.add(btn3);
		laminaRadio.add(btn4);
		
		//agregamos laminaRadio a a parte sur de la lamina principal
		add(laminaRadio, BorderLayout.SOUTH);
		
		*/
		
		// achicando codigo:
		colocarBotones("Pequeño", false, 10);
		colocarBotones("Mediano", true, 12);
		colocarBotones("Grande", false, 18);
		colocarBotones("Extra Grande", false, 24);
		
		add(laminaBoton, BorderLayout.SOUTH);
		
	}
	/* 		ESTO ESTA COMENTADO PARA VER COMO  AHORRAR CODIGO
	//creamos clase interna para manejar eventos.
	private class EventoRadio implements ActionListener { 	// ActionListener maneja evento click

		@Override
		public void actionPerformed(ActionEvent e) {
			// e.getSource --> devuelve el objeto que desencadeno el evento ej: btn1
			
			if (e.getSource() == btn1) {
				//System.out.println("presionaste el boton 1");
				
				texto.setFont(new Font("Serif", Font.PLAIN, 10));
				
			}else if (e.getSource() == btn2) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 12));
				
			}else if (e.getSource() == btn3) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 18));
				
			}else if (e.getSource() == btn4) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 24));
				
			}
			
			
		}
		
		
		
	}
	*/
	
	public void colocarBotones(String nombre, boolean seleccionado, final int medida) { 		// // achicando codigo
		
		JRadioButton boton = new JRadioButton(nombre, seleccionado);
		
		miGrupo.add(boton);
		laminaBoton.add(boton);
		
		ActionListener miEvento = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, medida));
				
			}
		};	
		
		boton.addActionListener(miEvento);
		
	}
	
	private JLabel texto;
	//private JRadioButton btn1, btn2, btn3, btn4;
	
	private ButtonGroup miGrupo; 	// achicando codigo
	private JPanel laminaBoton;		// achicando codigo
}









