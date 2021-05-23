package Fechas;

import Excepciones.MathException;
import Otros.Auxiliares;

/**
 * 
 * @author Sergio Jiménez Roncero
 *
 */

public class Fecha implements Auxiliares {

	private int dia;
	private int mes;
	private int annio;

	private boolean mesNumerico;
	private boolean bisiesto;

	public Fecha(int dia, int mes, int annio) throws MathException {
		this.setMes(mes);
		this.setAnnio(annio);
		this.setDia(dia);
	}

	public Fecha(int dia, String mes, int annio) throws MathException {
		this.setMes(mes);
		this.setAnnio(annio);
		this.setDia(dia);
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) throws MathException {
		if (dia < 1 || dia > getDiasMes())
			throw new MathException("Día incorrecto: " + dia + "/" + this.getMes() + "/" + this.getAnnio() + ". "
					+ this.getMesLiteral() + " tiene " + this.getDiasMes(this.getMes(), this.getAnnio()) + ".");
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public String getMesLiteral() {
		return MESES[mes - 1];
	}

	private static final String MES_INCORRECTO_INTERVALO_1_12 = "Mes incorrecto: (intervalo [1,12]) ";

	public void setMes(int mes) throws MathException {
		if (mes < 1 || mes > 12) {
			throw new MathException(MES_INCORRECTO_INTERVALO_1_12 + mes);
		}
		this.mes = mes;
		mesNumerico = true;
	}

	public void setMes(String mes) throws MathException {
		for (int i = 0; i < MESES.length; i++)
			if (MESES[i].equalsIgnoreCase(mes)) {
				this.mes = i + 1;
				mesNumerico = false;
				return;
			}
		throw new MathException(MES_INCORRECTO_INTERVALO_1_12 + mes);
	}

	public int getAnnio() {
		return annio;
	}

	public void setAnnio(int annio) throws MathException {
		if (annio < 1900)
			throw new MathException("Annio incorrecto: " + annio + ". No se aceptan annios anteriores a 1900.");
		this.annio = annio;
		setBisiesto(annio);
	}

	@Override
	public String toString() {
		return mesNumerico ? getDia() + "/" + getMes() + "/" + getAnnio()
				: getDia() + " de " + getMesLiteral() + " de " + getAnnio();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annio;
		result = prime * result + (bisiesto ? 1231 : 1237);
		result = prime * result + dia;
		result = prime * result + mes;
		result = prime * result + (mesNumerico ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		else if (obj == null || getClass() != obj.getClass())
			return false;
		else {
			Fecha other = (Fecha) obj;
			return dia == other.dia && mes == other.mes && annio == other.annio;
		}
	}

	public int compareTo(Fecha fecha) {
		if (this.getAnnio() > fecha.getAnnio())
			return 1;
		else if (this.getAnnio() < fecha.getAnnio())
			return -1;
		else if (this.getMes() > fecha.getMes())
			return 1;
		else if (this.getMes() < fecha.getMes())
			return -1;
		else if (this.getDia() > fecha.getDia())
			return 1;
		else if (this.getDia() < fecha.getDia())
			return -1;
		else
			return 0;
	}

	public boolean isBisiesto() {
		return bisiesto;
	}

	public void setBisiesto(boolean bisiesto) {
		this.bisiesto = bisiesto;
	}

	public boolean isBisiesto(int annio) {
		return annio % 4 == 0;
	}

	public void setBisiesto(int annio) {
		this.setBisiesto(isBisiesto(annio));
	}

	public int getDiasMes() {
		try {
			return getDiasMes(mes, annio);
		} catch (MathException exc) {
			// Never.
			return 0;
		}
	}

	public int getDiasMes(int mes, int annio) throws MathException {
		if (mes < 1 || mes > 12)
			throw new MathException(MES_INCORRECTO_INTERVALO_1_12 + mes);
		if (isBisiesto(annio) && mes == 2)
			return 29;
		return DIAS_MESES[mes - 1];
	}

	public int getDiasMesAnterior() {
		try {
			return getDiasMes(this.getMes() - 1 == 0 ? 12 : this.getMes() - 1, annio);
		} catch (MathException e) {
			// Never
			return 0;
		}
	}

	public void incrementarDia() {
		try {
			if (this.getDia() == getDiasMes()) {
				this.setDia(1);
				incrementarMes();
			} else {
				this.setDia(this.getDia() + 1);
			}
		} catch (MathException exc) {
			// Tú y yo sabemos que no vas a provocar excepción. Asúmelo. #Humor
		}
	}

	public void decrementarDia() throws MathException {
		if (this.getDia() == 1) {
			incrementarMeses(-1);
			this.setDia(getDiasMes());
		} else {
			this.setDia(this.getDia() - 1);
		}
	}

	public void incrementarDias(int delta) throws MathException { // Mejorable aplicando mód getDiasMes().
		for (int i = 0; i < Math.abs(delta); i++)
			if (delta > 0)
				incrementarDia();
			else
				decrementarDia();
	}

	public void incrementarMes() {
		try {
			if (this.getMes() == 12) {
				this.setMes(1);
				incrementarAnnio();
			} else {
				this.setMes(this.getMes() + 1);
			}
		} catch (MathException exc) {
			// Regla nº 1: No provocarás excepción. #Humor
		}
	}

	public void decrementarMes() throws MathException { // Mejorable aplicando mód 12.
		if (this.getDia() > this.getDiasMesAnterior())
			this.setDia(this.getDiasMesAnterior());
		if (this.getMes() == 1) {
			this.setMes(12);
			incrementarAnnios(-1);
		} else {
			this.setMes(this.getMes() - 1);
		}
	}

	public void incrementarMeses(int delta) throws MathException {
		for (int i = 0; i < Math.abs(delta); i++)
			if (delta > 0)
				incrementarMes();
			else
				decrementarMes();
	}

	public void incrementarAnnio() {
		try {
			this.setAnnio(this.getAnnio() + 1);
		} catch (MathException exc) {
			// Menos visitable que el Área 51. #Humor
		}
	}

	public void incrementarAnnios(int delta) throws MathException {
		this.setAnnio(this.getAnnio() + delta);
	}

	public boolean check() {
		try {
			this.setDia(this.getDia());
			return true;
		} catch (MathException exc) {
			return false;
		}
	}

	public static void main(String[] args) {
		try {
			Fecha f = new Fecha(1, 1, 2000);
			System.out.println(f.toString());
		} catch (MathException e) {
			e.printStackTrace();
		}
	}

	// *** TESTING COMPLETADO SATISFACTORIAMENTE ***
	// Métodos incrementarDias(delta) y incrementarMeses(delta) refinables.

}
