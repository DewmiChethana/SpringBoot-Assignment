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

import com.openarc.student.domain.PaymentDates;
import com.openarc.student.service.PaymentDatesService;

@RestController
@RequestMapping
public class PaymentDatesController {
	@Autowired
	PaymentDatesService paymentDatesService;
	
	@PostMapping("/paymentdates")
	private PaymentDates savePaymentDates(@RequestBody PaymentDates paymentDates) {
		return paymentDatesService.savePaymentDates(paymentDates);
	}
	
	@PutMapping(value="/paymentdates/{paymentdatesId}/{/batchId}")
	private PaymentDates updatePaymentDates(@PathVariable Long paymentDatesId,@PathVariable Long batchId,@RequestBody PaymentDates paymentDates) throws Exception {
		return paymentDatesService.updatePaymentDates(paymentDatesId,batchId, paymentDates);
	}
	
	@DeleteMapping(value="/paymentdates/{paymentdatesId}")
	private boolean deletePaymentDates(@PathVariable Long paymentDatesId) {
		return paymentDatesService.deletePaymentDates(paymentDatesId);
		
	}
	
	@DeleteMapping(value="/paymentdate/batch/{batchId}")
	private boolean deleteByBatch(@PathVariable Long batchId) {
		return paymentDatesService.deleteByBatch(batchId);
	}
	
	@GetMapping("/paymentdates/{paymentdatesId}")
	private PaymentDates getPaymentdates(@PathVariable Long paymentdatesId) {
		return paymentDatesService.getPaymentDates(paymentdatesId);
	}
	
	@GetMapping(value="/paymentdates")
	private List<PaymentDates> getPaymentDates(){
		return paymentDatesService.getAllPaymentDates();
	}
	
	@GetMapping(value = "/paymentdates/batch/{batchId}")
	private List<PaymentDates> getPaymentDatesByBatch(@PathVariable Long batchId){
		return paymentDatesService.selectByBatch(batchId);	
	}
}
