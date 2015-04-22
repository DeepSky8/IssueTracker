package com.kyrlach.issuetracker.issue;

import java.util.ArrayList;
import java.util.List;

public class IssueSearchForm {
	private String title;
	private String description;
	private List<String> categories;
	private List<Float> difficulties;
	
	public IssueSearchForm () {
		this.title = null;
		this.description = null;
		this.categories = new ArrayList<String>();
		this.difficulties = new ArrayList<Float>();
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

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<Float> getDifficulties() {
		return difficulties;
	}

	public void setDifficulties(List<Float> difficulties) {
		this.difficulties = difficulties;
	}
	

	@Override
    public String toString() {
    	return "IssueSearchForm("+title+","+description+","+categories+","+difficulties+")";
	}
}
