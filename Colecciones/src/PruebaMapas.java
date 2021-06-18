
import java.util.*;

public class PruebaMapas {

	public static void main(String[] args) {
		
		HashMap<String, Empleado> personal = new HashMap<String, Empleado>();
		
		personal.put("145", new Empleado("fulanito"));
		personal.put("150", new Empleado("Cosme"));
		personal.put("155", new Empleado("roxana"));
		personal.put("160", new Empleado("maria"));
		
		System.out.println(personal);
		
		System.out.println();
		
		personal.remove("155"); // eliminamos roxana por ej
		
		// reemplazar un elemento, solo basta con cambiar la clave:
		personal.put("160", new Empleado("Mariaaaaaa2"));
		
		System.out.println(personal);
		
		
		// pasamos los elementos a un treemap para que ordene:
		TreeMap<String, Empleado> ordenadoPersonal = new TreeMap<>(personal);
		
		System.out.println();
		
		System.out.println(ordenadoPersonal);
		
		
		System.out.println();
		// entrySet, interfaz interna . devuelve en formato set
		System.out.println(personal.entrySet());
		
		// recorrer mapa con entrySet y bucle for each
		for (Map.Entry<String, Empleado> p: personal.entrySet()) {
			
			String clave = p.getKey();
			
			Empleado valor = p.getValue();
			
			System.out.println("la clave es: " + clave + " y la persona es: " + valor.toString());
			
		}
		
	}

}

class Empleado {
	
	public Empleado(String n) {
		
		nombre = n;
		sueldo = 2000;
		
	}
	
	public String toString() {
		
		return "[Nombre = " + nombre + ", Sueldo = " + sueldo + "]";
		
	}
	
	private String nombre;
	private double sueldo;
	
}



