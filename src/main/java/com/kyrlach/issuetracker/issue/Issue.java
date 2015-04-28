package com.kyrlach.issuetracker.issue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.kyrlach.issuetracker.login.User;
import com.kyrlach.issuetracker.issue.Stage;


@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private String category;
    private float difficulty;
	private Stage stage;
    @ManyToOne
    private User assignedTo;

    
	public Issue() {}
    
    public Issue(String title, String description, String category, float difficulty, User assignedTo, Stage stage) {
    	this.title = title;
    	this.description = description;
    	this.category= category;
    	this.assignedTo = assignedTo;
    	this.difficulty = difficulty;
    	this.stage = stage;
    	}
    
    public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

    public class Process {
    	Stage stage;
    }
    
      public void Process(Stage stage) {
    	  this.stage = stage;
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
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
    public String toString() {
    	return "Issue("+id+","+title+","+description+","+category+","+difficulty+","+assignedTo+","+stage+")";
    }

}