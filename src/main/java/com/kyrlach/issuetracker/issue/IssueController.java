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
import com.kyrlach.issuetracker.login.User;
import com.kyrlach.issuetracker.login.UserRepository;


@Controller
@RequestMapping("/issues")
public class IssueController {
	private static Logger logger = LogManager.getLogger(IssueController.class);

	@Autowired
	private IssueRepository issueRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method = RequestMethod.GET)
    public String issues(Model model) {
    	model.addAttribute("issues", issueRepository.findAll());
    	return "issueList";
    }
	
	@RequestMapping(value = "/new", method = RequestMethod.GET) 
	public String newIssue(Model model) {
		model.addAttribute("userList", userRepository.findAll());
		model.addAttribute("issueForm", new IssueForm());
		return "newIssue";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String saveIssue(@ModelAttribute IssueForm issueForm, Model model) {
		User assignee = userRepository.findOne(issueForm.getAssignedTo());
		Issue newIssue = new Issue(issueForm.getTitle(), issueForm.getDescription(), issueForm.getCategory(), issueForm.getDifficulty(), assignee);
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
		List<String> categoriesA = searchTerms.getCategories();
		logger.info(categoriesA);
		if (categoriesA == null){
			categoriesA = new ArrayList<String>();
		    categoriesA.add("Feature");
		    categoriesA.add("Problem");
		    categoriesA.add("Enhancement");
		}
		List<Float> difficultiesB = searchTerms.getDifficulties();
		logger.info(difficultiesB);
		if(difficultiesB == null) {
		  difficultiesB = new ArrayList<Float>();
		  difficultiesB.add(0f);
		  difficultiesB.add(0.5f);
		  difficultiesB.add(1f);
		  difficultiesB.add(2f);
		  difficultiesB.add(3f);
		  difficultiesB.add(5f);
		  difficultiesB.add(8f);
		  difficultiesB.add(13f);
		  difficultiesB.add(20f);
		  difficultiesB.add(40f);
		  difficultiesB.add(100f);
		 }		
		logger.info(categoriesA);
		logger.info(difficultiesB);
		List<Issue> searchResults = issueRepository.findByTitleLikeAndDescriptionLikeAndCategoryInAndDifficultyIn("%" + searchTerms.getTitle() + "%","%" + searchTerms.getDescription() + "%", categoriesA, difficultiesB);
		model.addAttribute("issues", searchResults);
		logger.info(searchResults);
		return "issueList";	
	}

}
