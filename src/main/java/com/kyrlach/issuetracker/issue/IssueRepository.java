package com.kyrlach.issuetracker.issue;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IssueRepository extends CrudRepository<Issue, Long> {
		
	List<Issue> findByTitleLikeAndDifficultyIn(String title, List<Integer> difficulties);
	
}
