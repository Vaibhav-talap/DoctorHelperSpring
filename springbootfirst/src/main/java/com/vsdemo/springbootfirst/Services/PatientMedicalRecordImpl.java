package com.vsdemo.springbootfirst.Services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vsdemo.springbootfirst.Dao.PatientMedicalRecordRepository;
import com.vsdemo.springbootfirst.Dao.PatientRepository;
import com.vsdemo.springbootfirst.Entities.Patient;
import com.vsdemo.springbootfirst.Entities.PatientMedicalRecord;
import com.vsdemo.springbootfirst.payloads.PatientMedicalRecordDto;


@Service
public class PatientMedicalRecordImpl implements PatientMedicalRecordService{
	
	@Autowired
	private PatientMedicalRecordRepository patientMedicalRecordRepository;
	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public PatientMedicalRecordDto savePaatientMedicalRecord(PatientMedicalRecordDto patientMedicalRecordDto) {
		
		PatientMedicalRecord patientMedicalRecord = this.dtotoMedicalRecord(patientMedicalRecordDto);
		PatientMedicalRecord savedPatientMedicalRecord =  this.patientMedicalRecordRepository.save(patientMedicalRecord);
		return this.MedicalRecordtodto(savedPatientMedicalRecord);
	}

	@Override
	public List<PatientMedicalRecordDto> fetchPatientMedicalRecordList() {
		// TODO Auto-generated method stub
		List<PatientMedicalRecord>  MedicalRecords= (List<PatientMedicalRecord>) this.patientMedicalRecordRepository.findAll();
		List<PatientMedicalRecordDto> MedicalRecordsDtos = MedicalRecords.stream().map(patientMedicalRecord -> this.MedicalRecordtodto(patientMedicalRecord)).collect(Collectors.toList());
		return MedicalRecordsDtos;
	}

	@Override
	public PatientMedicalRecordDto updatePatientMedicalRecord(PatientMedicalRecordDto patientMedicalRecordDto, int id) {
		PatientMedicalRecord patientMedicalRecord = patientMedicalRecordRepository.findById(id);
		patientMedicalRecord.setDate(patientMedicalRecordDto.getDate());
		patientMedicalRecord.setDiseaseType(patientMedicalRecordDto.getDiseaseType());
		patientMedicalRecord.setRecommendedMedicine(patientMedicalRecordDto.getRecommendedMedicine());	
		PatientMedicalRecord savedPatientMedicalRecord =  this.patientMedicalRecordRepository.save(patientMedicalRecord);
		return this.MedicalRecordtodto(savedPatientMedicalRecord);
	}

	@Override
	public void deletePatientMedicalRecord(int id) {
		patientMedicalRecordRepository.deleteById(id);
		 
	}



	@Override
//	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<PatientMedicalRecordDto> patientMedicalRecordHistory(int id) {	
		List<PatientMedicalRecord>  patientMedicalRecords= this.patientMedicalRecordRepository.findBypatient_id(id);
//		System.out.println(patientMedicalRecords);
		List<PatientMedicalRecordDto> patientMedicalRecordDtos = patientMedicalRecords.stream().map(patientMedicalRecord -> this.MedicalRecordtodto(patientMedicalRecord)).collect(Collectors.toList());
		return patientMedicalRecordDtos;
		
	}

	@Override
	public PatientMedicalRecordDto getPatientMedicalRecordById(int id) {
		// TODO Auto-generated method stub
		PatientMedicalRecord patientMedicalRecord = patientMedicalRecordRepository.findById(id);
		return this.MedicalRecordtodto(patientMedicalRecord);
		
	}
	
	public PatientMedicalRecord dtotoMedicalRecord(PatientMedicalRecordDto patientMedicalRecordDto) {
		
		int patientId =  patientMedicalRecordDto.getPatient();
		Patient patient = patientRepository.findById(patientId);
		PatientMedicalRecord patientMedicalRecord = new PatientMedicalRecord();
		patientMedicalRecord.setDate(patientMedicalRecordDto.getDate());
		patientMedicalRecord.setDiseaseType(patientMedicalRecordDto.getDiseaseType());
		patientMedicalRecord.setRecommendedMedicine(patientMedicalRecordDto.getRecommendedMedicine());
		patientMedicalRecord.setPatient(patient);	
		return patientMedicalRecord;
		
	}
	public PatientMedicalRecordDto MedicalRecordtodto(PatientMedicalRecord patientMedicalRecord) {
		
		PatientMedicalRecordDto patientMedicalRecordDto = new PatientMedicalRecordDto();
		patientMedicalRecordDto.setPatient(patientMedicalRecord.getPatient().getId());
		patientMedicalRecordDto.setDate(patientMedicalRecord.getDate());
		patientMedicalRecordDto.setDiseaseType(patientMedicalRecord.getDiseaseType());
		patientMedicalRecordDto.setRecommendedMedicine(patientMedicalRecord.getRecommendedMedicine());
		patientMedicalRecordDto.setId(patientMedicalRecord.getId());
		return patientMedicalRecordDto;
		
	}
	
	

}
