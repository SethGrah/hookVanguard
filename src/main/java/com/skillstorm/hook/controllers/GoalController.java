package com.skillstorm.hook.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.hook.models.Goal;
import com.skillstorm.hook.services.GoalService;

@RestController
@RequestMapping("/goals")
public class GoalController {

	private static final Logger log = LoggerFactory.getLogger(GoalController.class);
	
	@Autowired
	private GoalService goalService;
	
	@GetMapping(path="/user")
	public ResponseEntity<List<Goal>> findAllByUser(@PathVariable String user){
		List<Goal> goals = this.goalService.findAllByUser(user);
		return ResponseEntity.ok(goals);
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<Goal> findById(@PathVariable Integer id){
		Goal goal = this.goalService.findById(id);
		
		return ResponseEntity.ok(goal);
	}
	
	@PostMapping
	public ResponseEntity<Goal> save(@RequestBody Goal goal){
		return new ResponseEntity<Goal>(this.goalService.add(goal),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Goal> update(@RequestBody Goal goal) {
		Goal searchedGoal = this.goalService.update(goal);
		if (searchedGoal != null) {
			return new ResponseEntity<Goal>(searchedGoal, HttpStatus.OK);
		} else {
			return new ResponseEntity<Goal>(goal, HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteListing(@PathVariable Integer id) {
		this.goalService.deleteGoal(id );
	}
	
}
