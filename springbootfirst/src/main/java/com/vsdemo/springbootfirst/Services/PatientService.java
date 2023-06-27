package com.vsdemo.springbootfirst.Services;

import java.util.List;

import com.vsdemo.springbootfirst.Entities.Patient;

public interface PatientService {
	
	Patient savePatient(Patient patient);
	
	List<Patient> getallPatient();
	
	Patient updatePatient(Patient patient, int id);
	
	void deletePatientById(int id);
	
	Patient getPatientById(int id);
	
	int getPatientByEmail(String email);

}
