package usoThreads;

import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads {

	public static void main(String[] args) {
		
		JFrame marco = new MarcoRebote();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
		
	}

}

// PROGRAMAR MULTIHILO:
class PelotaHilos implements Runnable {

	public PelotaHilos (Pelota unaPelota, Component unComponente) {
		
		pelota = unaPelota;
		componente = unComponente;
		
	}
	
	
	@Override
	public void run() {
		
		// imprimir en consola si el hilo esta interrumpido o no:
		System.out.println("Estado del hilo al comenzar (se encuentra interrumpido?) : " + Thread.currentThread().isInterrupted());
		
		// pego el codigo del hilo, osea el for, cambio el nombre de lamina pelota coincide.
		// cuando instanciamos tenemos que pasar los dos parametros (unaPelota, unComponente).
		for (int i=1; i<=3000; i++){ 	// la pelota va a tener 3000 movimientos
			
			pelota.muevePelota(componente.getBounds()); 	// recibe dimensiones de lamina
			
			//componente.paint(componente.getGraphics()); 	// solucion para que no se borre los botones.(?)
			componente.repaint(); 		// repaint hace refresco de pantalla - paint pinta todo de nuevo componente a componente
			
			// hacer una pausa de 10 milisegundos por cada vuelta del for
			try {	
				// hacemos pausa para que el ojo pueda captar el movimiento
				Thread.sleep(2); 	// metodo para pausar! metodo de la clase Thread , static
				
			} catch (InterruptedException e) {
				
				//System.out.println("Excepcion: " + e.getMessage());
				
				Thread.currentThread().interrupt(); 	// cuando lanza la excepcion la controlamos e interrumpimos hilo
				
			}
			
		}
		
		
		// reemplazo for para hacer indefinidamente los rebotes, y no utilizar sleep(que nos permitia ver la pelota)
		/*while(!Thread.interrupted()) { 	// mientras no esté interrumpido se ejecuta while
		// si queremos usar isInterrupted, que no no estatico, y detiene el hilo que este en uso:
		//while(!Thread.currentThread().isInterrupted()) {	// currentThread devuelve el hilo que esta en ejecucion en ese momento
			
			pelota.muevePelota(componente.getBounds());
			
			componente.repaint();
			
		}*/
		
		// imprimir en consola si el hilo esta interrumpido o no: me devuelve false no se porque
		System.out.println("Estado del hilo al finalizar(se encuentra interrumpido?) : " + Thread.currentThread().isInterrupted());
		
	}
	
	private Pelota pelota;
	private Component componente;
	
}



// movimiento de la pelota--------------------------------------------------------------
class Pelota {
	
	// mueve la pelota invirtiendo posicion si choca con limites
	public void muevePelota(Rectangle2D limites) { 	// por parametro recibe las dimensiones de la lamina
		
		// al incrementar da la sensacion de movimiento
		x+=dx;
		
		y+=dy;
		
		if(x<limites.getMinX()){
			
			x=limites.getMinX();
			
			dx=-dx;
		}
		
		if(x + TAMX>=limites.getMaxX()){
			
			x=limites.getMaxX() - TAMX;
			
			dx=-dx;
		}
		
		if(y<limites.getMinY()){
			
			y=limites.getMinY();
			
			dy=-dy;
		}
		
		if(y + TAMY>=limites.getMaxY()){
			
			y=limites.getMaxY()-TAMY;
			
			dy=-dy;
			
		}
		
	}
	
	//Forma de la pelota en su posición inicial
	public Ellipse2D getShape(){
			
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
			
		}	
		
		
	private static final int TAMX=15;
		
	private static final int TAMY=15;
		
	private double x=0;
		
	private double y=0;
		
	private double dx=1;
	
	private double dy=1;
		
		
}


//Lámina que dibuja las pelotas-----------------------------------------------------------
class LaminaPelota extends JPanel{
	
	//Añadimos pelota a la lámina
	public void add(Pelota b){
		
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
		
		
	}
	
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}


//Marco con lámina y botones-------------------------------------------------------------
class MarcoRebote extends JFrame{
	
