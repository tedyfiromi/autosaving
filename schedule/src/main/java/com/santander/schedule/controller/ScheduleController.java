package com.santander.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.commons.model.Goal;
import com.santander.commons.model.Schedule;
import com.santander.commons.utils.UrlRest;
import com.santander.schedule.service.ScheduleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(UrlRest.SCHEDULE)
@Api(value = "Schedule Management")
public class ScheduleController {

	@Autowired
	private ScheduleService service;
	
	@ApiOperation(value = "Get List of Schedules", response = String.class, notes = "This operation return the list of all schedules")
	@GetMapping(value = UrlRest.LIST)
	public ResponseEntity<List<Schedule>> getListGoals() {
		return ResponseEntity.ok(service.getAll());
	}
	
}
