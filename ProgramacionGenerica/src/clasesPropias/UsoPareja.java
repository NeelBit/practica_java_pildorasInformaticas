package clasesPropias;

public class UsoPareja {

	public static void main(String[] args) {
		
		Pareja<String> una = new Pareja<String>();
		
		una.setPrimero("Juan"); 	// automaticamente reconoce que debe aceptar parametro del tipo string como indicamos arriba.
		// indica que primero=Juan
		
		System.out.println(una.getPrimero()); 	// imprime Juan
		
		// creamos una instancia de la clase Persona (abajo)
		Persona ana = new Persona("Ana");
		
		Pareja<Persona> dos = new Pareja<Persona>();
		
		dos.setPrimero(ana);
		
		System.out.println(dos.getPrimero().getNombre()); 	// imprime Ana
		
		
		
	}

}

class Persona {
	
	public Persona(String nombre) {
		
		this.nombre = nombre;
		
	}
	
	public String getNombre() { 		// propio para que pueda imprimir nombre
		
		return nombre;
		
	}
	
	private String nombre;
	
}
