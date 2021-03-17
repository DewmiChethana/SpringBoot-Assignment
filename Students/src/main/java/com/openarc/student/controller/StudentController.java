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

import com.openarc.student.domain.Student;
import com.openarc.student.service.StudentService;

@RestController
@RequestMapping
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@PostMapping("/student")
	private Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student) ;
	}
	
	@PutMapping(value="/student/{studentId}")
	private Student updateStudent(@PathVariable Long studentId,@RequestBody Student student) throws Exception {
		return studentService.updateStudent(studentId, student);
	}
	
	@DeleteMapping("/student/{studentId}")
	private boolean deleteStudent(@PathVariable Long studentId) {
		return studentService.deletStudent(studentId);	
	}
	
	@GetMapping("/student/{studentId}")
	private Student getStudent(@PathVariable Long studentId) {
		return studentService.getStudent(studentId);
	}
	
	@GetMapping(value="/students")
	private List<Student> getStudents(){
		return studentService.getAllStudent();
	}
}