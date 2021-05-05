
public class PermutacionesConRepeticionYRestriccion {

	public static void main(String[] args) {

		int valorMinimoDado = 1;
		int valorMaximoDado = 6;
		int numeroDados = 3;
		int valorASuperar = 15;

		int[] dados = new int[numeroDados];
		for (int i = 0; i < dados.length; i++) {
			dados[i] = valorMinimoDado;
		}

		/*int[] valores = new int[valorMaximoDado - valorMinimoDado + 1];
		for (int i = 0, j = valorMinimoDado; i < valores.length; i++, j++) {
			valores[i] = j;
		}*/
		int[] valores = {3, 6, 9};

		tiradas(dados, 0, 0, valorASuperar, valorMaximoDado, valores);

	}

	public static void tiradas(int[] dados, int suma, int tirada, int valorASuperar, int valorMaximoDado,
			int[] valores) {

		if (tirada == dados.length && suma >= valorASuperar) {

			for (int i = 0; i < dados.length; i++) {
				if (i == dados.length - 1) {
					System.out.print(dados[i] + " = ");
				} else {
					System.out.print(dados[i] + " + ");
				}
			}
			System.out.println(suma);

		} else if (tirada != dados.length) {

			for (int i = 0; i < valores.length; i++) {
				dados[tirada] = valores[i];
				suma += valores[i];
				imprimirEstado(dados);
				tiradas(dados, suma, tirada + 1, valorASuperar, valorMaximoDado, valores);
				suma -= valores[i];
			}

		}

	}

	public static void imprimirEstado(int[] dados) {
		for (int i = 0; i < dados.length; i++) {
			System.out.print(dados[i] + " ");
		}
		System.out.println();
	}

}
