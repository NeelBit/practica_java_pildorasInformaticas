package poo;

// import javax.swing.*;

public class UsoVehiculo {

	public static void main(String[] args) {
		/*
		Coche miCoche = new Coche();
		
		miCoche.setColor(JOptionPane.showInputDialog("Introduce color: "));
		
		System.out.println(miCoche.getColor());
		
		System.out.println(miCoche.datosGenerales());
		
		miCoche.setAsientosCuero(JOptionPane.showInputDialog("Tiene asientos de cuero? si o no"));
		
		System.out.println(miCoche.getAsientosCuero());
		
		miCoche.setClimatizador(JOptionPane.showInputDialog("Tiene climatizador? si o no"));
		
		System.out.println(miCoche.getClimatizador());
		
		System.out.println(miCoche.dimePesoCoche());
		
		System.out.println("El precio del coche es de: " + miCoche.precioCoche());
		*/
		
		Coche miCoche1 = new Coche();
		miCoche1.setColor("Rojo");
		
		Furgoneta miFurgoneta1 = new Furgoneta(7, 500);
		miFurgoneta1.setColor("Azul");
		miFurgoneta1.setAsientosCuero("si");
		miFurgoneta1.setClimatizador("si");
		
		System.out.println(miCoche1.datosGenerales() + " " + miCoche1.getColor());
		
		System.out.println(miFurgoneta1.datosGenerales() + " " + miFurgoneta1.datosGenetalesFurgoneta());
		
		
		
	}

}
