package graficos;

import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Barra_Herramientas {

	public static void main(String[] args) {
		
		MarcoBarraHerramientas marcoBarra = new MarcoBarraHerramientas();
		marcoBarra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marcoBarra.setVisible(true);
		
	}

}

class MarcoBarraHerramientas extends JFrame {
	
	public MarcoBarraHerramientas() {
		
		setTitle("Marco con barra de herramientas");
		setBounds(450, 150, 600, 400);
		lamina = new JPanel();
		add(lamina);
		
		// configurar acciones:
		Action accionAmarillo = new AccionHerramientasColor("Amarillo", new ImageIcon("src/graficos/botonAmarillo.png"), Color.YELLOW);
		Action accionRojo = new AccionHerramientasColor("Rojo", new ImageIcon("src/graficos/botonRojo.png"), Color.RED);
		Action accionAzul = new AccionHerramientasColor("Azul", new ImageIcon("src/graficos/botonAzul.png"), Color.BLUE);
		
		//accion para el boton de salir en la barra de herramientas:
		// lo hago desde clase interna anonima, 
		Action accionSalir = new AbstractAction("Salir", new ImageIcon("src/graficos/x.png")) {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// se le pasa 0 para salir de la aplicacion.
				System.exit(EXIT_ON_CLOSE);
				
			}
			
		};
		
		JMenu menu = new JMenu("Color");
		menu.add(accionAmarillo);
		menu.add(accionRojo);
		menu.add(accionAzul);
		
		// primero creamos una barra de menu
		JMenuBar MenuHerramientas = new JMenuBar();
		MenuHerramientas.add(menu);
		setJMenuBar(MenuHerramientas); 		// añadir JMenuBar a la barra del marco
		
		// creamos una barra de herramientas:
		JToolBar barraHerramientas = new JToolBar();
		barraHerramientas.add(accionAzul);
		barraHerramientas.add(accionRojo);
		barraHerramientas.add(accionAmarillo);
		
		barraHerramientas.addSeparator(); 	// añadir separador
		
		// colocar un boton de salir en la barra de herramientas:
		barraHerramientas.add(accionSalir);
		
		// si le queremos que se pueda arrastrar le tenemos que indicar una ubicacion con borderlayout.
		add(barraHerramientas, BorderLayout.SOUTH);
		
	}
	
	private class AccionHerramientasColor extends AbstractAction {

		public AccionHerramientasColor(String nombre, Icon icono, Color c) {
			
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Color de fondo... " + nombre);
			// creo clave Color, con valor c
			putValue("Color", c);
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Color c = (Color)getValue("Color"); 	// paso a tipo Color, el valor extraido de la clave creada
			lamina.setBackground(c);
			
		}
		
	}
	
	private JPanel lamina = new JPanel();
	
}








