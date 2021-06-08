package Especiales;

import java.lang.reflect.Field;

@SuppressWarnings("deprecation")
public class FieldsExamen {

	/*
	 * Ejercicio de programaci�n reflexiva. Escriba un m�todo que tome como
	 * par�metro un objeto cualquiera y muestre por pantalla el valor de todos sus
	 * campos primitivos que se hayan anotado con la anotaci�n @Mostrable. 1 punto.
	 * 
	 * Notas: - Siendo f de tipo Field, la sentencia
	 * f.isAnnotationPresent(Mostrable.class) devuelve true si f tiene la anotaci�n,
	 * y false en caso contrario. - Siendo f de tipo Field, la sentencia
	 * f.isPrimitive() devuelve true si f es primitivo y false si no lo es.
	 */

	public static void main(String[] args) {
		Ciudad c = new Ciudad(13003);
		reflexion(c);
	}

	public static void reflexion(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			boolean accesible = fields[i].isAccessible();
			fields[i].setAccessible(true);
			try {
				if (fields[i].getType().isPrimitive() /* && fields[i].isAnnotationPresent(Mostrable.class) */) {
					System.out.println(fields[i].getName() + ": " + fields[i].get(obj));
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			fields[i].setAccessible(accesible);
		}
	}

}


