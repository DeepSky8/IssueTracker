package com.kyrlach.issuetracker.issue;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IssueRepository extends CrudRepository<Issue, Long> {
		
	List<Issue> findByTitleLikeAndDescriptionLikeAndCategoryInAndDifficultyIn(String title, String description, List<String> categories, List<Integer> difficulties);

}
