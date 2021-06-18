import java.util.*;

public class CuentasUsuarios {
	
	// ArrayList: poco eficiente para quitar un elemento, ventaja es que no tiene limite de tamaño en la definicion (a diferencia de los array normal)
	
	// LinkedList: eficiente para quitar elementos .Es muy eficiente si vas a estar agregando o quitando elementos todo el tiempo. son ordenada de acuerdo al orden añadido, eficiente lectura poca eficiencia escritura
	
	// TreeSet: no permite duplicados (al implementar Set), NO permite el acceso aleatorio y Si permite ordenar (a diferencia de HashSet)
	
	// HashSet: no permite duplicados, rápido, no acceso aleatorio, es sencillo agregar elementos, NO permite ordenamiento
	// LinkedHashSet: ordenacion por entrada, eficiente al acceder, NO eficiente al agregar.
	// TreeSet: es ordenado, poco eficiente.
	
	
	public static void main(String[] args) {
		
		Clientes cl1 = new Clientes("Pedro", "00001", 20000);
		Clientes cl2 = new Clientes("Juan", "00002", 22000);
		Clientes cl3 = new Clientes("Fulano", "00003", 23000);
		Clientes cl4 = new Clientes("Mengano", "00004", 24000);
		Clientes cl5 = new Clientes("Meno", "00004", 25000);
		
		System.out.println("cl4 y cl5 son iguales? : " + cl4.equals(cl5));
		System.out.println("hashCode cl4: " + cl4.hashCode());
		System.out.println("hashCode cl5: " + cl5.hashCode());
		
		System.out.println("");
		
		Set<Clientes> clientesBanco = new HashSet<Clientes>();
		
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		clientesBanco.add(cl5); 	// no lo agrega
		
		
		// RECORRIENDO COLECCION CON FOR EACH (es mas sencillo para ver contenido!)
		
		// lo malo es que no podemos eliminar o modificar una coleccion mientras recorremos!
		
		/*
		for (Clientes cl: clientesBanco) {
			
			System.out.println("Nombre: " + cl.getNombre()  + "- Numero de cuenta: " + cl.getNumCuenta() + "- Saldo: " + cl.getSaldo());
			
		}
		*/
		
		// RECORRIENDO COLECCION CON ITERATOR
		Iterator<Clientes> itClientes = clientesBanco.iterator();
		
		/*while (itClientes.hasNext()) {
			
			String nombreCliente = itClientes.next().getNombre();
			
				// 	CADA VES QUE PRESIONAMOS NEXT() EVALUA EL SIGUIENTE. ENTONCES DA ERROR!
			//sólo debemos utilizar una ves, a veces practico, otras veces es mejor for each!.
			
			//String numCuenta = itClientes.next().getNumCuenta();
			//double saldo = itClientes.next().getSaldo();
			//System.out.println("Nombre: " + nombreCliente + " .Numero de cuenta: " + numCuenta + " .Saldo: " + saldo);
			
			System.out.println("Nombre: " + nombreCliente);
		}*/
		
		// PARA ELIMINAR UN ELEMENTO PODEMOS HACER!: (es mas sencillo utilizar iterador!)
		while (itClientes.hasNext()) {
			
			// borrar al cliente de cierto nombre: Mengano
			String nombreCl = itClientes.next().getNombre();
			
			if(nombreCl.equalsIgnoreCase("Mengano")) {
				
				itClientes.remove(); 		// remover el objeto que esta analizando
				System.out.println("eliminado Mengano");
			}
			
		}
		
		System.out.println("");
		
		// recorremos nuevamente para ver si elimino a mengano:
		for (Clientes cl: clientesBanco) {
			
			System.out.println("Nombre: " + cl.getNombre()  + "- Numero de cuenta: " + cl.getNumCuenta() + "- Saldo: " + cl.getSaldo());
			
		}
		
		
		
		
	}

}
