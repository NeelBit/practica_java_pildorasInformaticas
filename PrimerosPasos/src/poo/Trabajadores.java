package poo;

public interface Trabajadores {

	double estableceBonus(double gratificacion); 	// recibe un double gratificacion y devuelve un double
													// public abstract no obligatorio
	double bonusBase = 1500;
								// las constantes en las interfaces son todas public static final . da igual ponerlos o no.
}
