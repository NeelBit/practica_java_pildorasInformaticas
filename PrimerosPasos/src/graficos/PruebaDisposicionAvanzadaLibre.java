package graficos;

import javax.swing.*;
import java.awt.*;

// CREAR LAYOUT PROPIO

public class PruebaDisposicionAvanzadaLibre {

	public static void main(String[] args) {
		
		MarcoDisposicionLibre miMarcoLibre = new MarcoDisposicionLibre();
		miMarcoLibre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarcoLibre.setVisible(true);
		
	}

}

class MarcoDisposicionLibre extends JFrame {
	
	public MarcoDisposicionLibre() {
		
		setBounds(450, 250, 600, 400);
		LaminaDisposicionLibre miLaminaLibre = new LaminaDisposicionLibre();
		add(miLaminaLibre);
		
	}
	
}

class LaminaDisposicionLibre extends JPanel {
	
	public LaminaDisposicionLibre() {
		
		// deshabilitar FlowLayout para usar disposicion libre
		// setLayout(null);
		
		/*
		JButton btn1 = new JButton("Boton 1");
		btn1.setBounds(10, 10, 200, 50);
		add(btn1);
		JButton btn2 = new JButton("Boton 2");
		btn2.setBounds(220, 10, 200, 50);
		add(btn2);
		*/
		
		
		JLabel nombre = new JLabel("Nombre: ");
		JLabel apellido = new JLabel("Apellido: ");
		JLabel edad = new JLabel("Edad");
		JLabel tel = new JLabel("Telefono");
		
		JTextField textoN = new JTextField();
		JTextField textoA = new JTextField();
		JTextField textoEdad = new JTextField();
		JTextField textoTel = new JTextField();
		
		/*
		nombre.setBounds(10, 10, 100, 20);
		apellido.setBounds(10, 40, 100, 20);
		
		textoN.setBounds(100, 10, 100, 20);
		textoA.setBounds(100, 40, 100, 20);
		*/
		
		setLayout(new EnColumnas());
		
		add(nombre);
		add(textoN);
		
		add(apellido);
		add(textoA);
		
		add(edad);
		add(textoEdad);
		
		add(tel);
		add(textoTel);
		
	}
	
}

class EnColumnas implements LayoutManager {

	@Override
	public void addLayoutComponent(String name, Component comp) {
		
		
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		
		
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		
		
		
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		
		
		
		return null;
	}

	@Override
	public void layoutContainer(Container parent) {
		
		// almacena el ancho
		int d = parent.getWidth();
		
		// divide el ancho, osea obtiene la mitad
		int x = d/2;
		
		int contador = 0;
		int n = parent.getComponentCount();
		
		for (int i = 0; i < n; i++) {
			
				// cada ves que contador sea par debe incrementar y, para formar columnas
			contador++;
			
			Component c = parent.getComponent(i);
			
			c.setBounds(x-100, y, 100, 20);
			
			x+= 100;
			
			// evaluar si es par el componente
			if ((contador % 2) == 0) {
				
				// eje x debe volver a posicion inicial
				x = d/2;
				y+= 40;
				
			}
			
			
		}
		
		
	}
	
	private int x;
	private int y = 20;
	
}






