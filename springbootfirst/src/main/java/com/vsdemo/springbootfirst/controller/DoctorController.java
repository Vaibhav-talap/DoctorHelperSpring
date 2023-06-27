package com.vsdemo.springbootfirst.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.vsdemo.springbootfirst.Entities.Doctor;
import com.vsdemo.springbootfirst.Services.DoctorService;
import com.vsdemo.springbootfirst.utils.JwtUtil;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/clinic")
@CrossOrigin("*")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/doctors")
	public ResponseEntity<List<Doctor>>  getAllDoctors(){
		return  new ResponseEntity<>(this.doctorService.fetchDoctorList(),HttpStatus.OK);
	}
	
	
//	@PostMapping("/doctors")
//	public ResponseEntity<Doctor> doctorRegistration(@RequestBody Doctor doctor){
////		Here I have to set the password in encypted format.
//		return new ResponseEntity<>(this.doctorService.registerDoctor(doctor),HttpStatus.OK);
//		
//	}
	@PostMapping("/doctors")
	public ResponseEntity<?> doctorRegistration(@RequestBody ObjectNode json){
//		Here I have to set the password in encypted format.
		 String first_name = json.get("first_name").asText();
		 String last_name = json.get("last_name").asText();	
		 String email = json.get("email").asText();
		 String phone = json.get("phone").asText();
		String password = json.get("password").asText();
		String confirmPassword = json.get("confirmPassword").asText();
		 int age = json.get("age").asInt();
		 
		 if(password.equals(confirmPassword))
		 {
			 Doctor doctor = new Doctor();
			 doctor.setFirst_name(first_name);
			 doctor.setLast_name(last_name);
			 doctor.setAge(age);
			 doctor.setEmail(email);
			 doctor.setPhone(phone);
			 doctor.setPassword(bCryptPasswordEncoder.encode(password)); 
				return new ResponseEntity<>(this.doctorService.registerDoctor(doctor),HttpStatus.OK);
		 }
		 else {
				return new ResponseEntity<>(Map.of("message","Password and confirm password not match"),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/doctors/{id}")
	public ResponseEntity<Doctor> UpdateDoctor(@RequestBody Doctor doctor,@PathVariable("id") int id){
		
		return new ResponseEntity<>(this.doctorService.updateDoctor(doctor, id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/doctors/{id}")
	public void deleteDoctor(@PathVariable("id") int id){
		
		 this.doctorService.deleteDoctorById(id);
		
	}
	@PostMapping("/doctorValidate")
	public ResponseEntity<?> validateDoctor(@RequestBody ObjectNode json) throws ObjectNotFoundException{
		
		 String email = json.get("email").asText();
		 String password = json.get("password").asText();
		 
		 Doctor doctor =  doctorService.getDoctorByEmail(email);
		 if (doctor == null) {
			 return new ResponseEntity<>(Map.of("responseMessage","Doctor does not exist please do register first"),HttpStatus.UNAUTHORIZED);
		 }
		 	 
		 if( bCryptPasswordEncoder.matches(password, doctor.getPassword())) {
			 
			
			String token = jwtUtil.generateToken( this.doctorService.getDoctorByEmail(email));
			System.out.println(jwtUtil.extractUsername(token));
			System.out.println(token);
			 return new ResponseEntity<>(Map.of("access",token, "responseMessage","ok"),HttpStatus.OK);
			 
			 
		 }
		 
		
		 return new ResponseEntity<>(Map.of("responseMessage","Password not matches"),HttpStatus.UNAUTHORIZED);
		
	}
	
	
}
