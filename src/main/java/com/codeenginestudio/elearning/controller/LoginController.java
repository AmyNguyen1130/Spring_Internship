package com.codeenginestudio.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("messageDanger", "Your username or password are invalid.");
		}

		if (logout != null) {
			model.addAttribute("messageSuccess", "You have been logged out successfully.");
		}

		return "login";
	}
}
