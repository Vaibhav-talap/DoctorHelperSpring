package com.vsdemo.springbootfirst.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vsdemo.springbootfirst.Entities.PatientMedicalRecord;

@Repository
public interface PatientMedicalRecordRepository extends CrudRepository<PatientMedicalRecord, Integer>{
	public List<PatientMedicalRecord> findBypatient_id(int id);
	public PatientMedicalRecord findById(int id);

}
