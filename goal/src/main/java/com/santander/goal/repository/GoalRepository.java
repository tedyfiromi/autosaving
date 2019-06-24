package com.santander.goal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.santander.commons.model.Goal;

@Repository
public interface GoalRepository extends MongoRepository<Goal, String>{

}
