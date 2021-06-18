package graficos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// TODO EN UNA SOLA CLASE, sin modularizacion (NO RECOMENDADO) pero es un ejemplo practico

public class PruebaAreaTexto {

	public static void main(String[] args) {
		
		MarcoPruebaAreaTexto miMarco = new MarcoPruebaAreaTexto();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
	}

}

class MarcoPruebaAreaTexto extends JFrame {
	
	public MarcoPruebaAreaTexto() {
		
		setTitle("Probando area de texto");
		setBounds(500, 250, 500, 400);
		
		setLayout(new BorderLayout()); 		// ponemos la disposicion directo en el marco sin lamina principal
		
		laminaBotones = new JPanel(); 		// inicio objeto JPanel
		
		// boton insertar.
		btnInsertar = new JButton("Insertar"); 	// al pulsar en el boton ejecuta el la accion de abajo y escribe lo del metodo append
		btnInsertar.addActionListener(new ActionListener() { 	// en una sola linea creamos un objeto ActionListener y queda a la escucha del evento

			@Override
			public void actionPerformed(ActionEvent e) {
				// la diferencia entre append y setText es que append conserva el texto
				areaTexto.append("En un lugar de la Mancha cuyo nombre no quiero acordarme...");
				
			}
			
		});
		
		laminaBotones.add(btnInsertar);
		
		// boton salto de linea.
		btnSaltoLinea = new JButton("Salto linea");
		btnSaltoLinea.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// si en el area de texto no hay saltos de linea se almacena un true, entonces al presionar el boton aplica saltos de linea.
				
				// por defecto no hay salto de linea, entonces al principio al ser =! guarda un true
				boolean saltar=!areaTexto.getLineWrap(); 	// lo contrario que devuelve el metodo getLineWrap (si tiene saltos de linea true)
				System.out.println(saltar);
				areaTexto.setLineWrap(saltar); 		// establecer salto de linea. contrario al que este en ese momento, por eso la evaluacion de arriba.
				// hay arriba aplica, despues sale boton.
				/*
				// para cambiar el texto del boton dependiendo de si hay o no hay salto de linea:
				if (saltar) { 	// saltar es booleano
					// si no hay saltos de linea saltar almacena que true, entonces aplica este nombre.
					btnSaltoLinea.setText("Quitar salto");
					
				}else {
					
					btnSaltoLinea.setText("Salto linea");
					
				}
				*/
				
				btnSaltoLinea.setText(saltar ? "Quitar salto" : "Salto linea"); 	// operador ternario
				
				// por defecto obtiene false, entonces guarda true, y aplica quitar salto
			}
		});
		
		laminaBotones.add(btnSaltoLinea);
		
		add(laminaBotones, BorderLayout.SOUTH); 		// agregamos lamina de botones al sur del marco
		
		areaTexto = new JTextArea(8, 20); 		//8 filas, 20 columnas
		
		laminaConBarras = new JScrollPane(areaTexto); 	// ponemos el area de texto dentro de la lamina con barras
		
		add(laminaConBarras, BorderLayout.CENTER); 		// añadimos la lamina con barras dentro del centro del marco.
		
	}
	
	private JPanel laminaBotones; 		// defino objeto tipo lamina
	
	private JButton btnInsertar, btnSaltoLinea; 	// defino botones
	
	private JTextArea areaTexto;
	
	private JScrollPane laminaConBarras; // lamina con desplazamiento
	
	
}










