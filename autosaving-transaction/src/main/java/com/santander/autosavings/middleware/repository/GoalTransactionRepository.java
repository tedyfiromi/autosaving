package com.santander.autosavings.middleware.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.santander.autosavings.middleware.model.GoalHistory;

@Repository
public interface GoalTransactionRepository extends MongoRepository<GoalHistory, String>{

}
