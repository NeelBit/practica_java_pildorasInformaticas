package poo;

import java.util.*;

import javax.swing.JOptionPane;

public class UsoEmpleado {

	public static void main(String[] args) {
		/*
		Empleado empleado1 = new Empleado("Paco gomez", 85000, 1990, 12, 17);
		Empleado empleado2 = new Empleado("Ana lopez", 95000, 1995, 6, 2);
		Empleado empleado3 = new Empleado("Ariel martin", 105000, 2002, 3, 15);
		
		empleado1.subeSueldo(5);
		empleado2.subeSueldo(5);
		empleado3.subeSueldo(5);
		
		System.out.println("Nombre: " + empleado1.getNombre() + " - Sueldo: " + empleado1.getSueldo() + 
				" - fecha de alta: " + empleado1.getAltaContrato());
		
		System.out.println("Nombre: " + empleado2.getNombre() + " - Sueldo: " + empleado2.getSueldo() + 
				" - fecha de alta: " + empleado2.getAltaContrato());
		
		System.out.println("Nombre: " + empleado3.getNombre() + " - Sueldo: " + empleado3.getSueldo() + 
				" - fecha de alta: " + empleado3.getAltaContrato());
		*/
		
		Jefatura jefeRRHH = new Jefatura("Juan", 55000, 2006, 9, 25);
		
		jefeRRHH.estableceIncentivo(2570);
		
		
		Empleado[] misEmpleados = new Empleado[6];
		
		misEmpleados[0] = new Empleado("paco",  85000, 1990, 12, 17);
		misEmpleados[1] = new Empleado("Ana lopez",  95000, 1995, 6, 2);
		misEmpleados[2] = new Empleado("maria martin",  105000, 2002, 3, 15);
		misEmpleados[3] = new Empleado("Antonio fernandez");
		
		misEmpleados[4] = jefeRRHH; 	// polimorfismo en accion. principio de sustitucion. podemos utilizar u objeto de la sub clase cuando el programa espere un objeto de la super clase
		misEmpleados[5] = new Jefatura("Maria", 95000, 1999, 5, 26);
		
		//  CASTING DE OBJETOS: de tipo Empleado a tipo Jefatura.
		Jefatura jefaFinanzas = (Jefatura) misEmpleados[5]; 	
		
		jefaFinanzas.estableceIncentivo(55000);
		
		
		
		
		/*
		for (int i=0; i<misEmpleados.length; i++) {
			misEmpleados[i].subeSueldo(5);
		}

		for (int j=0; j<misEmpleados.length; j++) {
			System.out.println("Nombre: " + misEmpleados[j].getNombre() + " - Sueldo: " + misEmpleados[j].getSueldo()
					+ " - Fecha de alta: " + misEmpleados[j].getAltaContrato());
		}
		*/
		
		/*
		
		// Un jefe es un empleado, por eso podemos hacer esto
		Empleado directorComercial = new Jefatura("Sandra",85000, 2012, 5, 5);
		
		// el mismo principio de sustitucion, Empleado implementa la interfaz Comparable, entonces podemos hacer un objeto Comparable
		Comparable ejemplo = new Empleado("Elisabeth", 95000, 2011, 6, 7);
		
		// Verificar si una instancia pertenece a una clase
		if (directorComercial instanceof Empleado) { 			// Jefatura hereda de Empleado, si lo probamos con Jefatura tambien en true
			System.out.println("directorComercial Es de tipo jefatura");
		}
		
		if (ejemplo instanceof Comparable) { 		// instanceof se puede usar tanto con clases como con interfaces
			System.out.println("ejemplo Implementa la interfaz comparable");
		}
		
		*/
		
		
		
		System.out.println(jefaFinanzas.tomarDesicion("Dar mas dias de vacaciones a los empleados"));
		
		System.out.println(" el jefe: " + jefaFinanzas.getNombre() + " tiene un bonus de: " + jefaFinanzas.estableceBonus(500)); 		// instancia de Jefatura que a su ves implementa la interfaz jefes
		
		
		
		System.out.println("El empleado: " + misEmpleados[3].getNombre() + " Tiene un bonus de: " + misEmpleados[3].estableceBonus(200));
		
		
		
		
		//  	FOR EACH
		for (Empleado e: misEmpleados) {
			e.subeSueldo(5);
		}
		
		
		Arrays.sort(misEmpleados); 			// ordenar de menor a mayor el array
											// SI ORDENO dentro del compareTo SOLAMENTE CON SUELDO Y NO CON getSueldo ORDENA SUELDO SIN INCENTIVO, POR ESO MARIA ESTA ARRIBA DE MARIA MARTIN!!!
		
		
		for (Empleado e: misEmpleados) { 		// polimorfismo, cuando getSueldo de objetos de la clase jefatura (da incentivo porque asi le dijimos en esa clase) a pesar de que la variable e es del tipo Empleado
			System.out.println("Nombre: " + e.getNombre() + " - Sueldo: " + e.getSueldo()
					+ " - Fecha de alta: " + e.getAltaContrato() + " con ID: " + e.getID());
		}
		
		// ENLAZADO DINAMICO ES CUANDO JAVA SABE A QUE METODO LLAMAR SI ES DEL PADRE O DEL HIJO EN TIEMPO DE EJECUCION
	}

}

