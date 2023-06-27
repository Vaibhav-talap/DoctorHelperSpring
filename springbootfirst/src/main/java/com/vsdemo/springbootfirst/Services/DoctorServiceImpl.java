package com.vsdemo.springbootfirst.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vsdemo.springbootfirst.Dao.DoctorRepository;
import com.vsdemo.springbootfirst.Entities.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Doctor registerDoctor(Doctor doctor) {
//		 here actually I have to implement the password encyption save method for a doctor.
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> fetchDoctorList() {
		return (List<Doctor>) doctorRepository.findAll();
	}

	@Override
	public Doctor updateDoctor(Doctor doctor, int id) {
		doctor.setId(id);
		return doctorRepository.save(doctor);
	}

	@Override
	public void deleteDoctorById(int id) {
		doctorRepository.deleteById(id);
		
	}

	@Override
	public Optional<Doctor> findByID(int id) {
		return doctorRepository.findById(id);
	}

	@Override
	public Doctor getDoctorByEmail(String email) {	
		return doctorRepository.findByEmail(email);
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		
//		return (UserDetails) doctorRepository.findByFirst_name(username);
//	}
	
	
//	If possible i have to implement the doctor validate and token given method in this service class.

}
