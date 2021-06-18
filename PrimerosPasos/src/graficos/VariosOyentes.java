package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VariosOyentes {

	public static void main(String[] args) {
		
		MarcoPrincipal miMarco = new MarcoPrincipal();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
	}

}


class MarcoPrincipal extends JFrame {
	
	public MarcoPrincipal() {
		
		setTitle("Prueba varios");
		setBounds(700, 100, 500, 400);
		
		LaminaPrincipal lamina = new LaminaPrincipal();
		add(lamina);
		
		
		
	}
	
}

class LaminaPrincipal extends JPanel {
	
	public LaminaPrincipal() {
		
		JButton botonNuevo = new JButton("Nuevo"); // fuente de eventos
		add(botonNuevo);
		
		botonCerrar = new JButton("Cerrar todo");
		add(botonCerrar);
		
		// decirle que el botonNuevo es una fuente de eventos:
		// se crea un objeto de la clase interna(oyente)
		OyenteNuevo miOyente = new OyenteNuevo();
		botonNuevo.addActionListener(miOyente);
		
	}
	
	// se desencadena evento que recibe la clase oyente, la clase oyente crea marco
	
	private class OyenteNuevo implements ActionListener { 	// clase oyente 

		@Override
		public void actionPerformed(ActionEvent e) {
			
			MarcoEmergente marco = new MarcoEmergente(botonCerrar);
			
		}
	}
	
	JButton botonCerrar;
	
}

//debo crear un objeto de cierra todos y asociar a un objeto fuente(botonCerrar)

class MarcoEmergente extends JFrame { 	// oyentes.?
	
	public MarcoEmergente(JButton boton_de_principal) { 		// recibe un parametro para la referencia al boton cerrar que se encuentra en otra clase
		
		contador++;
		setTitle("Ventana " + contador); 
		setBounds(40*contador, 50*contador, 300, 200);
		setVisible(true);
		
		// cada ves que creo una ventana emergente recibe un oyente pero no lo agrega, sin embargo
		// para la fuente unica (cerrar botonCerrar "cerrar todos) funciona
		CierraTodos oyenteCerrar = new CierraTodos(); // instancia de la clase oyente creada
		boton_de_principal.addActionListener(oyenteCerrar); // pongo a la escucha
	}
	
	private class CierraTodos implements ActionListener { //(clase oyente. Al ser marcos los que abre, debo hacerlo adentro y deben escuchar el evento

		@Override
		public void actionPerformed(ActionEvent e) {
			
			dispose(); 		// "cerrar" las ventanas
			
		}
		
		
		
	}
	
	private static int contador = 0;
	
}







