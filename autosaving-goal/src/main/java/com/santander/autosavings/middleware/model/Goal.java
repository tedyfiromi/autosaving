package com.santander.autosavings.middleware.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="goal")
public class Goal implements Serializable{
	
	private static final long serialVersionUID = -839854161900593105L;
	@Id
	private String id;		
	private String title;
	private double total;
	private double saved;
	private double recurrence;
	private boolean active = true;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss")
	private LocalDateTime createdAt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd HH:mm:ss")
	private LocalDateTime updatedAt;	
	
	@DBRef
	private List<TransactionGoal> transactionGoals = new ArrayList<>();
	
	public Goal(String id, String title, double total, double saved, double recurrence, LocalDateTime createdAt,
			LocalDateTime updatedAt, List<TransactionGoal> transactionGoals) {
		super();
		this.id = id;
		this.title = title;
		this.total = total;
		this.saved = saved;
		this.recurrence = recurrence;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.transactionGoals = transactionGoals;
	}

	public Goal() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getSaved() {
		return saved;
	}

	public void setSaved(double saved) {
		this.saved = saved;
	}

	public double getRecurrence() {
		return recurrence;
	}

	public void setRecurrence(double recurrence) {
		this.recurrence = recurrence;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<TransactionGoal> getTransactionGoals() {
		return transactionGoals;
	}

	public void setTransactionGoal(List<TransactionGoal> transactionGoals) {
		this.transactionGoals = transactionGoals;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setTransactionGoals(List<TransactionGoal> transactionGoals) {
		this.transactionGoals = transactionGoals;
	}
	
}
