package poo;

public class Furgoneta extends Coche {
	
	private int capacidadCarga;
	
	private int lugaresExtra;
	
	public Furgoneta(int lugaresExtra, int capacidadCarga) {
		
		super(); 		// LLAMAR AL CONSTRUCTOR DE LA CLASE PADRE
		
		this.lugaresExtra = lugaresExtra;
		this.capacidadCarga = capacidadCarga;
		
	}
	
	public String datosGenetalesFurgoneta() {
		return "La capacidad de carga es: " + capacidadCarga + " y los lugares extra son: " + lugaresExtra;
	}
}
