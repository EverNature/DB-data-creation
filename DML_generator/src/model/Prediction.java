package model;

public class Prediction {
	
	int registro_id, animal_id, experto_id;
	String message, predictedImagePath;
	Float confidence;
	boolean isPredicted;

	public Prediction(int registro_id, int animal_id, String message, String predictedImagePath,
			Float confidence, int experto_id) {
		this.registro_id = registro_id;
		this.animal_id = animal_id;
		this.message = message;
		this.predictedImagePath = predictedImagePath;
		this.confidence = confidence;
		this.experto_id = experto_id;
		this.isPredicted = true;
	}

	public int getExperto_id() {
		return experto_id;
	}

	@Override
	public String toString() {
		return "Prediction [registro_id=" + registro_id + ", animal_id=" + animal_id +
				", message=" + message + ", predictedImagePath=" + predictedImagePath + 
				", confidence=" + confidence +"]";
	}


	public int getRegistro_id() {
		return registro_id;
	}

	public int getAnimal_id() {
		return animal_id;
	}

	public String getMessage() {
		return message;
	}

	public String getPredictedImagePath() {
		return predictedImagePath;
	}

	public Float getConfidence() {
		return confidence;
	}

	public boolean isPredicted() {
		return isPredicted;
	}

}
