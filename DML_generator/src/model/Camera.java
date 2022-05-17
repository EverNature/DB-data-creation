package model;

public class Camera {
	
	int camara_id, numero_zona;
	String nombreZona;

	public Camera(int camara_id, int numero_zona, String nombreZona) {
		this.camara_id = camara_id;
		this.numero_zona = numero_zona;
		this.nombreZona = nombreZona;
	}

	@Override
	public String toString() {
		return "Camera [camara_id=" + camara_id + ", numero_zona=" + numero_zona + ", nombreZona=" + nombreZona +"]";
	}

	public String getNombreZona() {
		return nombreZona;
	}

	public int getCamara_id() {
		return camara_id;
	}

	public int getNumero_zona() {
		return numero_zona;
	}

}
