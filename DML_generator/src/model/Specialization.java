package model;

public class Specialization {
	int specialization_id;
	String nombre_especializacion;

	public Specialization(int specialization_id, String nombre_especializacion) {
		this.specialization_id = specialization_id;
		this.nombre_especializacion = nombre_especializacion;
	}

	@Override
	public String toString() {
		return "Specialization [specialization_id=" + specialization_id + ", nombre_especializacion=" + nombre_especializacion +"]";
	}

	public int getSpecialization_id() {
		return specialization_id;
	}

	public String getNombre_especializacion() {
		return nombre_especializacion;
	}



}
