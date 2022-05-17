package model;

public class Prediction {
	
	int prediction_id, registro_id, animal_id, animal_corregido;
	String message, predictedImagePath;
	Float confidence;
	boolean isPredicted;

	public Prediction(int prediction_id, int registro_id, int animal_id, int animal_corregido, String message, String predictedImagePath,
			Float confidence, boolean isPredicted) {
		this.prediction_id = prediction_id;
		this.registro_id = registro_id;
		this.animal_id = animal_id;
		this.animal_corregido = animal_corregido;
		this.message = message;
		this.predictedImagePath = predictedImagePath;
		this.confidence = confidence;
		this.isPredicted = isPredicted;
	}

	@Override
	public String toString() {
		return "Prediction [prediction_id=" + prediction_id + ", registro_id=" + registro_id + ", animal_id=" + animal_id +
				", animal_corregido=" + animal_corregido + ", message=" + message + ", predictedImagePath=" + predictedImagePath + 
				", confidence=" + confidence + ", isPredicted=" + isPredicted +"]";
	}

	public int getPrediction_id() {
		return prediction_id;
	}

	public int getRegistro_id() {
		return registro_id;
	}

	public int getAnimal_id() {
		return animal_id;
	}

	public int getAnimal_corregido() {
		return animal_corregido;
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
