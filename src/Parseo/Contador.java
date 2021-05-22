package Parseo;

public class Contador {

	public static void main(String[] args) {
	}

	public static int countChar(String string, char c) {
		return string.length() - string.replace(c + "", "").length();
	}

	public static int countSubstrings(String string, String substring) {
		return (string.length() - string.replaceAll(substring, "").length()) / substring.length();
	}

	public static int countSubstrings2(String string, String substring) {
		return string.replaceAll(substring, "*").length()
				- (string.replaceAll(substring, "*")).replaceAll("*", "").length();
	}

}
