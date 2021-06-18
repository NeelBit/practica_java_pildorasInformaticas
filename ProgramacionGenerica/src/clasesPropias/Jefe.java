package clasesPropias;

public class Jefe extends Empleado {

	public Jefe(String nombre, int edad, int salario) {
		
		super(nombre, edad, salario);
		
	}
	
	public double incentivo (double inc) {
		
		return inc;
		
	}
	
}
