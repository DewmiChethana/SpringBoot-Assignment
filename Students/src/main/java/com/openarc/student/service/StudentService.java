package com.openarc.student.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openarc.student.domain.Student;
import com.openarc.student.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository; 

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Long StudentId,Student student) throws Exception {	
		if(studentRepository.existsById(StudentId)) {
			return studentRepository.save(student);
	}
		else {
			throw new Exception("Wrong StudentId "+StudentId);
		}				
	}
		
	public boolean  deletStudent(Long StudentId) {
		try {
			studentRepository.deleteById(StudentId);
			return true;
		} catch (Exception e) {
			return false;
		}		
			
	}

	public Student getStudent(Long StudentId) {
		return studentRepository.findById(StudentId).get();  	
	}
	
	public List<Student> getAllStudent() {
		return studentRepository.findAll();  
	}
}
