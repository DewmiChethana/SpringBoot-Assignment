package com.openarc.student.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="PaymentHistory")
public class PaymentHistory {
	
	@Id
	@GeneratedValue
	@Column(name="paymentHistoryId")
	private long paymentHistoryId;
	private String installmentNo;
	private Date paidDate;
	private String invoiceNo;
	@ManyToOne
	@JoinColumn(name="studentBatchMappingId",nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private StudentBatchMapping studentBatchMapping;
	
	public StudentBatchMapping getStudentBatchMapping() {
		return studentBatchMapping;
	}

	public void setStudentBatchMapping(StudentBatchMapping studentBatchMapping) {
		this.studentBatchMapping = studentBatchMapping;
	}

	public long getPaymentHistoryId() {
		return paymentHistoryId;
	}
	
	public void setPaymentHistoryId(long paymentHistoryID) {
		this.paymentHistoryId = paymentHistoryID;
	}
		
	public String getInstallmentNo() {
		return installmentNo;
	}
	
	public void setInstallmentNo(String installmentNo) {
		this.installmentNo = installmentNo;
	}
	
	public Date getPaidDate() {
		return paidDate;
	}
	
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	
	public String getInvoiceNo() {
		return invoiceNo;
	}
	
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}	
}
