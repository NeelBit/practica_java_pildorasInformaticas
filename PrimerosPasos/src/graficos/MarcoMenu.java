package graficos;

import java.awt.BorderLayout;
import java.awt.ScrollPane;

import javax.swing.*;
import javax.swing.JFrame;

public class MarcoMenu {

	public static void main(String[] args) {
		
		MenuFrame miMarco = new MenuFrame();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
	}

}

class MenuFrame extends JFrame {
	
	public MenuFrame() {
		
		setBounds(550, 250, 550, 350);
		MenuLamina miLamina = new MenuLamina();
		add(miLamina);
		
	}
	
}

class MenuLamina extends JPanel {
	
	public MenuLamina() {
		
		setLayout(new BorderLayout());
		
		// creamos barra
		JMenuBar miBarra = new JMenuBar();
		
		// creamos elementos del menu
		JMenu archivo = new JMenu("Archivo");
		JMenu edicion = new JMenu("Edicion");
		JMenu herramientas = new JMenu("Herramientas");
		
		//sub menu:
		JMenu opciones = new JMenu("Mas opciones");
		
		// creamos los menuItems
		JMenuItem guardar = new JMenuItem("Guardar");
		JMenuItem guardarComo = new JMenuItem("Guardar como");
		
		
		// iconos:
		ImageIcon iconCortar = new ImageIcon("src/graficos/cortar.png");
		ImageIcon iconCopiar = new ImageIcon("src/graficos/copiar.png");
		//ImageIcon iconPegar = new ImageIcon("src/graficos/pegar.png");
		
		
		JMenuItem cortar = new JMenuItem("Cortar", iconCortar);
		JMenuItem copiar = new JMenuItem("Copiar", iconCopiar);
		
		// poner el texto a la izquierda del texto
		copiar.setHorizontalTextPosition(SwingConstants.LEFT);
		
		JMenuItem pegar = new JMenuItem("Pegar", new ImageIcon("src/graficos/pegar.png")); 	// para hacerlo desde unalinea.
		
		
		JMenuItem generales = new JMenuItem("Herramientas generales");
		
		//sub menu:
		JMenuItem opcion1 = new JMenuItem("Opcion 1");
		JMenuItem opcion2 = new JMenuItem("Opcion 2");
		
		//añadimos item a los menus
		archivo.add(guardar);
		archivo.add(guardarComo);
		
		edicion.add(cortar);
		edicion.add(copiar);
		edicion.add(pegar);
		
		// pongo separador para que Opciones, quede separado, dentro del menu Edicion
		edicion.addSeparator();
		
		herramientas.add(generales);
		
		//sub menu:
		opciones.add(opcion1);
		opciones.add(opcion2);
		
		edicion.add(opciones);
		
		
		
		// añadimos elementos a la barra
		miBarra.add(archivo);
		miBarra.add(edicion);
		miBarra.add(herramientas);
		
		// añadimos barra a la lamina
		add(miBarra, BorderLayout.NORTH);
		
		// creo panel de texto
		JTextPane areaTextoMenu = new JTextPane();
		
		// creo Scroll para el area de texto
		JScrollPane miPanelScrollMenu = new JScrollPane(areaTextoMenu);
		
		// a la lamina principal le agrego el segundo panel en el centro
		add(miPanelScrollMenu, BorderLayout.CENTER);
		
	}
	
}





