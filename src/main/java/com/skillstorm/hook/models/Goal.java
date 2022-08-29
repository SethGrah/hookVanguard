package com.skillstorm.hook.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="GOALS")
@JsonIgnoreProperties(ignoreUnknown=true)

public class Goal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GOAL_ID")
	@Type(type="int")
	@NotNull
	private int id;
	
	@NotBlank
	@Column(name="GOALTITLE")
	private String title;
	
	@NotBlank
	@Column(name="GOALDESC")
	private String description;
	
	@NotBlank
	@Column(name="GOALIMAGE")
	private String imageSrc;
	
	@NotNull
	@Column(name="GOALTARGETDATE")
	private Date targetDate;
	
	@NotNull
	@Column(name="GOALAMOUNT")
	private Double goalAmount;
	
	@NotNull
	@Column(name="GOALCURRAMOUNT")
	private Double currAmount;

	
	
	public Goal() {
		super();
	}
	
	
	
	public Goal(int id, String title, String description, String imageSrc, Date targetDate, Double goalAmount,
			Double currAmount) {
	}

	public Goal(Goal goal) {
		this.id = goal.getId();
		this.title = goal.getTitle();
		this.description = goal.getDescription();
		this.imageSrc = goal.getImageSrc();
		this.targetDate = goal.getTargetDate();
		this.goalAmount = goal.getGoalAmount();
		this.currAmount = goal.getCurrAmount();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public Double getGoalAmount() {
		return goalAmount;
	}

	public void setGoalAmount(Double goalAmount) {
		this.goalAmount = goalAmount;
	}

	public Double getCurrAmount() {
		return currAmount;
	}

	public void setCurrAmount(Double currAmount) {
		this.currAmount = currAmount;
	}



	@Override
	public String toString() {
		return "Goal [id=" + id + ", title=" + title + ", description=" + description + ", imageSrc=" + imageSrc
				+ ", targetDate=" + targetDate + ", goalAmount=" + goalAmount + ", currAmount=" + currAmount + "]";
	}
	
	
	
	
}
