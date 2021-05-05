
public class DNI {

	public static void main(String[] args) {
		System.out.println(esValido(12345678, 'Z')); // true
		System.out.println(esValido(12345678, 'A')); // false
	}

	public static boolean esValido(int num, char letra) {
		return calcularLetra(num) == letra;
	}

	public static char calcularLetra(int num) {
		char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };
		return letras[num % 23];
	}

}
