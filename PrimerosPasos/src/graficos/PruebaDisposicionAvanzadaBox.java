package graficos;

import java.awt.*;

import javax.swing.*;

public class PruebaDisposicionAvanzadaBox {

	public static void main(String[] args) {
		
		MarcoCaja marcoBox = new MarcoCaja();
		marcoBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marcoBox.setVisible(true);
		
	}

}

class MarcoCaja extends JFrame {
	
	public MarcoCaja() {
		
		setTitle("Marco en la caja");
		setBounds(550, 200, 300,300);
		
		// los componentes que van a estar en la 1ª caja
		JLabel rotulo1 = new JLabel("Nombre: "); 	// etiqueta
		JTextField texto1 = new JTextField(10);
		texto1.setMaximumSize(texto1.getPreferredSize());	// para que no tenga problema cuando se redimensiona el marco
		
		// creamos la 1ª caja horizontal: elementos ordenados de forma horizantal!
		Box cajaH1 = Box.createHorizontalBox();
		
		// agregamos estos elementos a la 1ª caja, y espacio:
		cajaH1.add(rotulo1);
		
		cajaH1.add(Box.createHorizontalStrut(100)); 	// espacio en pixeles (140 coincide)
		
		cajaH1.add(texto1);
		
		// los componentes que van a estar en la 2ª caja
		JLabel rotulo2 = new JLabel("Contraseña: ");
		JPasswordField texto2 = new JPasswordField(10);
		texto2.setMaximumSize(texto2.getPreferredSize()); 	// para que no tengo problema al redimensionar
		
		// creamos la 2ª caja horizantal:
		Box cajaH2 = Box.createHorizontalBox();
		
		// agregamos elementos a la 2ª caja:
		cajaH2.add(rotulo2);
		cajaH2.add(Box.createHorizontalStrut(100));
		cajaH2.add(texto2);
		
		// botones para 3ª caja:
		JButton btnOk = new JButton("Ok");
		JButton btnCancelar = new JButton("Cancelar");
		
		// creamos 3ª caja horizontal
		Box cajaH3 = Box.createHorizontalBox();
		
		// agregamos botones a la 3ª caja:
		cajaH3.add(btnOk);
		cajaH3.add(Box.createGlue()); 	// pega en un extremo y en el otro los elementeos. cuadno se redimensiona la distancia SI varía.
		cajaH3.add(btnCancelar);
		
		// meter las 3 cajas horizontales, dentro de un box vertical:
		Box cajaVertical = Box.createVerticalBox();
		
		cajaVertical.add(cajaH1);
		cajaVertical.add(cajaH2);
		cajaVertical.add(cajaH3);
		
		// agregamos caja vertical al marco:
		add(cajaVertical, BorderLayout.CENTER); 	// marcos por defecto traen BorderLayout(?)
		
		
	}
	
}



