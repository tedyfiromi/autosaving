package com.santander.commons.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TransactionGoal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	public String idTransactionGoal;
	public double value;
		
	
	public TransactionGoal() {		
	}

	public TransactionGoal(String idTransaction, double value) {
		super();
		this.idTransactionGoal = idTransaction;
		this.value = value;

	}
	
	public String getIdTransactionGoal() {
		return idTransactionGoal;
	}

	public void setIdTransactionGoal(String idTransactionGoal) {
		this.idTransactionGoal = idTransactionGoal;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}	

}
