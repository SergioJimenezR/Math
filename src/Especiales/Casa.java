package Especiales;

public class Casa {

	private String direccion;
	private double valorCatastral;
	private Ciudad ciudad;

	public Casa(String direccion, double valorCatastral, Ciudad ciudad) {
		this.setDireccion(direccion);
		this.setValorCatastral(valorCatastral);
		this.setCiudad(ciudad);
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getValorCatastral() {
		return valorCatastral;
	}

	public void setValorCatastral(double valorCatastral) {
		this.valorCatastral = valorCatastral;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return Fields.toString(this, true);
	}

}
