package com.vsdemo.springbootfirst.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsdemo.springbootfirst.Dao.PatientRepository;
import com.vsdemo.springbootfirst.Entities.Patient;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient savePatient(Patient patient) {	
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> getallPatient() {
		return (List<Patient>) patientRepository.findAll();
	}

	@Override
	public Patient updatePatient(Patient patient, int id) {
		patient.setId(id);
		return patientRepository.save(patient);
	}

	@Override
	public void deletePatientById(int id) {
		patientRepository.deleteById(id);
		
	}

	@Override
	public Patient getPatientById(int id) {
		return patientRepository.findById(id);
	}

	@Override
	public int getPatientByEmail(String email) {
		
		Patient patient = patientRepository.findByEmail(email);
		if(patient == null) {
			return 0;
		}
		return patient.getId();
	}

}
