package com.skillstorm.hook.data;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skillstorm.hook.models.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal,Integer> {
	
	//public List<Goal> findAllGoals();
	
	@Query("from Goals g where g.goalId like CONCAT('%',:id,'%')")
	public Goal findGoalById(@Param(value="id") Integer id);

}
