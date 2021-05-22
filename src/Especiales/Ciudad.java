package Especiales;

public class Ciudad {

	private int cp;

	public Ciudad(int cp) {
		this.setCp(cp);
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	@Override
	public String toString() {
		return Fields.toString(this, true);
	}

}
