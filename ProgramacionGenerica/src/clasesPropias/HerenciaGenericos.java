package clasesPropias;

public class HerenciaGenericos {

	public static void main(String[] args) {
		
		/* 	RECORDANDO HERENCIA:
		Empleado emp1 = new Empleado("Fulano", 25, 30000);
		
		Empleado emp2 = new Jefe("Jefesito", 40, 5000);
		
		Jefe empJefe = new Jefe("empJefe", 30, 4000); // solo a empJefe se puede aplicar el metodo de jefe, incentivo()
		
		Empleado empleJefe = empJefe; 	// un jefe es un empleado.
		*/
		
		Pareja <Empleado> emp1 = new Pareja<Empleado>(); 
		
		Pareja <Jefe> jefesito = new Pareja<Jefe>();
		
		// intentamos sustituir: jefe ES UN empleado
		// Pareja <Empleado> empleadoJefe = jefesito; 	// no permite
		
		Pareja.imprimirTrabajador(emp1);
		Pareja.imprimirTrabajador(jefesito); // error por el manejo de la herencia en clases genericas. por eso debemos
											// usar <? extends Empleado> en el metodo, para que pueda
											// admitir tipos de objetos de clases hijas.
		
		
		
		
		
	}

}
