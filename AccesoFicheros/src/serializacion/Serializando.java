package serializacion;

import java.util.*;
import java.io.*;

public class Serializando {
	
	// SERIALIZAR: PASAR A BYTE(para pasar a dispositivo por ejemplo) y pasar de byte a objeto nuevamente.

	public static void main(String[] args) {
		
		Administrador jefe = new Administrador("Juan", 80000, 2005, 12, 15);
		
		jefe.setIncentivo(5000);
		
		// array de objetos de tipo Empleado, la clase empleado debe ser serializable para pasar a bytes
		Empleado[] personal = new Empleado[3];
		
		personal[0] = jefe;
		
		personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
		personal[2] = new Empleado("Luis", 18000, 2012, 9, 15);
		
		// una ves que serializamos la clase Empleado (implements Serializable)
		// ahora podemos usar ObjectOutputStream, para volcar el objeto a bytes en un archivo.
		try {
			/*
			ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("D:/Desktop/empleado.dat"));
			
			escribiendoFichero.writeObject(personal);
			
			escribiendoFichero.close();
			*/
			// LEER EL FICHERO QUE ACABAMOS DE ESCRIBIR:
			ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream("D:/Desktop/empleado.dat"));
			
			// debo almacenar el array en un array: 	// hago casting de array de object a array de tipo empleado
			Empleado[] personalRecuperado =(Empleado[])leyendoFichero.readObject();
			
			leyendoFichero.close();
			
			for (Empleado pRecuperado : personalRecuperado) {
				
				System.out.println(pRecuperado);
				
			}
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Error: " + e.getMessage());
			
		} catch (IOException e) {
		
		System.out.println("Error: " + e.getMessage());
		
		}
		
	}

}

class Empleado implements Serializable {
	
	/**
	 * default serial version
	 */
	private static final long serialVersionUID = 1L;
	
	public Empleado(String ene, double s, int anio, int mes, int dia) {
		
		nombre = ene;
		sueldo = s;
		
		GregorianCalendar calendario = new GregorianCalendar(anio, mes, dia);
		
		fechaContrato = calendario.getTime();
		
	}
	
	// GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getSueldos() {
		return sueldo;
	}
	
	public void setSueldos(Double sueldo) {
		this.sueldo = sueldo;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getDia() {
		return dia;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public Date getFechaContrato() {
		return fechaContrato;
	}
	
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	
	// metodo subir sueldo:
	public void subirSueldo(double porcentaje) {
		
		double aumento = (sueldo*porcentaje)/100;
		
		sueldo += aumento;
		
	}
	
	// metodo toString: es como pasar a texto lo que hace nuestra clase
	public String toString() {
		
		return "Nombreeeee: " + nombre + ", Sueldo: " + sueldo + ", Fecha de contrato: " + fechaContrato;
		
	}
	
	
	private String nombre;
	private double sueldo;
	private int anio, mes, dia;
	private Date fechaContrato;
	
}

class Administrador extends Empleado {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrador(String n, double s, int anio, int mes, int dia) {
		
		super(n, s, anio, mes, dia);
		
		incentivo = 0;
		
	}
	
	public double getSueldo() {
		
		double sueldoBase = super.getSueldos();
		
		return sueldoBase+incentivo;
		
	}
	
	public void setIncentivo(double b) {
		
		incentivo = b;
		
	}
	
	// metodo toString:
	public String toString() {
		
		return super.toString() + ", Incentivo: " + incentivo;
		
	}
	
	private double incentivo;
	
}





