package Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Escritura {

	public static void read(String ruta, String contenido) throws FileNotFoundException {
		File f = new File(ruta);
		PrintWriter pw = new PrintWriter(f);
		pw.print(contenido);
		pw.close();
	}

}
