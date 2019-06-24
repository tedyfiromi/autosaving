package com.santander.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.commons.model.Schedule;
import com.santander.schedule.repository.ScheduleRepository;

@Service
public class ScheduleService {

	
	@Autowired
	private ScheduleRepository repository;
	
	public List<Schedule> getAll() {
		return repository.findAll();
	}
	
}
