package graficos;

import javax.swing.*;

// disposicion (layout) tipo muelle / spring (resorte), donde vamos a colorcar 3 botones

public class PruebaDisposicionAvanzadaMuelleSpring {

	public static void main(String[] args) {
		
		MarcoMuelleSpring miMarcoSpring = new MarcoMuelleSpring();
		miMarcoSpring.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarcoSpring.setVisible(true);
		
	}

}

class MarcoMuelleSpring extends JFrame {
	
	public MarcoMuelleSpring() {
		
		setBounds(300, 200, 1000,400);
		LaminaMuelleSpring miLaminaSpring = new LaminaMuelleSpring();
		add(miLaminaSpring);
		
	}
	
}

class LaminaMuelleSpring extends JPanel {
	
	public LaminaMuelleSpring() {
		
		// creamos los 3 botones:
		JButton btn1 = new JButton("Boton 1");
		JButton btn2 = new JButton("Boton 2");
		JButton btn3 = new JButton("Boton 3");
		
		// creamos instancia de Springlayout
		SpringLayout miSpringLayout = new SpringLayout();
		
		// agregamos el layout creado:
		setLayout(miSpringLayout);
		
		add(btn1);
		add(btn2);
		add(btn3);
		
		// creamos los Spring con la clase Spring:
		Spring miMuelle = Spring.constant(0, 10, 100);
		
		// creamos Spring rigido para que no redimensione:
		Spring miMuelleRigido = Spring.constant(10); 	// 10 es el ancho del muelle
		
		// colocar el miMuelle entre el borde izquierdo y btn1
			// borde izquierdo del primer componente, componente, el muelle que vamos a colocar, borde oeste del contenedor, contenedor (estamos en el contstructor de la lamina, para hacer refencia a la propia lamina utilizo this.
		miSpringLayout.putConstraint(SpringLayout.WEST, btn1 , miMuelle, SpringLayout.WEST, this);
																		// comienza en la parte este, del btn1
		// miSpringLayout.putConstraint(SpringLayout.WEST, btn2, miMuelle, SpringLayout.EAST, btn1);
		
		// miSpringLayout.putConstraint(SpringLayout.WEST, btn3, miMuelle, SpringLayout.EAST, btn2);
		
		// USAMOS MUELLE RIGIDO PARA DISTANCIA ENTRE COMPONENTES:
		miSpringLayout.putConstraint(SpringLayout.WEST, btn2, miMuelleRigido, SpringLayout.EAST, btn1);
		
		miSpringLayout.putConstraint(SpringLayout.WEST, btn3, miMuelleRigido, SpringLayout.EAST, btn2);
		
		
		miSpringLayout.putConstraint(SpringLayout.EAST, this, miMuelle, SpringLayout.EAST, btn3);
		
	}
	
}




