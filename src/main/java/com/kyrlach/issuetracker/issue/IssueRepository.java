package com.kyrlach.issuetracker.issue;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IssueRepository extends CrudRepository<Issue, Long> {
		
	List<Issue> findByTitleLikeAndDescriptionLikeAndCategoryLikeAndDifficultyIn(String title, String description, String Category, List<Integer> difficulties);
	
}
