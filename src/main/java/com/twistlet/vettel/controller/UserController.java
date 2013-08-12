package com.twistlet.vettel.controller;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.twistlet.vettel.model.entity.Person;
import com.twistlet.vettel.model.security.service.PasswordHashService;
import com.twistlet.vettel.model.service.UserService;

@Controller
public class UserController {

	private final UserService userService;
	private final PasswordHashService passwordHashService;

	@Autowired
	public UserController(final UserService userService, final PasswordHashService passwordHashService) {
		this.userService = userService;
		this.passwordHashService = passwordHashService;
	}

	@RequestMapping("user/index")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("user/index");
		mav.addObject("users", userService.listPerson());
		return mav;
	}

	@RequestMapping("user/new")
	public ModelAndView blank() {
		final UserForm userForm = new UserForm();
		final ModelAndView mav = new ModelAndView("/user/new");
		mav.addObject("user", userForm);
		return mav;
	}

	@RequestMapping("user/create")
	public ModelAndView create(@ModelAttribute("user") final UserForm userForm, final BindingResult result) {
		new UserFormCreateValidator().validate(userForm, result);
		if (result.hasErrors()) {
			return new ModelAndView("/user/new", "user", userForm);
		}
		final Person person = new Person();
		person.setUsername(userForm.getUsername());
		person.setPassword(passwordHashService.hash(userForm.getPassword()));
		final Integer enabled = BooleanUtils.toInteger(userForm.isEnabled(), 1, 0);
		person.setEnabled(enabled.byteValue());
		person.setName(userForm.getName());
		try {
			userService.save(person);
		} catch (final Exception e) {
			e.printStackTrace();
			result.reject("data.error");
			return new ModelAndView("/user/new", "user", userForm);
		}
		return new ModelAndView("redirect:/user/created");
	}

	@RequestMapping("user/created")
	public String created() {
		return "created";
	}
}
