package Parseo;

public class N�meros {

	public static double truncate(double numReal, int nDecimales) {
		return Math.round(numReal * Math.pow(10, nDecimales)) / Math.pow(10, nDecimales);
	}

}
