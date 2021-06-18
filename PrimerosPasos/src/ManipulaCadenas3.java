
public class ManipulaCadenas3 {

	public static void main(String[] args) {
		
		String alumno1, alumno2;
		
		alumno1 = "david";
		alumno2 = "David";
		
		System.out.println("comprobar si son iguales dos cadenas de caracteres: " + alumno1 + " y " + alumno2 + " " + alumno1.equals(alumno2));
		
		System.out.println("comprobar si son iguales dos String sin importar mayusculas o minusculas: " + alumno1 + " y " + alumno2 + " " + alumno1.equalsIgnoreCase(alumno2));

	}

}
