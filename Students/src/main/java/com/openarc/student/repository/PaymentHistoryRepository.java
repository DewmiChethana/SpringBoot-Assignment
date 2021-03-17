package com.openarc.student.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.openarc.student.domain.PaymentHistory;
import com.openarc.student.domain.StudentBatchMapping;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long>  {
	
	List<PaymentHistory> findByStudentBatchMapping(StudentBatchMapping studentBatchMapping , Sort sort );	
	void deleteByStudentBatchMapping(StudentBatchMapping studentBatchMapping);
}
