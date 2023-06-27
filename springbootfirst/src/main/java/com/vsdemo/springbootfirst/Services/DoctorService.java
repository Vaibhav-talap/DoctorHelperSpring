package com.vsdemo.springbootfirst.Services;

import java.util.List;
import java.util.Optional;

import com.vsdemo.springbootfirst.Entities.Doctor;

public interface DoctorService {
	
	
	Doctor registerDoctor(Doctor doctor);
	
	List<Doctor>  fetchDoctorList();
	
	Doctor updateDoctor(Doctor doctor,
            int id);

// Delete operation
      void deleteDoctorById(int id);
      
      Optional<Doctor> findByID(int id);
      
      Doctor getDoctorByEmail(String email);
	
	

}
