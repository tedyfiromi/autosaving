package com.santander.commons.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GoalHistory implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String idGoal;	
	
	@DBRef
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	public GoalHistory(String idGoal, List<Transaction> transactions) {
		super();
		this.idGoal = idGoal;
		this.transactions = transactions;
	}

	public String getIdGoal() {
		return idGoal;
	}

	public void setIdGoal(String idGoal) {
		this.idGoal = idGoal;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}	
	

}
