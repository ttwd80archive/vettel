package com.twistlet.vettel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	@RequestMapping("/error")
	public String error(final HttpServletRequest request, final Model model) {
		model.addAttribute("errorCode", request.getAttribute("javax.servlet.error.status_code"));
		final Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		String errorMessage = null;
		if (throwable != null) {
			errorMessage = throwable.getMessage();
		}
		model.addAttribute("errorMessage", errorMessage.toString());
		return "error.html";
	}

}
