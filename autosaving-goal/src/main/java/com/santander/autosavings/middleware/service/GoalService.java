package com.santander.autosavings.middleware.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.autosavings.middleware.model.Goal;
import com.santander.autosavings.middleware.repository.GoalRepository;
import com.santander.autosavings.middleware.service.exception.ObjectNotFoundException;

@Service
public class GoalService {
	
	@Autowired
	public GoalRepository goalRepository;
	
	public List<Goal> getListAllGoals() {
		return goalRepository.findAll();
	}
	
	public Goal insertGoal(Goal goal) {
		if(goal.getCreatedAt()==null) {
			goal.setCreatedAt(LocalDateTime.now());
		}		
		return goalRepository.insert(goal);
	}
	
	public Goal updateGoal(Goal goal) {
		return goalRepository.save(goal);
	}	
	
	public Goal saveGoal(Goal goal) {
		return goalRepository.save(goal);
	}
	
	public Goal findGoalById(String idGoal) {
		return goalRepository.findById(idGoal).orElseThrow(() -> new ObjectNotFoundException(idGoal));
	}
	
}
