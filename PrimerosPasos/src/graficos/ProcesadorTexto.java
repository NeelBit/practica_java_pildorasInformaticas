package graficos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class ProcesadorTexto {

	public static void main(String[] args) {
		
		MenuProcesador miMarco = new MenuProcesador();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MenuProcesador extends JFrame {
	
	public MenuProcesador() {
		
		setBounds(500, 250, 550, 400);
		LaminaProcesador miLamina = new LaminaProcesador();
		add(miLamina);
		setVisible(true);
		
	}
	
}

class LaminaProcesador extends JPanel {
	
	public LaminaProcesador() {
		
		setLayout(new BorderLayout());
		
		// lamina con barra de menu, zona north
		JPanel laminaMenu = new JPanel();
		
		JMenuBar miBarra = new JMenuBar();
		
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamagno = new JMenu("Tamaño");
		
		/*
		JMenuItem arial = new JMenuItem("Arial");
		JMenuItem courier = new JMenuItem("Courier");
		JMenuItem verdana = new JMenuItem("Verdana");
		
		fuente.add(arial);
		fuente.add(courier);
		fuente.add(verdana);
		
		JMenuItem negrita = new JMenuItem("Negrita");
		JMenuItem cursiva = new JMenuItem("Cursiva");
		
		estilo.add(negrita);
		estilo.add(cursiva);
		
		JMenuItem doce = new JMenuItem("12");
		JMenuItem dieciocho = new JMenuItem("18");
		JMenuItem venticuatro = new JMenuItem("24");
		JMenuItem treintaydos = new JMenuItem("32");
		
		//-- clase interna anonima
		
		arial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				miAreaTexto.setFont(new Font("Arial", Font.PLAIN, 12));
				
			}
			
		});
		
		courier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				miAreaTexto.setFont(new Font("Courier", Font.PLAIN, 12));
				
			}
			
		});
		
		verdana.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				miAreaTexto.setFont(new Font("Verdana", Font.PLAIN, 12));
				
			}
			
		});
		
		tamagno.add(doce);
		tamagno.add(dieciocho);
		tamagno.add(venticuatro);
		tamagno.add(treintaydos);
		*/
		
		configuraMenu("Arial", "fuente", "Arial", Font.PLAIN, 12);
		configuraMenu("Courier", "fuente", "Courier", Font.PLAIN, 12);
		configuraMenu("Verdana", "fuente", "Verdana", Font.PLAIN, 12);
		
		configuraMenu("Negrita", "estilo", "", Font.BOLD, 12);
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 12);
		
		configuraMenu("12", "tamaño", "", 1, 12);
		configuraMenu("18", "tamaño", "", 1, 18);
		configuraMenu("24", "tamaño", "", 1, 24);
		configuraMenu("32", "tamaño", "", 1, 32);
		
		
		
		miBarra.add(fuente);
		miBarra.add(estilo);
		miBarra.add(tamagno);
		
		
		laminaMenu.add(miBarra);
		
		add(laminaMenu, BorderLayout.NORTH);
		
		// area de texto zona centro
		miAreaTexto = new JTextPane();
		
		JScrollPane scroll = new JScrollPane(miAreaTexto); 	// añado scroll propio
		
		add(scroll, BorderLayout.CENTER);
		
		
		
	}
	
	// metodo por clase interna para cambiar a la letra courier
	/*private class GestionaMenus implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			miAreaTexto.setFont(new Font("Courier", Font.PLAIN, 12));
			
		}
	}
	*/
	
	// METODO PARA CREAR LOS MENUITEMS Y PONER A LA ESCUCHA:
	public void configuraMenu(String titulo, String menu, String tipoLetra, int estiloLetra, int tam) {
		
		JMenuItem elemMenu = new JMenuItem(titulo);
		
		if (menu.equalsIgnoreCase("fuente")) {
			
			fuente.add(elemMenu);
			
		}else if(menu.equalsIgnoreCase("estilo")) {
			
			estilo.add(elemMenu);
			
		}else if (menu.equalsIgnoreCase("tamaño")) {
			
			tamagno.add(elemMenu);
			
		}
		
		elemMenu.addActionListener(new GestionaEventos(titulo, tipoLetra, estiloLetra, tam));
		
	}
	
	private class GestionaEventos implements ActionListener {

		String tipo_texto, menu;
		int estilo_letra, tam_letra;
		
		// constructor:
		public GestionaEventos(String elementoPulsado, String tituloElemento, int estiloPulsado, int tamLetraPulsada) {


			tipo_texto = tituloElemento;
			estilo_letra = estiloPulsado;
			tam_letra = tamLetraPulsada;
			menu = elementoPulsado;
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// en la variable letras almaceno lo que tiene el area de texto.
			letras = miAreaTexto.getFont();
			
			if (menu.equalsIgnoreCase("arial") || menu.equalsIgnoreCase("courier") || menu.equalsIgnoreCase("verdana")) {
				
				estilo_letra = letras.getStyle();
				tam_letra = letras.getSize();
				
			}else if (menu.equalsIgnoreCase("negrita") || menu.equalsIgnoreCase("cursiva")) {
				
				// solucionar que cuando se cambia el estilo luego el tipo de letra solo conserva el ultimo estilo
				if (letras.getStyle() == 1 || letras.getStyle() == 2) {
					
					estilo_letra = 3;
					
				}
				
				tipo_texto = letras.getFontName();
				tam_letra = letras.getSize();
				
			}else if (menu.equals("12") || menu.equals("18") || menu.equals("24") || menu.equals("32")) {
				
				tipo_texto = letras.getFontName();
				estilo_letra = letras.getStyle();
				
			}
			
			miAreaTexto.setFont(new Font(tipo_texto, estilo_letra, tam_letra));
			
			System.out.println("La letra seleccionada es: " + tipo_texto + "\n" + "El estilo de letra es: " + 
								estilo_letra + "\n" + "El tamaño de la letra es: " + tam_letra);
			
		}
	}
	
	private JTextPane miAreaTexto;
	private JMenu fuente, estilo, tamagno;
	private Font letras;
	
}








