package com.kyrlach.issuetracker.issue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyrlach.issuetracker.login.User;
import com.kyrlach.issuetracker.login.UserRepository;

@Controller
@RequestMapping("/issues")
public class IssueController {
	
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
		model.addAttribute("issueForm", new IssueForm());
		return "newIssue";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String saveIssue(@ModelAttribute IssueForm issueForm, Model model) {
		Issue newIssue = new Issue(issueForm.getTitle(), issueForm.getDescription());
		issueRepository.save(newIssue);
		return "redirect:/issues";
	}
	
	@RequestMapping(value = "/view/{issueId}", method = RequestMethod.GET) 
	public String viewIssue(@PathVariable long issueId, Model model) {
		Issue issue = issueRepository.findOne(issueId);
		model.addAttribute("issue", issue);
		model.addAttribute(new CommentForm(1));
		return "issue";
	}
	
	@RequestMapping(value = "/view/{issueId}", method = RequestMethod.POST)
	public String saveComment(@PathVariable long issueId, @ModelAttribute CommentForm commentForm, Model model) {
		User author = userRepository.findOne(commentForm.getAuthorId());
		Comment comment = new Comment(author, commentForm.getCommentText());
		Issue issue = issueRepository.findOne(issueId);
		List<Comment> comments = issue.getComments();
		comments.add(comment);
		issue.setComments(comments);
		issueRepository.save(issue);
		return "redirect:/issues/view/" + issueId;
	}	
	
}
