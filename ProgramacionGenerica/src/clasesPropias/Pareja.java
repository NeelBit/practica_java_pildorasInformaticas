package clasesPropias;

			// nombre de clase<indica que es generica>
public class Pareja<T> {		// definicion de clase generica	
	
	public Pareja() {
		
		// cuando intanciamos pone como null a primero, luesgo con set establecemos otro valor.
		primero = null;
		
	}
	
	// metodo para que nos imprima un empleado: 	// ? extends para que pueda ocuparse tipos de intancias de clases hijas
	public static void imprimirTrabajador(Pareja <? extends Empleado> p) {
		
		Empleado primero = p.getPrimero();
		System.out.println(primero);
		
	}
	
	
	
	// metodo set para cambiar el valor
	public void setPrimero(T nuevoValor) {
		
		primero = nuevoValor;
		
	}
	
	// metodo devolver valor de primero:
	public T getPrimero() {
		
		return primero;
		
	}
	
	
	private T primero;
	
}
