package com.santander.autosavings.middleware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santander.autosavings.middleware.model.Goal;
import com.santander.autosavings.middleware.response.Response;
import com.santander.autosavings.middleware.service.GoalService;
import com.santander.autosavings.middleware.utils.UrlRest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(UrlRest.GOAL)
@Api(value = "Goal Managemment")
public class GoalController {

	@Autowired
	public GoalService goalService;

	@ApiOperation(value = "Get List of Goals", response = String.class, notes = "This operation return the list of all goals")
	@GetMapping(value = UrlRest.LIST)
	public ResponseEntity<List<Goal>> getListGoals() {
		return ResponseEntity.ok(goalService.getListAllGoals());
	}

	@ApiOperation(value = "Gel Goal By Id", response = String.class, notes = "This operation show a goal by id")
	@GetMapping(value = UrlRest.FIND_BY_ID)
	public ResponseEntity<Goal> getGoalById(@PathVariable("id") String idGoal) {
		return ResponseEntity.ok(goalService.findGoalById(idGoal));
	}	
	
	@ApiOperation(value = "Insert Goal", response = String.class, notes = "This operation be insert a new goal")
	@PostMapping(value = UrlRest.INSERT)
	public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
		return ResponseEntity.ok(goalService.insertGoal(goal));
	}

	@ApiOperation(value = "Update Goal", response = String.class, notes = "This operation update a goal")
	@PutMapping(value = UrlRest.UPDATE)
	public ResponseEntity<Goal> updateGoal(@RequestBody Goal goal) {
		return ResponseEntity.ok(goalService.updateGoal(goal));
	}

}
