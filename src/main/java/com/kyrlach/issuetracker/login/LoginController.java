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
        String retval = "login";
		logger.info(loginForm);
		User user = userRepository.findByUsername(loginForm.getUsername());
		logger.info(user);
		if(user != null && user.getPassword().equals(loginForm.getPassword())) {
			retval = "redirect:/issues";
		} else {
			List<String> errors = new ArrayList<String>();
			errors.add("Wrong username/password");
			model.addAttribute("errors", errors);
		}
		return retval;
	}}
