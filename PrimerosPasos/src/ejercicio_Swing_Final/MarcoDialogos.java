package ejercicio_Swing_Final;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MarcoDialogos extends JFrame {
	// JFrame por defecto trae BorderLayout (?), y JPanel FlowLayout.
	
	public MarcoDialogos() {
		
		setTitle("Prueba de dialogos");
		setBounds(400, 150, 600, 500);
		JPanel laminaCuadricula = new JPanel();
		laminaCuadricula.setLayout(new GridLayout(2, 3));
		
		String grid1[] = {"Mensaje", "Confirmar", "Opción", "Entrada"};
		gridTipo = new LaminaBotones("Tipo", grid1);
		
			// para hacer en una linea: instancio array en metodo
		gridTipoMensajes = new LaminaBotones("Tipo de mensajes", new String[] {
				
				"ERROR_MESSAGE", 
				"INFORMATION_MESSAGE",
				"WARNING_MESSAGE",
				"QUESTION_MESSAGE",
				"PLAIN_MESSAGE"
				
		});
		
		gridMensaje = new LaminaBotones("Mensaje", new String[] {
				
				"Cadena",
				"Icono",
				"Componente",
				"Otros",
				"Object[]"
				
		});
		
		gridTipoOpcion = new LaminaBotones("Confirmar", new String[] {
				
				"DEFAULT_OPTION",
				"YES_NO_OPTION",
				"YES_NO_CANCEL_OPTION",
				"OK_CANCEL_OPTION"
				
		});
		
		gridOpciones = new LaminaBotones("Opción", new String[] {
				
				"String[]",
				"Icon[]",
				"Object[]"
				
		});
		
		gridEntrada = new LaminaBotones("Entrada", new String[] {
				
				"Campo de texto",
				"Combo"
				
		});
		
		
		// agregando boxs al marco
		laminaCuadricula.add(gridTipo);
		laminaCuadricula.add(gridTipoMensajes);
		laminaCuadricula.add(gridMensaje);
		laminaCuadricula.add(gridTipoOpcion);
		laminaCuadricula.add(gridOpciones);
		laminaCuadricula.add(gridEntrada);
		
		// lamina sur con boton mostrar:
		JPanel panelSurMostrar = new JPanel();
		btnMostrar = new JButton("Mostrar");
		
		// funcionalidad a btnMostrar:
		btnMostrar.addActionListener(new AccionMostrar());
		
		panelSurMostrar.add(btnMostrar);
		
		
		
		add(laminaCuadricula, BorderLayout.CENTER);
		add(panelSurMostrar, BorderLayout.SOUTH);
		
		
	}
	
	//---------- metodo para devolver tipo de icono (int) ----------
	public int getIcono() {
		
		// String s = gridTipoMensajes.getSeleccion(); y comparar con s
		
		if (gridTipoMensajes.getSeleccion().equalsIgnoreCase("ERROR_MESSAGE")) {
			
			return JOptionPane.ERROR_MESSAGE;
			
		}else if (gridTipoMensajes.getSeleccion().equalsIgnoreCase("INFORMATION_MESSAGE")) {
			
			return JOptionPane.INFORMATION_MESSAGE;
			
		}else if (gridTipoMensajes.getSeleccion().equalsIgnoreCase("WARNING_MESSAGE")) {
			
			return JOptionPane.WARNING_MESSAGE;
			
		}else if (gridTipoMensajes.getSeleccion().equalsIgnoreCase("QUESTION_MESSAGE")) {
			
			return JOptionPane.QUESTION_MESSAGE;
			
		}else //(gridTipoMensajes.getSeleccion().equalsIgnoreCase("PLAIN_MESSAGE")) 
			{
			
			return JOptionPane.PLAIN_MESSAGE;
			
		}
		
	}
	
	
	//---------- metodo para devolver mensaje ----------
	public Object getMensaje() {
		
		String s = gridMensaje.getSeleccion();
		
		if (s.equalsIgnoreCase("Cadena")) {
			
			return cadenaMensaje;
			
		}else if (s.equalsIgnoreCase("Icono")) {
			
			return iconoMensaje;
			
		}else if (s.equalsIgnoreCase("Componente")) {
			
			return componentMensaje;
			
		}else if (s.equalsIgnoreCase("Otros")) {
			
			return objetoMensaje;
			
		}else if (s.equalsIgnoreCase("Object[]")) {
			
			return new Object[] {cadenaMensaje, iconoMensaje, componentMensaje, objetoMensaje};
			
		}else { 	// EL METODO ESTA OBLIGADO A DEVOLVER ALGO, ENTONCES DEBE TENER UN ELSE:
			return null;
		}
		
	}
	
	// ---------- metodo para devolver confirmacion ----------
	public int getConfirm() {
		
		String s = gridTipoOpcion.getSeleccion();
		
		if (s.equalsIgnoreCase("DEFAULT_OPTION")) {
			
			return JOptionPane.DEFAULT_OPTION;
			
		}else if (s.equalsIgnoreCase("YES_NO_OPTION")) {
			
			return JOptionPane.YES_NO_OPTION;
			
		}else if (s.equalsIgnoreCase("YES_NO_CANCEL_OPTION")) {
			
			return JOptionPane.YES_NO_CANCEL_OPTION;
			
		}else if (s.equalsIgnoreCase("OK_CANCEL_OPTION")) {
			
			return JOptionPane.OK_CANCEL_OPTION;
			
		}else return 0;
		
		
	}
	
	// ----------- metodo para devolver array de opciones ----------
	public Object[] getArrayOpciones(LaminaBotones lamina) {
		
		String s = lamina.getSeleccion();
		if (s.equalsIgnoreCase("String[]")) {
			
			return new String[] {"Amarillo", "Azul", "Rojo"};
			
		}else if (s.equalsIgnoreCase("Icon[]")) {
					// o new Object[]
			return new Icon[] {new ImageIcon("src/ejercicio_Swing_Final/botonAmarillo.png"),
								new ImageIcon("src/ejercicio_Swing_Final/botonAzul.png"),
								new ImageIcon("src/ejercicio_Swing_Final/botonRojo.png")
					
			};
		}else if (s.equalsIgnoreCase("Object[]")) {
			
			return new Object[] {cadenaMensaje, iconoMensaje, objetoMensaje, componentMensaje};
			
		}else return null;
		
	}
	
	// propio, darle titulo apropiado según tipo de grid:
	public String getTitulo() {
		
		if (gridTipo.getSeleccion().equalsIgnoreCase("Mensaje")) {
			
			return "Cuandro de Mensaje";
			
		}else if (gridTipo.getSeleccion().equalsIgnoreCase("Confirmar")) {
			
			return "Cuandro de Confirmar";
			
		}else if (gridTipo.getSeleccion().equalsIgnoreCase("Opción")) {
			
			return "Cuadro de Opcion";
			
		}else if (gridTipo.getSeleccion().equalsIgnoreCase("Entrada")) {
			
			return "Cuadro de Entrada";
			
		}else return "Título";
		
	}
	
	
	// ---------- EVENTO ACEPTAR - CLASE PRIVADA ----------
	
	private class AccionMostrar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//System.out.println(gridTipo.getSeleccion());
			
			if (gridTipo.getSeleccion().equalsIgnoreCase("Mensaje")) {
				
				JOptionPane.showMessageDialog(MarcoDialogos.this, getMensaje(), getTitulo(), getIcono());
				
			}else if (gridTipo.getSeleccion().equalsIgnoreCase("Confirmar")) {
				
				JOptionPane.showConfirmDialog(MarcoDialogos.this, getMensaje(), getTitulo(), getConfirm(), getIcono());
				
			}else if (gridTipo.getSeleccion().equalsIgnoreCase("Opción")) {
																					// 1 para que muestre 3 botones
				JOptionPane.showOptionDialog(MarcoDialogos.this, getMensaje(), getTitulo(), 1, getIcono(), null, getArrayOpciones(gridOpciones), null);
			
			}else if (gridTipo.getSeleccion().equalsIgnoreCase("Entrada")) {
				
				if (gridEntrada.getSeleccion().equalsIgnoreCase("Campo de texto")) {
					
					JOptionPane.showInputDialog(MarcoDialogos.this, getMensaje(), getTitulo(), getIcono());
					
				}else if (gridEntrada.getSeleccion().equalsIgnoreCase("Combo")){
					
					JOptionPane.showInputDialog(MarcoDialogos.this, getMensaje(), getTitulo(), getIcono(), null, new String[] {"Amarillo", "Azul", "Rojo"}, "Azul");
					
				}
			}
			
		}
		
	}
	
	private LaminaBotones gridTipo, gridTipoMensajes, gridMensaje, gridTipoOpcion, gridOpciones, gridEntrada;
	private JButton btnMostrar;
	
	private String cadenaMensaje = "Mensaje...";
	private Icon iconoMensaje = new ImageIcon("src/ejercicio_Swing_Final/icono.png");
	private Object objetoMensaje = new Date();
	private Component componentMensaje = new LaminaMensaje(); 	// rectangulo amarillo
	
	
}

// dibujamos el rectangulo amarillo para el mensaje tipo componente.
class LaminaMensaje extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D)g;
																	// que tenga las mismas dimensiones que la lamina
		Rectangle2D rectanguloAmarillo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
		
		g2.setPaint(Color.YELLOW);
		
		// rellenar el rectangulo
		g2.fill(rectanguloAmarillo);
		
		
	}
	
	
	
}


