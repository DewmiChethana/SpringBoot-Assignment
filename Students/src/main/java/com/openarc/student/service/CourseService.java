package com.openarc.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openarc.student.domain.Course;
import com.openarc.student.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	public Course createCourse(Course Course) {
		return courseRepository.save(Course);
	}
	
	public Course updateCourse(Long CourseId,Course course) throws Exception {	
		if(courseRepository.existsById(CourseId)) {
			return courseRepository.save(course);
	}
		else {
			throw new Exception("wrong CourseId "+CourseId);
		}
	}
		
	public boolean  deleteCourse(Long CourseId) {
		try {
			courseRepository.deleteById(CourseId);	
			return true;
		} catch (Exception e) {
			return false;
		}	
	}

	public Course getCourse(Long CourseId) {
		return courseRepository.findById(CourseId).get();  	
	}
	
	public List<Course> getAllCourse() {
		return courseRepository.findAll();  
	}
}


