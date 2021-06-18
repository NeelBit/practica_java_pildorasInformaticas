package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoPersona {

	public static void main(String[] args) {
		
		Persona[] lasPersonas = new Persona[2];
		
		lasPersonas[0] = new Empleado2("Luis Conde", 50000, 2009, 2, 25);
		lasPersonas[1] = new Alumno("Ana lopez", "Biologia");
		
		for (Persona e: lasPersonas) {
			System.out.println(e.dameNombre() + ": " + e.dameDescripcion());
			
		}
		
	}

}


abstract class Persona {
	
	private String nombre;
	
	public Persona(String nom) {
		nombre = nom;
	}
	
	public String dameNombre() {
		return nombre;
	}
	
	public abstract String dameDescripcion();
	
	
}


class Empleado2 extends Persona {
	
	public Empleado2(String nom, double sue, int agno, int mes, int dia) {

		super(nom);
		
		sueldo = sue;
		
		GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia); 	// el mes comienza en 0 con constructor por eso -1
		
		altaContrato = calendario.getTime();
		
		id = idSiguiente;
		
		idSiguiente++;
	}
	
	public String dameDescripcion() {
		return "Este empleado tiene un ID: " + id + " Con un sueldo de: " + sueldo;
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
	
	private double sueldo;
	private Date altaContrato;
	private int id;
	private static int idSiguiente = 1;
	
}

class Alumno extends Persona {
	
	public Alumno(String nom, String car) {
		super(nom);
		carrera = car;
	}
	
	public String dameDescripcion() {
		
		return "Este alumno esta estudiando la carrera " + carrera;
		
	}
	
	private String carrera;
	
}

