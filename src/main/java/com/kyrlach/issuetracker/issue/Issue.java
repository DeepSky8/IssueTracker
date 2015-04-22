package com.kyrlach.issuetracker.issue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.kyrlach.issuetracker.login.User;

@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private String category;
    private float difficulty;
    @ManyToOne
    private User assignedTo;
    
	public Issue() {}
    
    public Issue(String title, String description, String category, float difficulty, User assignedTo) {
    	this.title = title;
    	this.description = description;
    	this.category= category;
    	this.assignedTo = assignedTo;
    	this.difficulty = difficulty;
    }

	public long getId() {
		return id;
	}
	public void setId(long id) {
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

    public String getCategory() {
		return category;
    }
        
	public float getDifficulty() {
		return difficulty;
	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDifficulty(float difficulty) {
		this.difficulty = difficulty;
	}
	
	public User getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	@Override
    public String toString() {
    	return "Issue("+id+","+title+","+description+","+category+","+difficulty+","+assignedTo+")";
    }

}