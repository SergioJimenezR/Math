package Función;

import java.util.function.Function;

public class Lambda {

	public static void main(String[] args) {

		// Ejemplo
		Function<Double, Double> funcion = x -> Math.pow(x, 2) + x;
		System.out.println(funcion.apply((double) 5));

	}

}
