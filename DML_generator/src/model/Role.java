package model;

public class Role {

	int rol_id;
	String nombre;

	public Role(int rol_id, String nombre) {
		this.rol_id = rol_id;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Role [rol_id=" + rol_id + ", nombre=" + nombre + "]";
	}

	public int getRol_id() {
		return rol_id;
	}

	public String getNombre() {
		return nombre;
	}

}
