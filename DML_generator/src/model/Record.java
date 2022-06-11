package model;

import java.time.LocalDate;

public class Record {
	int camara_id;
	String imgPath;
	
	LocalDate recordDate, validationDate;
	
	public Record(String imgPath, LocalDate recordDate, LocalDate validationDate, int camara_id) {
		this.camara_id = camara_id;
		this.imgPath = imgPath;
		this.recordDate = recordDate;
		this.validationDate = validationDate;
		
		
	}

	public int getCamara_id() {
		return camara_id;
	}

	public String getImgPath() {
		return imgPath;
	}


	public LocalDate getRecordDate() {
		return recordDate;
	}

	public LocalDate getValidationDate() {
		return validationDate;
	}

	@Override
	public String toString() {
		return "Record [camara_id=" + camara_id + ", imgPath="
	+ imgPath  + ", recordDate=" + recordDate + ", validationDate=" + validationDate +"]";
	}

}
