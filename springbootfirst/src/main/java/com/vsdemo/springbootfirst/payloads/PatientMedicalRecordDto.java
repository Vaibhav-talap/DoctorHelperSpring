package com.vsdemo.springbootfirst.payloads;

import java.util.Date;

public class PatientMedicalRecordDto {
	
	private int id;
	private Date date;
	private String diseaseType;
	private String recommendedMedicine;
	private int patient;
	public PatientMedicalRecordDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientMedicalRecordDto(int id, Date date, String diseaseType, String recommendedMedicine, int patient) {
		super();
		this.id = id;
		this.date = date;
		this.diseaseType = diseaseType;
		this.recommendedMedicine = recommendedMedicine;
		this.patient = patient;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDiseaseType() {
		return diseaseType;
	}
	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}
	public String getRecommendedMedicine() {
		return recommendedMedicine;
	}
	public void setRecommendedMedicine(String recommendedMedicine) {
		this.recommendedMedicine = recommendedMedicine;
	}
	public int getPatient() {
		return patient;
	}
	public void setPatient(int patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "PatientMedicalRecordDto [id=" + id + ", date=" + date + ", diseaseType=" + diseaseType
				+ ", recommendedMedicine=" + recommendedMedicine + ", patient=" + patient + "]";
	}
	
	
	 
	
	

}
