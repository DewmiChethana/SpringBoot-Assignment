package com.openarc.student.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="PaymentDates")
public class PaymentDates {
	
	@Id
	@GeneratedValue
	private long paymentDateId;
	@CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
	private Date paymentDate;
	@ManyToOne
	@JoinColumn(name="batchId",nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Batch batch;
	
	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public long getPaymentDateId() {
		return paymentDateId;
	}
	
	public void setPaymentDateId(long paymentDateId) {
		this.paymentDateId = paymentDateId;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}
	
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}	
}
