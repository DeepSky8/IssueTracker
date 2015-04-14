package com.kyrlach.issuetracker.issue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyrlach.issuetracker.login.LoginController;
import com.kyrlach.issuetracker.login.LoginForm;
import com.kyrlach.issuetracker.login.User;

@Controller
@RequestMapping("/issues")
public class IssueController {
	private static Logger logger = LogManager.getLogger(IssueController.class);

	@Autowired
	private IssueRepository issueRepository;
	
	@RequestMapping(method = RequestMethod.GET)
    public String issues(Model model) {
    	model.addAttribute("issues", issueRepository.findAll());
    	return "issueList";
    }
	
	@RequestMapping(value = "/new", method = RequestMethod.GET) 
	public String newIssue(Model model) {
		model.addAttribute("issueForm", new IssueForm());
		return "newIssue";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String saveIssue(@ModelAttribute IssueForm issueForm, Model model) {
		Issue newIssue = new Issue(issueForm.getTitle(), issueForm.getDescription(), issueForm.getCategory(), issueForm.getDifficulty());
		issueRepository.save(newIssue);
		return "redirect:/issues";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET) 
	public String newSearch(Model model) {
		model.addAttribute("searchTerms", new IssueSearchForm());
		return "issueSearch";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String submittedData(@ModelAttribute IssueSearchForm searchTerms, Model model)	{
		logger.info(searchTerms);
		List<Issue> searchResults = issueRepository.findByTitleLikeAndDescriptionLikeAndCategoryLikeAndDifficultyIn("%" + searchTerms.getTitle() + "%", "%" + searchTerms.getDescription() + "%", "%" + searchTerms.getCategory() + "%", searchTerms.getDifficulties());
		logger.info(searchResults);
		model.addAttribute("issues", searchResults);
		return "issueList";	
	}

}