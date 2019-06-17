package com.santander.autosavings.middleware.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santander.autosavings.middleware.repository.GoalRepository;
import com.santander.autosavings.middleware.service.exception.ObjectNotFoundException;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Document
@Getter @Setter
public class Goal implements Serializable{

	private static final long serialVersionUID = -839854161900593105L;
	@Id
	private String id;
	@DBRef
	private User user;
	private String title;
	private double total;
	private double saved;
	private double recorrence;
	private boolean active;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy@HH:mm:ss")
	private LocalDateTime createdAt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy@HH:mm:ss")
	private LocalDateTime updatedAt;
	@DBRef
	private List<TransactionGoal> transactionGoals = new ArrayList<>();
	@Getter(value = AccessLevel.NONE) @Setter(value = AccessLevel.NONE)
	private GoalRepository repository;

	public Goal(final GoalRepository repository) {
		this.repository = repository;
	}

	public Goal() {}
	
	public Goal save(Goal goal) {
		return repository.save(goal);
	}
	
	public Goal findById(String idGoal) {
		return repository.findById(idGoal).orElseThrow(() -> new ObjectNotFoundException(idGoal));
	}
	
	public List<Goal> findAll() {
		return repository.findAll();
	}

	
	
}
