package com.santander.commons.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Transaction {
	
	@Id
	private String id;
	private double value;
	
	public Transaction(String id, double value) {
		super();
		this.id = id;
		this.value = value;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}	

}
