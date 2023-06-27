package com.vsdemo.springbootfirst.controller;

import java.text.ParseException;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vsdemo.springbootfirst.Services.PatientMedicalRecordService;
import com.vsdemo.springbootfirst.payloads.PatientMedicalRecordDto;

@RestController
@RequestMapping("/clinic")
@CrossOrigin("*")
public class PatientMedicalRecordController {
	
	
	@Autowired
	private PatientMedicalRecordService patientMedicalRecordService;
	
	@GetMapping("/medicalRecords")
	public  List<PatientMedicalRecordDto> getAllMedicalRecords(){
		return this.patientMedicalRecordService.fetchPatientMedicalRecordList();
	}
	@PutMapping("/medicalRecords/{id}")
	public ResponseEntity<PatientMedicalRecordDto>  updatePatientMedicalRecord(@RequestBody PatientMedicalRecordDto patientMedicalRecordDto,@PathVariable("id") int id) throws ParseException{	 
		return new ResponseEntity<> (this.patientMedicalRecordService.updatePatientMedicalRecord(patientMedicalRecordDto, id),HttpStatus.OK);
		
	}
	@DeleteMapping("/medicalRecords/{id}")
	public void deleteDoctor(@PathVariable("id") int id){
		  this.patientMedicalRecordService.deletePatientMedicalRecord(id);
	}
	
	@GetMapping("/patientMedicalRecords/{id}")
	public ResponseEntity<List<PatientMedicalRecordDto>>  getPatientMedicalRecordHistory(@PathVariable("id") int id){
//		System.out.println(this.patientMedicalRecordService.patientMedicalRecordHistory(id));
		return new ResponseEntity<>(this.patientMedicalRecordService.patientMedicalRecordHistory(id),HttpStatus.OK);
	}
//	}
	@PostMapping("/medicalRecords")
	public ResponseEntity<PatientMedicalRecordDto> patientMedicalRecordInsertion(@RequestBody PatientMedicalRecordDto patientMedicalRecordDto) throws ParseException{
		
	    return new ResponseEntity<>(this.patientMedicalRecordService.savePaatientMedicalRecord(patientMedicalRecordDto),HttpStatus.CREATED);
//	    return null;
	    
		
	}

	
	
//	@PostMapping("/medicalRecords")
//	public PatientMedicalRecord patientMedicalRecordInsertion(@RequestBody PatientMedicalRecord patientMedicalRecord,@RequestParam int patient){
////		Here I have to set the password in encypted format.
//		patientMedicalRecord.setPatient(patientService.getPatientById(patient));
//		return this.patientMedicalRecordService.savePaatientMedicalRecord(patientMedicalRecord);
//		
//	}
//	@PostMapping("/medicalRecords")
//	public PatientMedicalRecord patientMedicalRecordInsertion(@RequestBody ObjectNode json) throws ParseException{
////		Here I have to set the password in encypted format.
//		System.out.println(json);
//		int patientID = json.get("patient").asInt();	
//		String diseaseType= 	json.get("diseaseType").asText();	
//		String recommendedMedicine= 	json.get("recommendedMedicine").asText();
//		String stringdate = json.get("date").asText();
//		
////		System.out.println(date);
//		System.out.println(diseaseType);
////		        
//		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
//        Date d = s.parse(stringdate);
////		LocalDate date = LocalDate.parse(stringdate);
////		   System.out.println(date);	
//	    PatientMedicalRecord patientMedicalRecord = new PatientMedicalRecord(0,d,diseaseType,recommendedMedicine,patientService.getPatientById(patientID));
//	    PatientMedicalRecord patientMedicalRecord2  = this.patientMedicalRecordService.savePaatientMedicalRecord(patientMedicalRecord);
//	    return this.patientMedicalRecordService.getPatientMedicalRecordById(patientMedicalRecord2.getId());
////	    return null;
//	    
//		

	
//	@PutMapping("/medicalRecords/{id}")
//	public PatientMedicalRecord updatePatientMedicalRecord(@RequestBody ObjectNode json,@PathVariable("id") int id) throws ParseException{
//		int patientID = json.get("patient").asInt();	
//		String diseaseType= 	json.get("diseaseType").asText();	
//		String recommendedMedicine= 	json.get("recommendedMedicine").asText();
//		String stringdate = json.get("date").asText();
//		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
//        Date d = s.parse(stringdate);
//		
//		PatientMedicalRecord patientMedicalRecord = patientMedicalRecordService.getPatientMedicalRecordById(id);
//				
//		patientMedicalRecord.setDiseaseType(diseaseType);
//		patientMedicalRecord.setRecommendedMedicine(recommendedMedicine);
//		patientMedicalRecord.setDate(d);
//		
////		Here the update method returning the same entity which we have given so we have to return the record by using findbyid method.
//		
//		 this.patientMedicalRecordService.updatePatientMedicalRecord(patientMedicalRecord, id);
//		return this.patientMedicalRecordService.getPatientMedicalRecordById(id);
//		
//	}
	

	
	

}
