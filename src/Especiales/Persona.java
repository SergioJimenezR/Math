package Especiales;

public class Persona {

	private String nombre;
	private int edad;
	private Casa casa;
	private int[] nums;

	public Persona(String nombre, int edad, Casa casa, int[] nums) {
		this.setNombre(nombre);
		this.setEdad(edad);
		this.setCasa(casa);
		this.nums = nums;
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

	public int[] getNums() {
		return nums;
	}

	public void setNums(int[] nums) {
		this.nums = nums;
	}

	@Override
	public String toString() {
		return Fields.toString(this, true);
	}

}
