package com.santander.autosavings.middleware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.autosavings.middleware.domain.Goal;
import com.santander.autosavings.middleware.repository.GoalRepository;

@Service
public class GoalService {
	
	@Autowired
	public GoalRepository repository;
	
	public List<Goal> getListAllGoals() {
		return new Goal(repository).findAll();
	}

	public Goal saveGoal(Goal goal) {
		return new Goal(repository).save(goal);
	}
	
	public Goal findGoalById(String idGoal) {
		return new Goal(repository).findById(idGoal);
	}

}