	public MarcoRebote(){
		
		setBounds(450,300,600,350);
		
		setTitle ("Rebotes");
		
		lamina=new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
		
		/*
		ponerBoton(laminaBotones, "Dale!", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				comienza_el_juego();
			}
			
		});
		
		
		ponerBoton(laminaBotones, "Salir", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				System.exit(0);
				
			}
			
		});
		
		ponerBoton(laminaBotones, "Parar", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				detener();
				
			}
			
			
		});
		*/
		
		// 3 botones con un hilo cada uno:
		btn1 = new JButton("Hilo 1");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				comienza_el_juego(e);
				
			}
			
		});
		
		btn2 = new JButton("Hilo 2");
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				comienza_el_juego(e);
				
			}
			
		});
		
		btn3 = new JButton("Hilo 3");
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				comienza_el_juego(e);
				
			}
			
		});
		
		// botones para detener hilos:
		btnStop1 = new JButton("detener 1");
		btnStop1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				detener(e);
				
			}
			
		});
		
		btnStop2 = new JButton("detener 2");
		btnStop2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				detener(e);
				
			}
			
		});
		
		btnStop3 = new JButton("detener 3");
		btnStop3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				detener(e);
				
			}
			
		});
		
		
		
		// agrego todos los botones:
		laminaBotones.add(btn1);
		laminaBotones.add(btn2);
		laminaBotones.add(btn3);
		
		laminaBotones.add(btnStop1);
		laminaBotones.add(btnStop2);
		laminaBotones.add(btnStop3);
		
		add(laminaBotones, BorderLayout.SOUTH);
	}
	
	
	// Metodo para poner botones
	/*public void ponerBoton(Container c, String titulo, ActionListener oyente){
		
		JButton boton=new JButton(titulo);
		
		c.add(boton);
		
		boton.addActionListener(oyente);
		
	}
	*/
	
	//Añade pelota y la bota 1000 veces
	public void comienza_el_juego (ActionEvent e){
		
			Pelota pelota=new Pelota();
			
			lamina.add(pelota);
			/*
			for (int i=1; i<=3000; i++){ 	// la pelota va a tener 3000 movimientos
				
				pelota.muevePelota(lamina.getBounds()); 	// recibe dimensiones de lamina
				
				lamina.paint(lamina.getGraphics());
				
				// hacer una pausa de 10 milisegundos por cada vuelta del for
				try {	
					//cuando ejecuto (siendo monotarea, un solo hilo), queda a la espera de la siguiente ejecucion, ya sea para dale! o salir. incluso para cerrar.
					Thread.sleep(2); 	// metodo para pausar! metodo de la clase Thread , static
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					
				}
				
				
				
			}*/
			
			// ejecutar hilo: 
			Runnable r = new PelotaHilos(pelota, lamina); 		// PelotaHilos implementamos Runnable
			
			// instancia de Thread
			/*
			t = new Thread(r); 	// recibe por parametro la instancia de Runnable, que implementaba la interfaz con el metodo abstracto run()
			
			t.start();		// metodo de ejcucion
			*/
			
			if (e.getSource().equals(btn1)) { 
				
				t1 = new Thread(r);
				t1.start();
				
			}else if (e.getSource().equals(btn2)) {
				
				t2 = new Thread(r);
				t2.start();
				
			}else if (e.getSource().equals(btn3)) {
				
				t3 = new Thread(r);
				t3.start();
				
			}
			
			
	}
	
	// metodo para detener hilo de ejecucion.
	public void detener(ActionEvent e) {
		
		//t.stop(); metodo stop() esta obsoleto, en desuso.
		
		//t.interrupt();	// lanza una excepcion porque el metodo run incluye metodo sleep()
		// cada ves que doy click en dale se crea una instancia llamada t, por lo tanto solo funciona con
		// la ultima pelota, cada ves que le doy al boton parar
		
		if (e.getSource().equals(btnStop1)) {
			
			t1.interrupt();
			
		}else if (e.getSource().equals(btnStop2)) {
			
			t2.interrupt();
			
		}else if (e.getSource().equals(btnStop3)) {
			
			t3.interrupt();
			
		}
		
	}
	
	
	private LaminaPelota lamina;
	
	private Thread t1, t2, t3; 		// necesario declarar en la clase, para que sea accesible para los dos metodos que la usan.
	
	JButton btn1, btn2, btn3, btnStop1, btnStop2, btnStop3;
	
}

