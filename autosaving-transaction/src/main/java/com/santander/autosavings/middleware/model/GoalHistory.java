package com.santander.autosavings.middleware.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class GoalHistory implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	public String idHistoryGoal;
	public double value;
		
	
	public GoalHistory() {		
	}

	public GoalHistory(String idHistoryGoal, double value) {
		super();
		this.idHistoryGoal = idHistoryGoal;
		this.value = value;

	}
	
	public String getIdHistoryGoal() {
		return idHistoryGoal;
	}

	public void setIdHistoryGoal(String idHistoryGoal) {
		this.idHistoryGoal = idHistoryGoal;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}	

}
