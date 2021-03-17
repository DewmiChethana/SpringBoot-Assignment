package com.openarc.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.openarc.student.domain.PaymentHistory;
import com.openarc.student.repository.PaymentHistoryRepository;
import com.openarc.student.repository.StudentBatchMappingRepository;

@Service
public class PaymentHistoryService {
	
	@Autowired
	PaymentHistoryRepository paymentHistoryRepository;
	
	@Autowired
	StudentBatchMappingRepository studentBatchMappingRepository;
	
	public List<PaymentHistory> selectByStudentBatchMapping(Long studentBatchMappingId){
		return paymentHistoryRepository.findByStudentBatchMapping(studentBatchMappingRepository.findById(studentBatchMappingId).get(), Sort.by(Sort.Direction.ASC));
	}
	
	public boolean deleteByStudentBatchMapping(Long StudentBatchMappingId) {
		try {
			paymentHistoryRepository.deleteByStudentBatchMapping(studentBatchMappingRepository.findById(StudentBatchMappingId).get());
			return true;
		} catch (Exception e) {
			return false;
		}	 
	}
	
	public PaymentHistory savePaymentHistory(PaymentHistory paymentHistory) {
		return paymentHistoryRepository.save(paymentHistory);
	}
		
	public PaymentHistory updatePaymentHistory(Long studentBatchMappingId, Long paymentHistoryId, PaymentHistory paymentHistory) throws Exception {
		if(studentBatchMappingRepository.existsById(studentBatchMappingId)) {
			paymentHistory.setStudentBatchMapping(studentBatchMappingRepository.findById(studentBatchMappingId).get());
			paymentHistory.setPaymentHistoryId(paymentHistoryId);
			return paymentHistoryRepository.save(paymentHistory);
	}
		else {
			throw new Exception("wrong StudentBatchMappingId "+studentBatchMappingId);
		}
	}
	
	public boolean deletePaymentHistory(Long PaymentHistoryId) {
		try {
			paymentHistoryRepository.deleteById(PaymentHistoryId);
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
		
	public PaymentHistory getPaymentHistory(Long PaymentHistoryId) {
		return paymentHistoryRepository.findById(PaymentHistoryId).get();
	}
	
	public List<PaymentHistory> getAllPaymentHistory(){
		return paymentHistoryRepository.findAll();
	}	
}
