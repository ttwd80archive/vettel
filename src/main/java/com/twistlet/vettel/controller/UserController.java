package com.twistlet.vettel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.twistlet.vettel.model.service.UserService;

@Controller
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("user/index")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("user/index");
		mav.addObject("users", userService.listPerson());
		return mav;
	}
}
