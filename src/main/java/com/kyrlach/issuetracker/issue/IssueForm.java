package com.kyrlach.issuetracker.issue;

public class IssueForm {
	private String title;
	private String description;
	private Number difficulty;

	public IssueForm () {
		this.title = null;
		this.description = null;
		this.difficulty = 1;
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
	

}