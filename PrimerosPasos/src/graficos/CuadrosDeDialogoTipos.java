package graficos;

import javax.swing.*;
import java.awt.event.*;

public class CuadrosDeDialogoTipos {

	public static void main(String[] args) {
		
		CuadrosDialogos miCuadroDialogo = new CuadrosDialogos();
		miCuadroDialogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miCuadroDialogo.setVisible(true);
		
	}

}

class CuadrosDialogos extends JFrame {
	
	public CuadrosDialogos() {
		
		setBounds(300, 150, 400,400);
		LaminaCuadrosDialogos miLaminaDialogo = new LaminaCuadrosDialogos();
		add(miLaminaDialogo);
		
	}
	
}

class LaminaCuadrosDialogos extends JPanel {
	
	public LaminaCuadrosDialogos() {
		
		btn1 = new JButton("Boton 1");
		btn2 = new JButton("Boton 2");
		btn3 = new JButton("Boton 3");
		btn4 = new JButton("Boton 4");
		
		btn1.addActionListener(new AccionBotonesDialogo());
		btn2.addActionListener(new AccionBotonesDialogo());
		btn3.addActionListener(new AccionBotonesDialogo());
		btn4.addActionListener(new AccionBotonesDialogo());
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		
	}
	
	private class AccionBotonesDialogo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == btn1) {
				
				//System.out.println("Haz presionado el boton 1");
												// hago referencia a la propia lamina, mensaje
				//JOptionPane.showMessageDialog(LaminaCuadrosDialogos.this, "Presionaste el boton 1");
				
				JOptionPane.showMessageDialog(LaminaCuadrosDialogos.this, "presionaste boton 1", "boton 1", JOptionPane.WARNING_MESSAGE);
				
			}else if (e.getSource() == btn2) {
				
				//System.out.println("Has presionado el boton 2");
				
				//JOptionPane.showInputDialog(LaminaCuadrosDialogos.this, "Ingresa algo");
				
				JOptionPane.showInputDialog(LaminaCuadrosDialogos.this, "Introduce algo", "presionaste boton 2", JOptionPane.QUESTION_MESSAGE);
				
				
			}else if (e.getSource() == btn3) {
				
				//System.out.println("Has presionado el boton 3");
				
				//JOptionPane.showConfirmDialog(LaminaCuadrosDialogos.this, "confirme su respuesta");
				
				JOptionPane.showConfirmDialog(LaminaCuadrosDialogos.this, "confirme", "boton 3", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				
			}else if (e.getSource() == btn4) {
				
				//System.out.println("Has presionado el boton 4");
										// puedo usar null en el contenedor padre, para indicar centro de la pantalla
				JOptionPane.showOptionDialog(LaminaCuadrosDialogos.this, "confirme", "boton 4", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
				
			}
			
			
			
		}
		
		
		
	}
	
	private JButton btn1, btn2, btn3, btn4;
	
	
}






