package model;

import java.time.LocalDate;

public class Record {
	int registro_id, camara_id, experto_id;
	String imgPath;
	boolean isCorrect;
	LocalDate recordDate, validationDate;
	
	public Record(int registro_id, int camara_id, int experto_id, String imgPath, boolean isCorrect,
			LocalDate recordDate, LocalDate validationDate) {
		this.registro_id = registro_id;
		this.camara_id = camara_id;
		this.experto_id = experto_id;
		this.imgPath = imgPath;
		this.isCorrect = isCorrect;
		this.recordDate = recordDate;
		this.validationDate = validationDate;
		
		
	}

	public int getRegistro_id() {
		return registro_id;
	}

	public int getCamara_id() {
		return camara_id;
	}

	public int getExperto_id() {
		return experto_id;
	}

	public String getImgPath() {
		return imgPath;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public LocalDate getRecordDate() {
		return recordDate;
	}

	public LocalDate getValidationDate() {
		return validationDate;
	}

	@Override
	public String toString() {
		return "Record [registro_id=" + registro_id + ", camara_id=" + camara_id + ", experto_id=" + experto_id + ", imgPath="
	+ imgPath + "isCorrect=" + isCorrect + ", recordDate=" + recordDate + ", validationDate=" + validationDate +"]";
	}

}
