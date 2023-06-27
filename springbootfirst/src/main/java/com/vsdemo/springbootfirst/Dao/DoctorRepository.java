package com.vsdemo.springbootfirst.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vsdemo.springbootfirst.Entities.Doctor;
import com.vsdemo.springbootfirst.Entities.Patient;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
	
	public Doctor findByEmail(String email);

}
