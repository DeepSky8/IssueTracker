package com.kyrlach.issuetracker.login;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {
	
	private static Logger logger = LogManager.getLogger(LoginController.class);
			
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@ModelAttribute LoginForm loginForm, Model model) {
		logger.info(loginForm);
		return "login";
	}
}
