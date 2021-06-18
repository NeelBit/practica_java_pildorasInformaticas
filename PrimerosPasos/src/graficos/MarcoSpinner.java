package graficos;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.*;

public class MarcoSpinner {

	public static void main(String[] args) {
		
		FrameSpinner miMarco = new FrameSpinner();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
	}

}

class FrameSpinner extends JFrame {
	
	public FrameSpinner() {
		
		setBounds(550, 350, 550, 350);
		add(new LaminaSpinner());
		
	}
	
}

class LaminaSpinner extends JPanel {
	
	public LaminaSpinner() {
		
		//JSpinner control = new JSpinner(new SpinnerDateModel());
		
		//String lista[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		
		//JSpinner control = new JSpinner(new SpinnerListModel(lista));
		
		// que nos enliste las fuentes que tenemos instaladas:
		//String listaFuentes[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		//JSpinner control = new JSpinner(new SpinnerListModel(listaFuentes));
		
		//JSpinner control = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1)); 		// por defecto, minimo, maximo, de a cuantos avanza
		
		// clase interna
		//JSpinner control = new JSpinner(new MiModeloJSpinner());
		
		// CLASE INTERNA ANONIMA
		JSpinner control = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1){
			
			public Object getNextValue() {
				
				return super.getPreviousValue();
			}
			
			public Object getPreviousValue() {
				
				return super.getNextValue();
				
			}
			
		});
		
		// modificar el tamaño, porque por defecto toma el tamaño del primer elemento.
		Dimension dimension = new Dimension(200, 25);
		control.setPreferredSize(dimension);
		
		add(control);
		
	//}
	
	/*
	// clase interna para crear un modelo propio de JSpinner
	private class MiModeloJSpinner extends SpinnerNumberModel {
		
		public MiModeloJSpinner() {
			
			super(5, 0, 10, 1); 	// los valores que debe tener, llamando al constructor de la clase padre
			
		}
		
		// sobreescribimos metodos para modificar funcionamiento.
		public Object getNextValue() {
			
			// le decimos al metodo que se comporte al reves, sobreescribimos uno para llamar al otro metodo.
			return super.getPreviousValue();
		}
		
		// sobreescribimos el metodo, para que nos devuelva lo que hace el metodo contrario.
		public Object getPreviousValue() {
			
			return super.getNextValue();
			
		}
		*/
	}
	
}







