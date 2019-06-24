package com.santander.schedule.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.santander.commons.model.Schedule;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String>{

}
