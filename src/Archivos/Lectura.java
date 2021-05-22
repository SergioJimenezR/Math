package Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lectura {

	public static String read(String ruta) throws FileNotFoundException {
		String result = "";
		File f = new File(ruta);
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine())
			result += sc.nextLine() + "\n";
		sc.close();
		return result;
	}

}
