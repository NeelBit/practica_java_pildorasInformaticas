package poo;

public class Coche {

	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int pesoPlataforma;
	
	private String color;
	private int pesoTotal;
	private boolean asientosCuero, climatizador;
	
	
	public Coche() { 		// metodo constructor
		
		ruedas = 4;
		largo = 2000; 		// en CMtrs
		ancho = 300;
		motor = 1600;
		pesoPlataforma = 500;
		
	}
	
	public String datosGenerales() {
		
		return "La plataforma del coche tiene " + ruedas + " ruedas" + ". Mide " + largo + "Cms de largo"
				+ " con un ancho de " + ancho + "Cms. Un peso de plataforma de " + pesoPlataforma + "Kg";
		
	}
	
	public void setColor(String colorCoche) {
		
		color = colorCoche;
		
	}
	
	public String getColor() {
		
		return "El color del coche es: " + color;
		
	}
	
	public void setAsientosCuero(String asientosCuero) {
		
		if (asientosCuero.equalsIgnoreCase("si")) { 	// Si el parametro es "si", cambia a la variable de clase this.asientosCuero por true
			this.asientosCuero = true;
		}
		else {
			this.asientosCuero = false;
		}
	}
	
	public String getAsientosCuero() {
		
		if (asientosCuero == true) { 					// al ser booleano no es necesario el == true
			
			return "El coche tiene asientos de cuero";
		}
		else {
			return "El coche NO tiene asientos de cuero";
		}
	}
	
	public void setClimatizador(String climatizador) {
		if (climatizador.equalsIgnoreCase("si")) {
			this.climatizador = true;
		}
		else {
			this.climatizador = false;
		}
	}
	
	public String getClimatizador() {
		if (climatizador == true) {
			return "El coche tiene climatizador";
		}
		else {
			return "El coche NO tiene climatizador";
		}
	}
	
	public String dimePesoCoche() {
		int pesoCarroceria = 500;
		pesoTotal = pesoPlataforma + pesoCarroceria;
		
		if (asientosCuero == true) {
			pesoTotal += 50;
		}
		if (climatizador == true) {
			pesoTotal += 20;
		}
		
		return "El peso del coche es: " + pesoTotal + "Kg";
	}
	
	public int precioCoche() {
		int precioFinal = 10000;
		
		if (asientosCuero == true) {
			precioFinal += 2000;
		}
		
		if (climatizador == true) {
			precioFinal += 1500;
		}
		
		return precioFinal;
	}
	
	
}
