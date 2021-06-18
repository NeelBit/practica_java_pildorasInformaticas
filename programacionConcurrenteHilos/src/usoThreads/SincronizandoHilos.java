package usoThreads;

public class SincronizandoHilos {
	// sincronizar decirle que no comience un hilo hasta que finalice el otro.
	
	public static void main(String[] args) {
		
		//System.out.println("iniciando");
		/*
		HilosVarios hilo1 = new HilosVarios();
		hilo1.start(); 	// llamamos directamente a start() ya que la clase hereda directamente de Thread
		
		
		try {
			
			hilo1.join();	// espera que muera el hilo, antes de ejecutar el siguiente.
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		} 
		
		HilosVarios hilo2 = new HilosVarios();
		hilo2.start();
		
		try { 	// si no hacemos join al hilo2 imprime lo del main antes de arrancar hilo2.
			
			hilo2.join(); 	// hasta que no termina hilo2 no continua con el hilo principal del main.
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
		*/
		/*
		HilosVarios hilo3 = new HilosVarios();
		hilo3.start();
		*/
		
		// usando la clase HilosVarios2:
		
		HilosVarios hiloUno = new HilosVarios();
		
		
		HilosVarios2 hiloDos = new HilosVarios2(hiloUno); 	// no se ejecutara hasta que termine hiloUno
		
		hiloDos.start();
		hiloUno.start();
		
		
		System.out.println("terminado ejecucion"); 	// imprime antes de arrancar hilo 2
		
	}

}

class HilosVarios extends Thread { 	// otra forma de crear hilo, osea, sin implementar Runnable
	
	public void run() { 	// aca ponemos la tarea el hilo que vamos a realizar.
		
		for (int i=0; i<15; i++) {
			
			System.out.println("Ejecutando hilo " + getName()); 	// getName() string con el nombre del hilo que se esta ejecutando
			// cuando no sincronizamos los hilos, se van intercalando entre si
			
			try {
				
				Thread.sleep(700);	// duerme temporalmente el milisegundos el hilo.
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
}

class HilosVarios2 extends Thread {
	
	public HilosVarios2(Thread nombreHilo) { 	// recibe un hilo por parametro
		
		hilo=nombreHilo;
		
	}
	
	public void run() {
		
		// decirle que no comience hasta que el hilo que le hayamos pasado al
		// constructor no termine su tarea:
		try {
			
			hilo.join();	// hacemos join al hilo que recibimos por parametro en el constructor
			
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
			
		}
		
		for (int i=0; i<10; i++) {
			
			System.out.println("Ejecutando Hilo: " + getName());
			
			try {
				
				Thread.sleep(400);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	private Thread hilo;
	
}





