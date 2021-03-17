package com.openarc.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.openarc.student.domain.Batch;
import com.openarc.student.repository.BatchRepository;
import com.openarc.student.repository.CourseRepository;

@Service
public class BatchService {
	
	@Autowired 
	BatchRepository batchRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	public List<Batch> getByCourse(Long courseId){
		return batchRepository.findByCourse(courseRepository.findById(courseId).get(), Sort.by(Sort.Direction.ASC));
	}
	
	public boolean deleteByCourse(Long courseId) {
		try {
			batchRepository.deleteByCourse(courseRepository.findById(courseId).get());
			return true;
		} catch (Exception e) {
			return false;
		}	 
	}
	
	public Batch saveBatch(Batch batch) {
		return batchRepository.save(batch);
	}
		
	public Batch updateBatch(Long courseId, Long batchId, Batch batch) throws Exception {
		if(courseRepository.existsById(courseId)) {
			batch.setCourse(courseRepository.findById(courseId).get());
			batch.setBatchId(batchId);
			return batchRepository.save(batch);
	}
		else {
			throw new Exception("wrong CourseId "+courseId);
		}
	}
	
	public boolean deleteBatch(Long BatchId) {
		try {
			batchRepository.deleteById(BatchId);
			return true;
		} catch (Exception e) {
			return false;
		}					
	}
		
	public Batch getBatch(Long BatchId) {
		return batchRepository.findById(BatchId).get();
	}
	
	public List<Batch> getAllBatch(){
		return batchRepository.findAll();
	}	
}
