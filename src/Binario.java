
public class Binario {

	public static String fromDecimalToBinary(int decimal) {
		String bin = "";

		for (; decimal >= 2; decimal /= 2)
			bin = decimal % 2 + bin;

		return decimal + bin;
	}

	public static int fromBinaryToDecimal(String bin) {
		int decimal = 0;

		for (int i = 0; i < bin.length(); i++)
			if (bin.charAt(bin.length() - 1 - i) == '1')
				decimal += Math.pow(2, i);

		return decimal;
	}

	public static int fromStringBinaryToDecimal(String S, char equals1, char equals0) {
		String R = "";

		for (int i = 0; i < S.length(); i++)
			if (S.charAt(i) == equals1)
				R += "1";
			else
				R += "0";

		return fromBinaryToDecimal(R);
	}

}
