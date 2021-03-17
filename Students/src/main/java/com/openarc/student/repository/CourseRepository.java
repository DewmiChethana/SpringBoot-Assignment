package com.openarc.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openarc.student.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Long>  {

}