class Empleado implements Comparable, Trabajadores {
	
	public Empleado(String nom, double sue, int agno, int mes, int dia) {
		nombre = nom;
		sueldo = sue;
		
		GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia); 	// el mes comienza en 0 con constructor por eso -1
		
		altaContrato = calendario.getTime();
		
		id = idSiguiente;
		
		idSiguiente++;
	}
	
	public Empleado(String nom) {
		this(nom, 30000, 2000, 01, 01); 			// this llama al otro constructor
	}
	
	public Empleado() { 		// si no tengo constructor por defecto la clase hija tira un error si no tiene constructor
		
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public double getSueldo() {
		return sueldo;
	}
	
	public Date getAltaContrato() {
		return altaContrato;
	}
	
	public int getID() {
		return id;
	}
	
	public void subeSueldo(double porcentaje) {
		double aumento = sueldo * porcentaje / 100;
		sueldo += aumento;
		
		//sueldo = sueldo + (porcentaje * sueldo / 100);
	}
	
	
	
	public int compareTo(Object miObjeto) {
		
		Empleado otroEmpleado = (Empleado)miObjeto; 	// casting de tipo Objet a tipo Empleado
		
		
		if (this.getSueldo() < otroEmpleado.getSueldo()) {
			return -1;
		}
		if (this.getSueldo() > otroEmpleado.getSueldo()) {
			return 1;
		}
		return 0; 		// por descarte
		
	}
	
		// PARA ORDENAR POR ID	
	/*
	public int compareTo(Object miObjeto) {
		
		Empleado otroEmpleado = (Empleado)miObjeto; 	// casting de tipo Objet a tipo Empleado
		
		
		if (this.id < otroEmpleado.id) {
			return -1;
		}
		if (this.id > otroEmpleado.id) {
			return 1;
		}
		return 0; 		// por descarte
		
	}
	*/
	
	
	public double estableceBonus(double gratificacion) {
		return Trabajadores.bonusBase + gratificacion;
	}
	
	
	
	
	
	private String nombre;
	private double sueldo;
	private Date altaContrato;
	private int id;
	private static int idSiguiente = 1;
	
}

class Jefatura extends Empleado implements Jefes {
	
	public Jefatura(String nom, double sue, int agno, int mes, int dia) {
		super(nom, sue, agno, mes, dia);
	}
	
	public void estableceIncentivo(double b) {
		incentivo = b;
	}
	
	public double getSueldo() { 	// sobre-escribiendo metodo
		
		double sueldoJefe = super.getSueldo(); // tiene que almacenar lo que de dé el metodo de la clase padre
		return sueldoJefe + incentivo;
		
	}

	
	public String tomarDesicion(String desicion) {
		return "Un mienmbro de la direccion ha tomado la desicion de: " + desicion;
	}
	
	
	public double estableceBonus(double gratificacion) {
		double prima = 2000; 		// prima suponiendo que como estamos en la clase Jefatura los jefes tienen un privilegio
		return Trabajadores.bonusBase + gratificacion + prima;
	}
	
	
	
	private double incentivo;

	
}

class Director extends Jefatura {
	
	public Director (String nom, double sue, int agno, int mes, int dia) {
		super(nom, sue, agno, mes, dia);
	}
	
}

// SI DECLARO UNA CLASE COMO FINAL, ESTA NO SE PUEDE HEREDAR.
// SI DECLARO UN METODO COMO FINAL, ESTE NO PUEDE SER SOBRE-ESCRITO

// SI DECLARO UNA CLASE COMO ABSTRACT, NO SE PUEDEN INSTANCIAR OBJETOS DE ESTA.	
// UN METODO ABSTRACT, SOLO SE DEFINE, EJ: public abstract String dameDescripcion();  (si declaras un metodo abstracto debes declarar a la clase como abstracta)
// TODAS LAS CLASES QUE HEREDAN DE ESTA CLASE ABSTRACTA ESTAN OBLIGADAS A SOBRE-ESCRIBIR SUS METODOS.



