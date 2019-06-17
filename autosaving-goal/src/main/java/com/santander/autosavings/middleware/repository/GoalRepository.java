package com.santander.autosavings.middleware.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.santander.autosavings.middleware.model.Goal;
import com.santander.autosavings.middleware.model.TransactionGoal;

@Repository
public interface GoalRepository extends MongoRepository<Goal, String>{

}
