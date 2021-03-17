package com.openarc.student.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.openarc.student.domain.Batch;
import com.openarc.student.domain.Student;
import com.openarc.student.domain.StudentBatchMapping;

public interface StudentBatchMappingRepository extends JpaRepository<StudentBatchMapping, Long>  {

    List<StudentBatchMapping> findByStudent(Student student , Sort sort );
    List<StudentBatchMapping> findByBatch(Batch batch , Sort sort );
	
	void deleteByStudent(Student student);
	void deleteByBatch(Student student);
}	
	

