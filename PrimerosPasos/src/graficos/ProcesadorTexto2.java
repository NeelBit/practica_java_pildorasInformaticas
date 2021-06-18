package graficos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class ProcesadorTexto2 {

	public static void main(String[] args) {
		
		MenuProcesador2 miMarco = new MenuProcesador2();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MenuProcesador2 extends JFrame {
	
	public MenuProcesador2() {
		
		setBounds(500, 200, 600, 500);
		LaminaProcesador2 LaminaProc2 = new LaminaProcesador2();
		add(LaminaProc2);
		setVisible(true);
		
	}
	
}

class LaminaProcesador2 extends JPanel {
	
	public LaminaProcesador2() {
		
		setLayout(new BorderLayout());
		
		// lamina con barra de menu, zona north
		JPanel laminaMenu2 = new JPanel();
		
		JMenuBar miBarraProcTexto2 = new JMenuBar();
		
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamagno = new JMenu("Tamaño");
		
		// para ejemplo de como poner JCheckBoxMenuItem y JRadioButtonMenuItem no vamos a
		// utilizar el metodo configuraMenu2 en negrita y cursiva ni en tamaño, para poder entender mejor.
		
		configuraMenu2("Arial", "fuente", "Arial", Font.PLAIN, 12, "");
		configuraMenu2("Courier", "fuente", "Courier", Font.PLAIN, 12, "");
		configuraMenu2("Verdana", "fuente", "Verdana", Font.PLAIN, 12, "");
		
		
		//configuraMenu2("Negrita", "estilo", "", Font.BOLD, 12, "src/graficos/iconNegrita.png");
		//configuraMenu2("Cursiva", "estilo", "", Font.ITALIC, 12, "src/graficos/iconCursiva.png");
		
		ImageIcon iconNegrita = new ImageIcon("src/graficos/iconNegrita.png");
		JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita", iconNegrita);
		// establecemos atajo de teclado para negrita. ctrl + n
		negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		estilo.add(negrita);
		
		ImageIcon iconCursiva = new ImageIcon("src/graficos/iconCursiva.png");
		JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva", iconCursiva);
		// atajo de teclado para cursiva: ctrl + i
		cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		estilo.add(cursiva);
		
		/*
		configuraMenu2("12", "tamaño", "", 1, 12, "");
		configuraMenu2("18", "tamaño", "", 1, 18, "");
		configuraMenu2("24", "tamaño", "", 1, 24, "");
		configuraMenu2("32", "tamaño", "", 1, 32, "");
		*/
		
		ButtonGroup grupoTamagnos = new ButtonGroup();
		
		JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
		JRadioButtonMenuItem dieciOcho = new JRadioButtonMenuItem("18");
		JRadioButtonMenuItem veintiCuatro = new JRadioButtonMenuItem("24");
		JRadioButtonMenuItem treintaYdos = new JRadioButtonMenuItem("32");
		
		// añadir atajo de teclado para cambiar a tamaño 32, ctrl + t
		treintaYdos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		
		grupoTamagnos.add(doce);
		grupoTamagnos.add(dieciOcho);
		grupoTamagnos.add(veintiCuatro);
		grupoTamagnos.add(treintaYdos);
		
		doce.addActionListener(new StyledEditorKit.FontSizeAction("", 12));
		dieciOcho.addActionListener(new StyledEditorKit.FontSizeAction("", 18));
		veintiCuatro.addActionListener(new StyledEditorKit.FontSizeAction("", 24));
		treintaYdos.addActionListener(new StyledEditorKit.FontSizeAction("", 32));
		
		tamagno.add(doce);
		tamagno.add(dieciOcho);
		tamagno.add(veintiCuatro);
		tamagno.add(treintaYdos);
		
		
		miBarraProcTexto2.add(fuente);
		miBarraProcTexto2.add(estilo);
		miBarraProcTexto2.add(tamagno);
		
		
		laminaMenu2.add(miBarraProcTexto2);
		
		add(laminaMenu2, BorderLayout.NORTH);
		
		// area de texto zona centro
		miAreaTexto2 = new JTextPane();
		
		JScrollPane scroll2 = new JScrollPane(miAreaTexto2); 	// añado scroll propio
		
		add(scroll2, BorderLayout.CENTER);
		
		// añadimos popup (menu emergente) al hacer click derecho:
		JPopupMenu emergenteEstilo = new JPopupMenu();
		
		JMenuItem negritaPopup = new JMenuItem("Negrita");
		JMenuItem cursivaPopup = new JMenuItem("Cursiva");
		
		emergenteEstilo.add(negritaPopup);
		emergenteEstilo.add(cursivaPopup);
		
		// hacemos que las opciones emergentes gestionen el evento:
		negritaPopup.addActionListener(new StyledEditorKit.BoldAction());
		cursivaPopup.addActionListener(new StyledEditorKit.ItalicAction());
		
		miAreaTexto2.setComponentPopupMenu(emergenteEstilo);
		
		// BARRA DE HERRAMIENTAS:
		
		/*
		
		JToolBar barraHerramientasProc = new JToolBar();
	
		
		JButton negritaHerramienta = new JButton(new ImageIcon("src/graficos/iconNegrita.png"));
		negritaHerramienta.addActionListener(new StyledEditorKit.BoldAction());
		barraHerramientasProc.add(negritaHerramienta);
		
		JButton cursivaHerramienta = new JButton(new ImageIcon("src/graficos/iconCursiva.png"));
		cursivaHerramienta.addActionListener(new StyledEditorKit.ItalicAction());
		barraHerramientasProc.add(cursivaHerramienta);
		
		// boton en la barra de tareas para subrayado:
		JButton subrayadoHerramienta = new JButton(new ImageIcon("src/graficos/iconSubrayado.png"));
		subrayadoHerramienta.addActionListener(new StyledEditorKit.UnderlineAction());
		barraHerramientasProc.add(subrayadoHerramienta);
		
		// botones para cambiar de color las letras:
		JButton letraAzulBarra = new JButton(new ImageIcon("src/graficos/a_azul 24.png"));
		JButton letraAmarilloBarra = new JButton(new ImageIcon("src/graficos/a_amarillo 24.png"));
		JButton letraRojoBarra = new JButton(new ImageIcon("src/graficos/r_rojo 24.png"));
		
		letraAzulBarra.addActionListener(new StyledEditorKit.ForegroundAction("color azul", Color.BLUE));
		letraAmarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("color amarillo", Color.YELLOW));
		letraRojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("color rojo", Color.RED));
		
		barraHerramientasProc.add(letraAzulBarra);
		barraHerramientasProc.add(letraAmarilloBarra);
		barraHerramientasProc.add(letraRojoBarra);
		
		// botones alineacion texto en la bara de herramientas:
		JButton alinIzquierda = new JButton(new ImageIcon("src/graficos/izquierda 24.png"));
		JButton alinCentrado = new JButton(new ImageIcon("src/graficos/centrado 24.png"));
		JButton alinDerecha = new JButton(new ImageIcon("src/graficos/derecha 24.png"));
		JButton alinJustificado = new JButton(new ImageIcon("src/graficos/justificado 24.png"));
		
		alinIzquierda.addActionListener(new StyledEditorKit.AlignmentAction("alineacion izquierda", StyleConstants.ALIGN_LEFT));
		alinCentrado.addActionListener(new StyledEditorKit.AlignmentAction("alineacion centrado", StyleConstants.ALIGN_CENTER));
		alinDerecha.addActionListener(new StyledEditorKit.AlignmentAction("alineacion derecha", StyleConstants.ALIGN_RIGHT));
		alinJustificado.addActionListener(new StyledEditorKit.AlignmentAction("alineacion justificado", StyleConstants.ALIGN_JUSTIFIED));
		
		barraHerramientasProc.add(alinIzquierda);
		barraHerramientasProc.add(alinCentrado);
		barraHerramientasProc.add(alinDerecha);
		barraHerramientasProc.add(alinJustificado);
		
		*/
		
		// achicando codigo con el metodos:
			// instancio la barra:
		barraHerramientasProc = new JToolBar();
			// al devolver un boton puedo ponerlo a la escucha:
		configuraBarra("src/graficos/iconNegrita.png").addActionListener(new StyledEditorKit.BoldAction());
		configuraBarra("src/graficos/iconCursiva.png").addActionListener(new StyledEditorKit.ItalicAction());
		configuraBarra("src/graficos/iconSubrayado.png").addActionListener(new StyledEditorKit.UnderlineAction());
		
		barraHerramientasProc.addSeparator();
		
		configuraBarra("src/graficos/a_azul 24.png").addActionListener(new StyledEditorKit.ForegroundAction("color azul", Color.BLUE));
		configuraBarra("src/graficos/a_amarillo 24.png").addActionListener(new StyledEditorKit.ForegroundAction("color amarillo", Color.YELLOW));
		configuraBarra("src/graficos/r_rojo 24.png").addActionListener(new StyledEditorKit.ForegroundAction("color rojo", Color.RED));
		
		barraHerramientasProc.addSeparator();
		
		configuraBarra("src/graficos/izquierda 24.png").addActionListener(new StyledEditorKit.AlignmentAction("alineacion izquierda", StyleConstants.ALIGN_LEFT));
		configuraBarra("src/graficos/centrado 24.png").addActionListener(new StyledEditorKit.AlignmentAction("alineacion centrado", StyleConstants.ALIGN_CENTER));
		configuraBarra("src/graficos/derecha 24.png").addActionListener(new StyledEditorKit.AlignmentAction("alineacion derecha", StyleConstants.ALIGN_RIGHT));
		configuraBarra("src/graficos/justificado 24.png").addActionListener(new StyledEditorKit.AlignmentAction("alineacion justificado", StyleConstants.ALIGN_JUSTIFIED));
		
		
		
		
		
		
			// poner en vertical la colocacion de los elementos a la barra.
		barraHerramientasProc.setOrientation(JToolBar.VERTICAL); // o ponemos 1
		
		add(barraHerramientasProc, BorderLayout.WEST);
		
		
		
	}
	
	// METODO PARA ACHICAR CODIGO Y CREAR BOTONES
	public JButton configuraBarra(String ruta) {
		
		JButton boton = new JButton(new ImageIcon(ruta));
		barraHerramientasProc.add(boton);
		return boton;
		
	}
	
	
	
	// METODO PARA CREAR LOS MENUITEMS Y PONER A LA ESCUCHA:
	public void configuraMenu2(String titulo, String menu, String tipoLetra, int estiloLetra, int tam, String icon) {
		
		JMenuItem elemMenu = new JMenuItem(titulo, new ImageIcon(icon));
		
		if (menu.equalsIgnoreCase("fuente")) {
			
			fuente.add(elemMenu);
			
			elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("", titulo));
			
		}
		/*
		else if(menu.equalsIgnoreCase("estilo")) {
			
			estilo.add(elemMenu);
			
			if(estiloLetra == Font.ITALIC) {
				
				elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
				
			}else if (estiloLetra == Font.BOLD){
				
				elemMenu.addActionListener(new StyledEditorKit.BoldAction());
				
			}
			
			
		}
		
		else if (menu.equalsIgnoreCase("tamaño")) {
			
			tamagno.add(elemMenu);
			
			elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", tam));
			
		}
		*/
	}
	
	
	private JTextPane miAreaTexto2;
	private JMenu fuente, estilo, tamagno;
	
	// achicando codigo
	private JToolBar barraHerramientasProc;
	
	
}