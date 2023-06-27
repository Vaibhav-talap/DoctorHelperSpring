package com.vsdemo.springbootfirst.Entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PatientMedicalRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	private String diseaseType;
	private String recommendedMedicine;
	
	@ManyToOne
	private Patient patient;
	
	
	
	public PatientMedicalRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientMedicalRecord(int id, Date date, String diseaseType, String recommendedMedicine, Patient patient) {
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
	

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	


	public Patient getPatient() {
		return patient;
	}






	public void setPatient(Patient patient) {
		this.patient = patient;
	}






	@Override
	public String toString() {
		return "PatientMedicalRecord [id=" + id + ", date=" + date + ", diseaseType=" + diseaseType
				+ ", recommendedMedicine=" + recommendedMedicine + ", patient=" + patient.getId()  + "]";
	}






	

}
