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

import com.openarc.student.domain.PaymentHistory;
import com.openarc.student.service.PaymentHistoryService;

@RestController
@RequestMapping
public class PaymentHistoryController {
	@Autowired
	PaymentHistoryService paymentHistoryService;
	
	@PostMapping("/paymentHistory")
	private PaymentHistory createPaymentHistory(@RequestBody PaymentHistory paymentHistory) {
		return paymentHistoryService.savePaymentHistory(paymentHistory) ;
	}
	
	@PutMapping(value="/paymentHistory/{paymentHistoryId}/{studentBatchMappingId}")
	private PaymentHistory updatePaymentHistory(@PathVariable Long paymentHistoryId,@PathVariable Long studentBatchMappingId,@RequestBody PaymentHistory paymentHistory) throws Exception {
		return paymentHistoryService.updatePaymentHistory(paymentHistoryId,studentBatchMappingId, paymentHistory);
	}
	
	@DeleteMapping("/paymentHistory/{paymentHistoryId}")
	private boolean deletePaymentHistory(@PathVariable Long paymentHistoryId) {
		return paymentHistoryService.deletePaymentHistory(paymentHistoryId);	
	}
	@DeleteMapping(value="/paymentHistory/studentBatchMapping/{studentBatchMappingId}")
	private boolean deleteByStudentBatchMapping(@PathVariable Long studentBatchMappingId) {
		return paymentHistoryService.deleteByStudentBatchMapping(studentBatchMappingId);
	}
	
	@GetMapping("/paymentHistory/{paymentHistoryId}")
	private PaymentHistory getPaymentHistory(@PathVariable Long paymentHistoryId) {
		return paymentHistoryService.getPaymentHistory(paymentHistoryId);
	}
	
	@GetMapping(value="/paymentHistories")
	private List<PaymentHistory> getPaymentHistories(){
		return paymentHistoryService.getAllPaymentHistory();
	}

	@GetMapping(value = "/paymentHistory/studentBatchMapping/{studentBatchMappingId}")
	private List<PaymentHistory> getPaymentHistoriesByStudentBatchMapping(@PathVariable Long studentBatchMappingId){
		return paymentHistoryService.selectByStudentBatchMapping(studentBatchMappingId);	
	}
}
