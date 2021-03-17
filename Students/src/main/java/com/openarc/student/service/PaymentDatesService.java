package com.openarc.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.openarc.student.domain.PaymentDates;
import com.openarc.student.repository.BatchRepository;
import com.openarc.student.repository.PaymentDatesRepository;

@Service
public class PaymentDatesService {

	@Autowired
	PaymentDatesRepository paymentDatesRepository;
	
	@Autowired
	BatchRepository batchRepository;
	
	public List<PaymentDates> selectByBatch(Long batchId){
		return paymentDatesRepository.findByBatch(batchRepository.findById(batchId).get(),Sort.by(Sort.Direction.ASC));
	}
	
	public boolean deleteByBatch(Long batchId) {
		try {
			paymentDatesRepository.deleteByBatch(batchRepository.findById(batchId).get());
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	public PaymentDates savePaymentDates(PaymentDates paymentDates) {
		return paymentDatesRepository.save(paymentDates);
	}
	
	public PaymentDates updatePaymentDates(Long paymentDatesId, Long batchId, PaymentDates paymentDates) throws Exception {
		if(batchRepository.existsById(batchId)) {
			paymentDates.setBatch(batchRepository.findById(batchId).get());
			paymentDates.setPaymentDateId(paymentDatesId);
			return paymentDatesRepository.save(paymentDates);
		}
		else {
			throw new Exception("wrong BatchId "+batchId);
		}
	}
		
	public boolean deletePaymentDates(Long PaymentDatesId) {
		try {
			paymentDatesRepository.deleteById(PaymentDatesId);	
			return true;
		} catch (Exception e) {
			return false;
		}		
	}

	public PaymentDates getPaymentDates(Long PaymentDatesId) {
		return paymentDatesRepository.findById(PaymentDatesId).get();  	
	}
	
	public List<PaymentDates> getAllPaymentDates() {
		return paymentDatesRepository.findAll();  
	}	
}




