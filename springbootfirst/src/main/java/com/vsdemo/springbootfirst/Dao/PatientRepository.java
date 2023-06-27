package com.vsdemo.springbootfirst.Dao;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.vsdemo.springbootfirst.Entities.Patient;

@Repository
public interface PatientRepository  extends CrudRepository<Patient, Integer>{
	
	public Patient findById(int id);
	
	public Patient findByEmail(String email);

}
