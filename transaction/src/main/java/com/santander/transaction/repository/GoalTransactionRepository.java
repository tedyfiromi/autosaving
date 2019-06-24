package com.santander.transaction.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.santander.commons.model.GoalHistory;

@Repository
public interface GoalTransactionRepository extends MongoRepository<GoalHistory, String>{
	
	public GoalHistory findByIdGoal(String goal);

}
