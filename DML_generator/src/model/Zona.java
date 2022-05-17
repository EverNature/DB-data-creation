package model;

public class Zona {
	int numero_zona;
	public int getNumero_zona() {
		return numero_zona;
	}

	public String getNombre_zona() {
		return nombre_zona;
	}

	String nombre_zona;

	public Zona(int numero_zona, String nombre_zona) {
		this.numero_zona = numero_zona;
		this.nombre_zona = nombre_zona;
	}

	@Override
	public String toString() {
		return "Zona [numero_zona=" + numero_zona + ", nombre_zona=" + nombre_zona +"]";
	}

}
