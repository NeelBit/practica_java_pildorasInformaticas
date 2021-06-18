package usoThreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// banco con 100 cuentas con 2mil cada cuenta. donde las cuentas se tranfieran aleatoriamente mediante un hilo
public class BancoSinSincronizar {

	public static void main(String[] args) {
		
		// 100 hilos haciendo tranferencias aleatorias e infinitas a la ves.
		// creo los 100 hilos y cada uno tranfiere aleatoriamente fondos aleatorios infinitamente.
		
		Banco b = new Banco();
		
		for (int i=0; i<100; i++) { 	// for para que realice transferencias de la cuenta 0 a 99
													// la cuenta de origen es i, todas las cuentas (100) van a mandar aleatoriamente a otras aleatorias.
			
			System.out.println("----------hilo creadoooooooooooooooooooooooooooooooooooooooooo!!" + i);
			
			EjecucionTransferencias r = new EjecucionTransferencias(b,i, 2000);
			
									// pasamos por parametro una instancia de clase que haya implementado Runnable
			Thread hilo = new Thread(r);
			
			hilo.start();
			
		}
		
	}

}

class Banco {
	
	public Banco() {
		
		cuentas = new double[100]; 	// inicializo array con 100 cuentas
		
		for (int i=0; i<cuentas.length; i++) { 	// cargamos con 2mil cada cuenta
			
			cuentas[i] = 2000;
			
		}
		
		// declaramos condicional de bloqueo al lock que declaramos anteriormente. Establecemos que trabarHilo se tiene que establecer en base a una condicion.
		//saldoSuficiente = trabarHilo.newCondition(); // ponemos en el constructor porque cada ves que creamos un banco lleva un bloqueo con una condicion
		
	}
	
	// para utilizar Synchronized: la palabra reservada en el metodo, es innecesario Condition, comento también trabarHilo (Lock) . utilizamos wait(); en ves de objeto y await, y usamos notifyall en ves de signalAll 
	
	// en la llamada del metodo hicimos que lanze la excepcion de await, entonces cuando usamos el metodo debemos capturarlo
	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {	// metodo para tranferir dinero
		
		// bloqueamos metodo para que lo ejecute un hilo a la ves: soluciona el problema de que dos hilos puedan restar a la ves la cantidad.
		//trabarHilo.lock(); 	// todo hilo que entre bloquea el codigo, osea no permite que otro hilo ingrese.
		//try { 	// comento para probar synchronized
			// le decimos que mientras la condicion del while sea verdad, el hilo permanezca a la espera.
			while (cuentas[cuentaOrigen] < cantidad) { 	// si no tiene fondos suficientes, debe bloquear ese hilo hasta que los tenga y seguir con la transaccion
				
				//saldoSuficiente.await(); 	// metodo para suspender en si se cumple la condicion del while
				
				// usando synchonized:
				wait();
				
			}
		
			
			/* COMENTO LO DE ABAJO Y UTILIZO WHILE PARA BLOQUEO CONDICIONAL
		if (cuentas[cuentaOrigen] < cantidad) {	// comprobamos que tenga fondos
			
			System.out.println("La cuenta: " + cuentaOrigen + " tiene " + cuentas[cuentaOrigen] + " fondos insuficientes!" + " y pretende mandar: " + cantidad);
			
			return; 	// no hace nada, osea, retorna el flujo de ejecucion, ni siquiera imprime lo de abajo en nuestro metodo.
			
		}else {
			
			System.out.println("Transferencia exitosa!!!" + "Hilo: " + Thread.currentThread().getName());
			
		}*/
		
		System.out.println(Thread.currentThread().getName());	// imprime informacion del hilo que va a realizar la transaccion
		
		
		cuentas[cuentaOrigen] -= cantidad; 		// restamos la cantidad que tranfiere
		
		// toma cantidad con dos decimales, "de" segundo parametro "para" tercer parametro.
		System.out.printf("%10.2f de %d para %d \n", cantidad, cuentaOrigen, cuentaDestino);	// imprimir en consola con cierto formato
		
		// aqui es cuando por ejemplo si no sincronizamos los hilos uno puede llegar a restar,
		// y ambos pueden llegar a restar, y uno antes que el otro imprimir el saldo total,
		// danto como resultado que el total del banco no este figurando.
		// en sintesis: problema de la programacion concurrente de varios hilos a la ves, que no debería pasar.
		
		cuentas[cuentaDestino] += cantidad; 	// sumamos la cantidad tranferida a la cuentaDestino 
		
		System.out.printf("El saldo total del banco es: %10.2f ", getSaldoTotal());
			
			
			// despertar a los hilos que estan a la espera: y que chequen la condicion para poder continuar, utilizando lock
			//saldoSuficiente.signalAll();
			
		// usando Synchronized:
		notifyAll();
		
		//}/*finally { 	// lo comento try y finally para probar Synchronized
			
			//trabarHilo.unlock(); // liberar/destrabar para que ingrese siguiente hilo.
			
			// son los objetos de tipo Banco los que establecen en bloqueo,
			
		//}
		
	}
	
	public double getSaldoTotal() {
		
		double sumaCuentas = 0;
		
		for (double saldo: cuentas) {
			
			sumaCuentas += saldo;
			
		}
		
		return sumaCuentas;
	}
	
	
	
	private final double[] cuentas; 	// array constante de clase.
	
	// reentrantLock para poder blockear hilos y utilizar uno a la ves, necesito instanciar, para poder usar en el metodo transferencia
	//private Lock trabarHilo = new ReentrantLock(); 	comento para probar Synchronized
	
	// campo tipo Condition para añadir condicion al bloqueo:
	//private Condition saldoSuficiente; comento para probar Synchronized
	
}

class EjecucionTransferencias implements Runnable {

	//constructor:
	public EjecucionTransferencias(Banco b, int cuentaOrigen, double max) {
		
		banco = b;
		this.cuentaOrigen = cuentaOrigen;
		cantidadMax = max;
		
	}
	
	
	
	@Override
	public void run() {
		
		try { // metodo sleep lanza excepcion
			
			while (true) { // bucle infinito para que haga transferencias todo el tiempo
			
				int paraLaCuentaDestinoAleatoria = (int)(Math.random() * 100);
			
				double cantidad = cantidadMax * Math.random(); 	// aleatorio hasta 2000.
				
				
				banco.transferencia(cuentaOrigen, paraLaCuentaDestinoAleatoria, cantidad);
				
				
				// dormir hilos para que sea lento y logre verse:
				//Thread.sleep( (int)(Math.random() * 50)); 	// que se aleatorio hasta 50 milisegundos
				
				Thread.sleep(4000);
				
			}
		
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		} 
		
		
	}
	
	
	private Banco banco;
	private int cuentaOrigen;
	private double cantidadMax;
	
}









