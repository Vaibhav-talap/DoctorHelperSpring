package com.vsdemo.springbootfirst.controller;

import java.util.List;
import java.util.Map;

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

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vsdemo.springbootfirst.Entities.Patient;
import com.vsdemo.springbootfirst.Services.PatientService;

@RestController
@RequestMapping("/clinic")
@CrossOrigin("*")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatients(){
		return new ResponseEntity<>(this.patientService.getallPatient(),HttpStatus.OK);
	}
	
	
	@PostMapping("/patients")
	public ResponseEntity<Patient>  PatientRegistration(@RequestBody Patient patient){
		System.out.println(patient);
		return new ResponseEntity<>(this.patientService.savePatient(patient),HttpStatus.CREATED);
//		Here I have to set the password in encypted format.
		
	}
	
	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient,@PathVariable("id") int id){
		
		return new ResponseEntity<>(this.patientService.updatePatient(patient, id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/patients/{id}")
	public void deleteDoctor(@PathVariable("id") int id){
		  this.patientService.deletePatientById(id);
	}
	 @CrossOrigin("*")
	@PostMapping("/patientId")
	public ResponseEntity<?> getPatientIDByEmail(@RequestBody ObjectNode json) {
	 String email= 	json.get("email").asText();	
	 if(this.patientService.getPatientByEmail(email) == 0) {
		 return new ResponseEntity<>(Map.of("responseMessage","Patient does not exist Please enter valid Email"),HttpStatus.BAD_REQUEST);
	 }
	 return new ResponseEntity<>(Map.of("id",this.patientService.getPatientByEmail(email),"responseMessage","ok"),HttpStatus.OK);
//	here in frontend I have to  send only string email in react app not a object
		
	}

}
