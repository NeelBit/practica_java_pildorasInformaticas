package graficos;

import java.awt.*;

import java.awt.event.*;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

//OBJETO OYENTE LA LAMINA, Y DOS OBJETOS FUENTES de eventos: CLICK EN LOS BOTONES Y COMBINACION DE TECLAS.

public class PruebaAcciones {

	public static void main(String[] args) {
		
		MarcoAccion marco = new MarcoAccion();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
		
	}

}

class MarcoAccion extends JFrame {
	
	public MarcoAccion() {
		
		setTitle("Prueba acciones");
		setBounds(300, 100, 600, 400);
		
		PanelAccion lamina = new PanelAccion();
		add(lamina);
		
		
		// añadir icono ?
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Image miIcono = miPantalla.getImage("src/graficos/icono.png");
		setIconImage(miIcono);
	}
	
}

class PanelAccion extends JPanel {
	
	public PanelAccion() { 	// construcctor
		
		AccionColor accionAmarillo = new AccionColor("Amarillo", new ImageIcon("src/graficos/botonAmarillo.png"), Color.YELLOW);
		
		AccionColor accionRojo = new AccionColor("Rojo", new ImageIcon("src/graficos/botonRojo.png"), Color.RED);
		
		AccionColor accionAzul = new AccionColor("Azul", new ImageIcon("src/graficos/botonAzul.png"), Color.BLUE);
		
		// codigo simplificado:
		add(new JButton(accionAmarillo));
		add(new JButton(accionRojo));
		add(new JButton(accionAzul));
		
		
		/* constructor que recibe un objeto tipo action
		JButton botonAmarillo = new JButton(accionAmarillo);
		JButton botonRojo = new JButton(accionRojo);
		JButton botonAzul =new JButton(accionAzul);
		
		add(botonAmarillo);
		add(botonRojo);
		add(botonAzul);
		*/
		
		/* agregar boton con nombre simple
		JButton botonAmarillo = new JButton("Amarillo");
		JButton botonRojo = new JButton("Rojo");
		JButton botonAzul = new JButton("Azul");
		
		add(botonAmarillo);
		add(botonRojo);
		add(botonAzul);
		*/
		
		// combinacion de teclas:
		InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW); 	// le decimos que el objeto del foco se encuentra dentro de la lamina
		
		KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl A"); 	// combinacion de tecla
		KeyStroke teclaRojo = KeyStroke.getKeyStroke("ctrl R");
		KeyStroke teclaAzul = KeyStroke.getKeyStroke("ctrl B");
		
		// esto se puede simplificar por ejemplo asi:
		// mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
		
		mapaEntrada.put(teclaAmarillo, "fondo_amarillo");			// asignar combinacion a un objeto
		mapaEntrada.put(teclaRojo, "fondo_rojo");
		mapaEntrada.put(teclaAzul, "fondo_azul");
		
		
		ActionMap mapaAccion = getActionMap();		// asociar objeto a accion
		
		mapaAccion.put("fondo_amarillo", accionAmarillo); 	
		mapaAccion.put("fondo_rojo", accionRojo);
		mapaAccion.put("fondo_azul", accionAzul);
		
		// añadir otra combinacion de tecla mas
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl T"), "fondo_amarillo");
		
	}
	
	// la lamina es el oyente del evento
	private class AccionColor extends AbstractAction { 		// clase oyente. (la hacemos interna para que pueda usar el metodo setBackground de JPanel)

		// evento que cuando se crea almacena estas cuatro cosas
		public AccionColor(String nombre, Icon icono, Color color_boton) { 	// constructor
			
			// putValue asociar una clave a un valor en el objeto evento, ej: NAME: Amarillo
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color " + nombre);
			// creo la accion: creo la clave como primer parametro, y que va a hacer
			putValue("color_de_fondo", color_boton); 	// me invento la clave y recibe el parametro
			
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) { 	// para que funcione, decirle que tiene que hacer cuando los botones sean utilizados.
			// getValue devuelve el valor de la clave que inventamos.
			Color c = (Color)getValue("color_de_fondo");	// almacenar en c el color que le hemos pasado por parametro.
															// Obtenemos el valor correspondiente a esa clave.
															// hago casting a Color
			setBackground(c);
			
			// que getValue nos dé el nombre y la descripcion del boton que estamos usando
			System.out.println("El boton presionado es: " + getValue(Action.NAME));
			System.out.println("La descripción del boton presionado es la siguiente: " + getValue(Action.SHORT_DESCRIPTION));
			
		}
		
		
		
	}
	
	
	
}

