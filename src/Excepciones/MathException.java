package Excepciones;

public class MathException extends Exception {

	private static final long serialVersionUID = 1L;

	public MathException() {
	}

	public MathException(String mensaje) {
		super(mensaje);
	}

}
