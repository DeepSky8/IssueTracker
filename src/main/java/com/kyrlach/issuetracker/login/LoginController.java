package com.kyrlach.issuetracker.login;

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
import org.thymeleaf.expression.Strings;

@Controller
@RequestMapping("/")
public class LoginController {
	
	private static Logger logger = LogManager.getLogger(LoginController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@ModelAttribute LoginForm loginForm, Model model) {
			User credentailCheck = new User(loginForm.getUsername(), loginForm.getPassword());
			logger.info(loginForm);
			User user = userRepository.findByUsername(credentailCheck.getUsername());
			logger.info(user);
			if(user == null) {
				List<String> errors = new ArrayList<String>();
				errors.add("Wrong username/password");
				model.addAttribute("errors", errors);
				return "login";
			} else {
				if(user.getPassword().equals(credentailCheck.getPassword())) {
					return "redirect:/issues";
				} else {
					List<String> errors = new ArrayList<String>();
					errors.add("Wrong username/password");
					model.addAttribute("errors", errors);
					return "login";
				}
			}
	}}
