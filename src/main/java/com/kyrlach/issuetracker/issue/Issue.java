package com.kyrlach.issuetracker.issue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String title;
    private String description;
    private Number difficulty;
    
    public Issue() {}
    
    public Issue(String title, String description, Number difficulty) {
    	this.title = title;
    	this.description = description;
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

	public Number getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Number difficulty) {
		this.difficulty = difficulty;
	}
	
	@Override
    public String toString() {
    	return "Issue("+id+","+title+","+description+","+difficulty+")";
    }
}