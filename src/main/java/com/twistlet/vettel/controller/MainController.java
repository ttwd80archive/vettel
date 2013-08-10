package com.twistlet.vettel.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.twistlet.vettel.model.security.service.SecurityContextService;

public class MainController extends AbstractController {
	private final SecurityContextService securityContextService;
	private final Map<String, String> map;

	public MainController(final SecurityContextService securityContextService, final Map<String, String> map) {
		this.securityContextService = securityContextService;
		this.map = map;
	}

	@Override
	protected ModelAndView handleRequestInternal(final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		final List<GrantedAuthority> list = securityContextService.getAuthorities();
		for (final GrantedAuthority authority : list) {
			final String key = authority.getAuthority();
			final String value = map.get(key);
			if (value != null) {
				return new ModelAndView(value);
			}
		}
		return null;
	}

}
