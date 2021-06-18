package ejercicio_Swing_Final;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

// se va a encargar de crear los box layout
public class LaminaBotones extends JPanel {
	
	public LaminaBotones(String titulo, String[] opciones) {
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo, TitledBorder.CENTER, TitledBorder.TOP));
		
		// this elemento padre, hacemos referencia a la lamina
		// Y_AXIS distribuir los elementos en vertical de arriba hacia abajo.
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		grupo = new ButtonGroup();
		
		for (int i=0; i<opciones.length; i++) {
			
			// en el array estan los nombres de los componentes
			JRadioButton btn = new JRadioButton(opciones[i]);
			
			// dotar de acciones que van a desencadenar los botones:
			btn.setActionCommand(opciones[i]);
			
			add(btn);
			grupo.add(btn);
			
			// que por defecto este seleccionado la primera opcion:
			// pide un booleano, y da true cuando es el primero (0)
			btn.setSelected(i==0);
			
		}
		
	}
	
	public String getSeleccion() {
		
			// devuelve boton seleccionado, tipo ButtonModel
		//ButtonModel btnSeleccionado = grupo.getSelection();
			// con getActionCommand obtengo el string del boton seleccionado
		//String s = btnSeleccionado.getActionCommand();
		//return s;
		
		// en una linea es: 
		return grupo.getSelection().getActionCommand();
	}
	
	private ButtonGroup grupo;
	
}