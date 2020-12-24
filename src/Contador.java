
public class Contador {

	public static int countString(String string, String substring) {

		return string.length() - string.replace(substring, "").length();

	}

}
