package com.openarc.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.openarc.student.domain.StudentBatchMapping;
import com.openarc.student.repository.BatchRepository;
import com.openarc.student.repository.StudentBatchMappingRepository;

import com.openarc.student.repository.StudentRepository;

@Service
public class StudentBatchMappingService {

	@Autowired
	StudentBatchMappingRepository studentBatchMappingRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	BatchRepository batchRepository;
		
	public List<StudentBatchMapping> selectByStudent(Long studentId) throws Exception{
		if(studentRepository.existsById(studentId)) {
			return studentBatchMappingRepository.findByStudent(studentRepository.findById(studentId).get(), Sort.by(Sort.Direction.ASC));
		}
		else {
			throw new Exception("Wrong StudentId "+studentId);
		}	
	}
	
	public List<StudentBatchMapping> selectByBatch(Long batchId) throws Exception{
		if(batchRepository.existsById(batchId)) {
			return studentBatchMappingRepository.findByBatch(batchRepository.findById(batchId).get(), Sort.by(Sort.Direction.ASC));
		}
		else {
			throw new Exception("Wrong BatchId "+batchId);
		}	
	}
		
	public boolean deleteByStudent(Long studentId) {
		try {
			studentBatchMappingRepository.deleteByStudent(studentRepository.findById(studentId).get());
			return true;
		} catch (Exception e) {
			return false;
		}	 
	}
	
	public boolean deleteByBatch(Long batchId) {
		try {
			studentBatchMappingRepository.deleteByBatch(studentRepository.findById(batchId).get());
			return true;
		} catch (Exception e) {
			return false;
		}	 
	}
	
	public StudentBatchMapping saveStudentBatchMapping(StudentBatchMapping studentBatchMapping) {
		return studentBatchMappingRepository.save(studentBatchMapping);
	}
		
	public StudentBatchMapping updateStudentBatchMapping(Long studentBatchMappingId, Long studentId,Long batchId,StudentBatchMapping studentBatchMapping) throws Exception {
		if(studentBatchMappingRepository.existsById(studentBatchMappingId)) {
			if(studentRepository.existsById(studentId)) {
				if(batchRepository.existsById(batchId)) {
					studentBatchMapping.setStudent(studentRepository.findById(studentId).get());
					studentBatchMapping.setBatch(batchRepository.findById(batchId).get());
					studentBatchMapping.setStudentBatchMappingId(studentBatchMappingId);
					return studentBatchMappingRepository.save(studentBatchMapping);
				}
				else {
					throw new Exception("Wrong BatchId "+batchId);
				}
			}		
			else {
				throw new Exception("Wrong StudentId "+studentId);		
			}			
		}
		else {
			throw new Exception("wrong StudentBatchMappingId "+studentBatchMappingId);
		}
	}
	
	public boolean deleteStudentBatchMapping(Long StudentBatchMappingId) {
		try {
			studentBatchMappingRepository.deleteById(StudentBatchMappingId);
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
		
	public StudentBatchMapping getBatchMapping(Long StudentBatchMappingId) {
		return studentBatchMappingRepository.findById(StudentBatchMappingId).get();			
	}
	
	public List<StudentBatchMapping> getAllBatch(){
		return studentBatchMappingRepository.findAll();
	}	
}



