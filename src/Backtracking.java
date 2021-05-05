
// BACKTRACKING CON REPETICIÓN

public class Backtracking {

	static int[] valoresPosibles = { 2, 4, 6, 8 };
	static int posiciones = 8;

	public static void main(String[] args) {

		int[] principal = new int[posiciones];
		for (int i = 0; i < principal.length; i++) {
			principal[i] = valoresPosibles[0];
		}

		backtracking(principal, 0);

	}

	public static void backtracking(int[] principal, int tirada) {
		if (tirada == principal.length - 1) {
			imprimir(principal, true);
		} else {
			for (int i = 0; i < valoresPosibles.length; i++) {
				principal[tirada] = valoresPosibles[i];
				backtracking(principal, tirada + 1);
				imprimir(principal, false);
			}
		}
	}

	public static void imprimir(int[] principal, boolean v) {
		for (int i = 0; i < principal.length; i++) {
			System.out.print(principal[i] + " ");
		}
		System.out.println(v ? " <<<" : "");
	}

}
