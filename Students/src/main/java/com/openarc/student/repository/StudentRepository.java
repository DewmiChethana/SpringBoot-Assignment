package com.openarc.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openarc.student.domain.Student;
import com.openarc.student.domain.StudentBatchMapping;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
