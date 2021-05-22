package Especiales;

import java.lang.reflect.Field;

/**
 * 
 * @author Sergio Jiménez Roncero
 *
 */

@SuppressWarnings("deprecation") // Field.isAccesible()

public class Fields {

	public static void main(String[] args) {
		Persona p = new Persona("Sergio", 22, new Casa("Madrid", 12500, new Ciudad(28000)));
		System.out.println(p.toString());
	}

	public static String toString(Object obj, boolean fullInformation) {
		String result = "[-Clase: " + obj.getClass().getName() + "-";
		Field[] atributos = obj.getClass().getDeclaredFields();

		for (int i = 0; i < atributos.length; i++) {

			boolean accesible = atributos[i].isAccessible();
			atributos[i].setAccessible(true);

			try {
				if (atributos[i].getType().isPrimitive()
						|| atributos[i].get(obj).getClass().getName().equals("java.lang.String"))
					// Información de variables primitivas y Strings.
					result += ", " + atributos[i].get(obj).getClass().getSimpleName() + " " + atributos[i].getName()
							+ ": " + atributos[i].get(obj);
				else if (!fullInformation)
					// Solo información de nombres de clases asociadas.
					result += ", [" + atributos[i].get(obj).getClass().getSimpleName() + " " + atributos[i].getName()
							+ "]";
				else if (fullInformation)
					// Obtención recursiva de la información completa de las clases asociadas.
					result += ", " + atributos[i].get(obj).toString() /* toString(atributos[i].get(obj), true) */;
			} catch (IllegalArgumentException | IllegalAccessException exc) {
				// Catch preventivo. Nunca debería producirse, gracias al setAccessible(true).
				exc.printStackTrace();
			}

			atributos[i].setAccessible(accesible);

		}
		result += "]";
		return result;
	}

	private Fields() {
	}; // No instanciable.

}
