package com.vsdemo.springbootfirst;


import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vsdemo.springbootfirst.Dao.PatientMedicalRecordRepository;
import com.vsdemo.springbootfirst.Dao.PatientRepository;
import com.vsdemo.springbootfirst.Entities.Patient;
import com.vsdemo.springbootfirst.Entities.PatientMedicalRecord;


//@EntityScan(basePackages = {"com.vsdemo.springbootfirst.Entities"})
//@EnableJpaRepositories(basePackages = "com.vsdemo.springbootfirst.Dao")
@SpringBootApplication(scanBasePackages={"com.vsdemo.springbootfirst"} , exclude = {SecurityAutoConfiguration.class})
public class SpringbootfirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootfirstApplication.class, args);
//		ApplicationContext context = (ApplicationContext) 
//		 	
//		PatientMedicalRecordRepository patientMedicalRecordRepository = context.getBean(PatientMedicalRecordRepository.class);
//		
//		PatientRepository patientRepository = context.getBean(PatientRepository.class);
//
//		Patient patient = new Patient(1,"vaibhav","talap","talapvaibhav@gmail.com","8956562159",22);
//		patientRepository.save(patient);
////		
//		PatientMedicalRecord patientMedicalRecord = new PatientMedicalRecord(1,new Date("2020/06/16"),"fever","crocine",patient);
////
////		
//		PatientMedicalRecord r1 = patientMedicalRecordRepository.save(patientMedicalRecord);
//		
//		System.out.println(r1);
//		
//		System.out.println(patientMedicalRecordRepository.findBypatient_id(1)); 
//		
	
	}

}
