package com.twistlet.vettel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login-error")
	public String loginError(final Model model, final HttpSession session) {
		model.addAttribute("loginError", true);
		return "login";
	}
}
