package com.vsdemo.springbootfirst.Services;

import java.util.List;
import com.vsdemo.springbootfirst.payloads.PatientMedicalRecordDto;

public interface PatientMedicalRecordService {
	
	PatientMedicalRecordDto savePaatientMedicalRecord(PatientMedicalRecordDto patientMedicalRecordDto);
	
	List<PatientMedicalRecordDto>  fetchPatientMedicalRecordList();
	
	List<PatientMedicalRecordDto>  patientMedicalRecordHistory(int id);
	
	PatientMedicalRecordDto updatePatientMedicalRecord(PatientMedicalRecordDto patientMedicalRecordDto,
            int id);

// Delete operation
      void deletePatientMedicalRecord(int id);
      
      PatientMedicalRecordDto getPatientMedicalRecordById(int id);
}
