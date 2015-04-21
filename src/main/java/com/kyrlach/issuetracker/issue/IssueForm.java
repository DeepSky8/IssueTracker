package com.kyrlach.issuetracker.issue;

public class IssueForm {
	private String title;
	private String description;
	private String category;
	private int assignedTo;
	private Integer difficulty;

	public IssueForm () {
		this.title = null;
		this.description = null;
		this.category = null;
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
	public int getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
	

}