package graficos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;

public class Calculadora {

	public static void main(String[] args) {
		
		MarcoCalculadora marco = new MarcoCalculadora();
		
		
	}

}

class MarcoCalculadora extends JFrame {
	
	public MarcoCalculadora() {
		
		//centrar marco:
		/*Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension resolucionPantalla = miPantalla.getScreenSize();
		int altura = resolucionPantalla.height;
		int ancho = resolucionPantalla.width;
		*/
		//setBounds(ancho/4, altura/4, ancho/2, altura/2);
		
		setBounds(500, 200, 300, 350);
		
		setTitle("Calculadora");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new LaminaCalculadora()); 	// añadimos una instancia de la lamina principal
		
		setVisible(true);
		//pack(); 		// acomoda los botones y tamaño
	}
	
}

class LaminaCalculadora extends JPanel {
	
	public LaminaCalculadora() {
		
		principio = true; 		// ponemos en true el boolean, que borra el primer cero
		
		setLayout(new BorderLayout());
		
		pantalla = new JButton("0");
		
		pantalla.setEnabled(false); 			// deshabilita boton.
		
		add(pantalla, BorderLayout.NORTH);
		
		lamina2 = new JPanel();
		lamina2.setLayout(new GridLayout(4, 4)); 		// creamos layout tipo rejilla de 4x4 dentro de lamina2
		
		// creamos botones:
		/*JButton boton1 = new JButton("1");
		lamina2.add(boton1);
		JButton boton2 = new JButton("2");
		lamina2.add(boton2);
		JButton boton3 = new JButton("3");
		lamina2.add(boton3);
		JButton boton4 = new JButton("4");
		lamina2.add(boton4);
		JButton boton5 = new JButton("5");
		lamina2.add(boton5);
		JButton boton6 = new JButton("6");
		lamina2.add(boton6);
		JButton boton7 = new JButton("7");
		lamina2.add(boton7);
		JButton boton8 = new JButton("8");
		lamina2.add(boton8);
		JButton boton9 = new JButton("9");
		lamina2.add(boton9);
		JButton boton0 = new JButton("0");
		lamina2.add(boton0);
		JButton botonMas = new JButton("+");
		lamina2.add(botonMas);
		JButton botonMenos = new JButton("-");
		lamina2.add(botonMenos);
		*/
		
		ActionListener insertar = new InsertaNumero(); 		// crear objeto que escucha y pasar por parametro a ponerBoton
		
		ActionListener orden = new AccionOrden();
		
		ponerBoton("7", insertar);
		ponerBoton("8", insertar);
		ponerBoton("9", insertar);
		ponerBoton("/", orden);
		
		ponerBoton("4", insertar);
		ponerBoton("5", insertar);
		ponerBoton("6", insertar);
		ponerBoton("*", orden);
		
		ponerBoton("1", insertar);
		ponerBoton("2", insertar);
		ponerBoton("3", insertar);
		ponerBoton("+", orden);
		
		ponerBoton(",", insertar);
		ponerBoton("0", insertar);
		ponerBoton("=", orden);
		ponerBoton("_", orden);
		
		add(lamina2, BorderLayout.CENTER);
		
		ultimaOperacion = "=";
		
	}
	// cuando hace click en algun boton se crea un evento del tipo ActionListener
	// actionPerformed almacena en e el texto del boton (objeto del evento)
	// y lo establece en pantalla
	private void ponerBoton(String n, ActionListener oyente) { 	// ahorrar codigo con un metodo, y poner a la escucha los botones
		
		JButton boton = new JButton(n);
		
		boton.addActionListener(oyente);
		
		lamina2.add(boton);
	}
	
	private class InsertaNumero implements ActionListener { 	//clase interna, poner a la escucha los botones, manejo de evento

		@Override
		public void actionPerformed(ActionEvent e) {
			// poner a la escucha botones, capturar String asociado a boton y mostrar arriba
			
			String entrada = e.getActionCommand(); 		// devuelve string asociado a la accion
			
			if (principio) { 	// solamente la primera ves es verdadero
				
				pantalla.setText(""); 		// cuando principio esta en true poner vacio
				principio = false;
			}
			
			//pantalla.setText(entrada); 		// abajo para que muestre lo que hay + el nuevo boton presionado
			pantalla.setText(pantalla.getText() + entrada);
		} 
		
		
		
	}
	
	private class AccionOrden implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String operacion = e.getActionCommand();
			
			//System.out.println(operacion); 	// verificar
			
			calcular(Double.parseDouble(pantalla.getText())); 		// el String de pantalla lo pasamos a double.
			
			ultimaOperacion = operacion;
			
			principio = true; 		// para que no concatene el valor numerico despues de pulsar un boton de orden.
			
			
			
		}
		
		public void calcular(double x) {
			
			if (ultimaOperacion.equals("+")) {
				
				resultado += x; 	// la x lo que pasamos por parametro, es lo que hay en pantalla
				
				//System.out.println(resultado); comprobar
				
			}else if (ultimaOperacion.equals("_")) {
				
				resultado -= x;
				
			}else if (ultimaOperacion.equals("*")) {
				
				resultado *= x;
				
			}else if (ultimaOperacion.equals("/")) {
				
				resultado /= x;
				
			}
			else if (ultimaOperacion.equals("=")) {
				
				resultado = x; 	// lo que paso por parametro, lo que hay en pantalla
				
			}
				
			pantalla.setText("" + resultado); 		// con un espacio vacio se concatena y convierte en String
			
		}
		
	}
	
	
	private JPanel lamina2 = new JPanel();
	
	private JButton pantalla = new JButton();
	
	private boolean principio;	// valor por defecto false
	
	private double resultado;
	
	private String ultimaOperacion;
	
	
}









