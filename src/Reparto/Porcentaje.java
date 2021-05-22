package Reparto;

public class Porcentaje {

	public static void main(String[] args) {
		double notaReal = 8.5;
		double[] porcentajes = { 33.333, 33.333, 33.333 };

		double[] reparto = reparto(notaReal, porcentajes);
		for (int i = 0; i < reparto.length; i++)
			System.out.println(reparto[i]);
	}

	public static double[] reparto(double notaReal, double[] porcentajes) {
		double[] result = new double[porcentajes.length];
		for (int i = 0; i < result.length; i++)
			result[i] = Parseo.Números.truncate(notaReal * porcentajes.length * porcentajes[i] / 100, 2);
		return result;
	}

}
