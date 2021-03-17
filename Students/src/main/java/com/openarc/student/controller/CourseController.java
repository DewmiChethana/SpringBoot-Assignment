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

import com.openarc.student.domain.Course;
import com.openarc.student.service.CourseService;

@RestController
@RequestMapping
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@PostMapping("/course")
	private Course createCourse(@RequestBody Course course) {
		return courseService.createCourse(course) ;
	}
	
	@PutMapping(value="/course/{courseId}")
	private Course updateCourse(@PathVariable Long courseId,@RequestBody Course course) throws Exception {
		return courseService.updateCourse(courseId, course);
	}
	
	@DeleteMapping("/course/{courseId}")
	private boolean deleteCourse(@PathVariable Long courseId) {
		return courseService.deleteCourse(courseId);	
	}
	
	@GetMapping("/course/{courseId}")
	private Course getCourse(@PathVariable Long courseId) {
		return courseService.getCourse(courseId);
	}
	
	@GetMapping(value="/coursees")
	private List<Course> getCourses(){
		return courseService.getAllCourse();
	}
}
