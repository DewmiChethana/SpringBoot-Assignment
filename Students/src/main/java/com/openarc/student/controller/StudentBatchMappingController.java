package com.openarc.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openarc.student.domain.StudentBatchMapping;
import com.openarc.student.service.StudentBatchMappingService;

@RestController
@RequestMapping
public class StudentBatchMappingController {
	@Autowired
	StudentBatchMappingService studentBatchMappingService;
	
	@PostMapping("/studentBatchMapping")
	private StudentBatchMapping createStudentBatchMapping(@RequestBody StudentBatchMapping studentBatchMapping) {
		return studentBatchMappingService.saveStudentBatchMapping(studentBatchMapping) ;
	}
	
	@PutMapping(value="/studentBatchMapping/{studentBatchMappingId}/{studentId}/{batchId}")
	private StudentBatchMapping updateStudentBatchMapping(@PathVariable Long studentBatchMappingId,@PathVariable Long studentId,@PathVariable Long batchId,@PathVariable @RequestBody StudentBatchMapping studentBatchMapping) throws Exception {
		return studentBatchMappingService.updateStudentBatchMapping(studentBatchMappingId,studentId,batchId, studentBatchMapping);
	}
	
	@DeleteMapping("/studentBatchMapping/{studentBatchMappingId}")
	private boolean deleteStudentBatchMapping(@PathVariable Long studentBatchMappingId) {
		return studentBatchMappingService.deleteStudentBatchMapping(studentBatchMappingId);	
	}
	
	@DeleteMapping(value="/studentBatchMapping/batch/{batchId}")
	private boolean deleteByBatch(@PathVariable Long batchId) {
		return studentBatchMappingService.deleteByBatch(batchId);
	}
	
	@DeleteMapping(value="/studentBatchMapping/student/{studentId}")
	private boolean deleteByStudent(@PathVariable Long studentId) {
		return studentBatchMappingService.deleteByStudent(studentId);
	}
	
	@GetMapping("/studentBatchMapping/{studentBatchMappingId}")
	private StudentBatchMapping getStudentBatchMapping(@PathVariable Long studentBatchMappingId) {
		return studentBatchMappingService.getBatchMapping(studentBatchMappingId);
	}
	
	@GetMapping(value="/studentBatchMappinges")
	private List<StudentBatchMapping> getStudentBatchMappinges(){
		return studentBatchMappingService.getAllBatch();
	}
	
	@GetMapping(value= "/studentBatchMapping/student/{studentId}")
	private List<StudentBatchMapping> getStudentBatchMappingByStudent(@PathVariable Long studentId) throws Exception{
		return studentBatchMappingService.selectByStudent(studentId);	
	}
	
	@GetMapping(value= "/studentBatchMapping/batch/{batchId}")
	private List<StudentBatchMapping> getStudentBatchMappingByBatch(@PathVariable Long batchId) throws Exception{
		return studentBatchMappingService.selectByBatch(batchId);	
	}
}
