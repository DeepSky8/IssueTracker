package com.kyrlach.issuetracker.issue;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.kyrlach.issuetracker.issue.Stage;


public interface IssueRepository extends CrudRepository<Issue, Long> {
		
	List<Issue> findByTitleLikeAndDescriptionLikeAndCategoryInAndDifficultyInAndStageIn(String title, String description, List<String> categories, List<Float> difficulties, List<Stage> stage);

}
