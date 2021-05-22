package Conjuntos;
import java.util.ArrayList;

/**
 * Programa que enumera todos los subconjuntos de un conjunto.
 * 
 * @author Sergio Jiménez Roncero
 *
 */

public class Subconjuntos {

	public static void main(String[] args) {
		imprimirSubconjuntos(obtenerSubconjuntos(prepararConjunto(10)));
	}

	public static ArrayList<String> prepararConjunto(int N) {
		ArrayList<String> C = new ArrayList<String>();
		for (int i = 1; i <= N; i++)
			C.add(i + "");
		return C;
	}

	public static ArrayList<ArrayList<String>> obtenerSubconjuntos(ArrayList<String> C) {

		ArrayList<ArrayList<String>> L = new ArrayList<ArrayList<String>>();

		int count = (int) Math.pow(2, C.size());
		for (int i = 0; i < count; i++) {
			ArrayList<String> S = new ArrayList<String>();
			for (int j = 0; j < C.size(); j++)
				if ((i & (int) Math.pow(2, j)) > 0)
					S.add(C.get(j));
			L.add(S);
		}

		return L;
	}

	public static void imprimirSubconjuntos(ArrayList<ArrayList<String>> L) {
		for (int i = 0; i < L.size(); i++) {
			ArrayList<String> S = L.get(i);
			for (int j = 0; j < S.size(); j++)
				System.out.print(S.get(j) + " ");
			System.out.println();
		}
	}

}