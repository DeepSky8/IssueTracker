package com.kyrlach.issuetracker.issue;

import java.util.ArrayList;
import java.util.List;

public class IssueSearchForm {
	private String title;
	private String description;
	private String category;
	private List<Integer> difficulties;
	
	public IssueSearchForm () {
		this.title = null;
		this.description = null;
		this.category = null;
		this.difficulties = new ArrayList<Integer>();
		this.difficulties.add(1);
		this.difficulties.add(5);
		this.difficulties.add(9);
		this.difficulties.add(15);
		this.difficulties.add(20);
		this.difficulties.add(27);
		this.difficulties.add(35);
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

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Integer> getDifficulties() {
		return difficulties;
	}

	public void setDifficulties(List<Integer> difficulties) {
		this.difficulties = difficulties;
	}
	

	@Override
    public String toString() {
    	return "IssueSearchForm("+title+","+description+","+category+","+difficulties+")";
	}
}
