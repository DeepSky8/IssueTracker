package com.kyrlach.issuetracker.issue;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String title;
    private String description;
    
    @OneToMany
    @Cascade({CascadeType.ALL})
    private List<Comment> comments;
    
    public Issue() {}
    
    public Issue(String title, String description) {
    	this.title = title;
    	this.description = description;
    	this.comments = new ArrayList<Comment>();
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
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
    public String toString() {
    	return "Issue("+id+","+title+","+description+")";
    }
}