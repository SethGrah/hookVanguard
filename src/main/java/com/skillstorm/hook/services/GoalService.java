package com.skillstorm.hook.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.hook.data.GoalRepository;
import com.skillstorm.hook.models.Goal;

@Service
public class GoalService {

	private static final Logger log = LoggerFactory.getLogger(GoalService.class);
	
	@Autowired
	private GoalRepository goalRepository;
	
	public List<Goal> findAllByUser(String user){
		log.debug("List<Goal> findAllByUser(user)");
		return this.goalRepository.findAllByUser(user);
	}
	
	
	public Goal findById(Integer id) {
		Goal goal = this.goalRepository.findGoalById(id);
		return goal;
	}
	// public Page<Goal> findBySearch(String search, Page pageable){}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Goal add(Goal goal) {
		Goal dbGoal = goalRepository.save(goal);
		return new Goal(dbGoal);
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Goal update(Goal goal) {
		Optional<Goal> searchedGoal = goalRepository.findById(goal.getId());
		return searchedGoal.isPresent() ? goalRepository.save(goal) : null;
	}
	public void deleteGoal(Integer id) {
		Optional<Goal> searchedGoal = goalRepository.findById(id);
		if (searchedGoal.isPresent()) {
			goalRepository.deleteById(id);
		} else {
			System.out.println("No Listing Present at ID Provided.");
		}
	}
	
}
