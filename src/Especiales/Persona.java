package Especiales;

public class Persona {

	private String nombre;
	private int edad;
	private Casa casa;

	public Persona(String nombre, int edad, Casa casa) {
		this.setNombre(nombre);
		this.setEdad(edad);
		this.setCasa(casa);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	@Override
	public String toString() {
		return Fields.toString(this, true);
	}

}
