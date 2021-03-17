package com.openarc.student.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.openarc.student.domain.Batch;
import com.openarc.student.domain.Course;

public interface BatchRepository extends JpaRepository<Batch, Long> {
	
	List<Batch> findByCourse(Course course , Sort sort );
	void deleteByCourse(Course course);
}
