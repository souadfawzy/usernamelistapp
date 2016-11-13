package com.usernamelist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.usernamelist.delegate.LoginDelegate;
import com.usernamelist.viewBean.LoginBean;

@Controller
public class LoginController {
	@Autowired
	private LoginDelegate loginDelegate;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean) {
		ModelAndView model = new ModelAndView("login");
		// LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}

	@RequestMapping(value = "/restricted", method = RequestMethod.GET)
	public ModelAndView displayrestricted(HttpServletRequest request, HttpServletResponse response,
			LoginBean loginBean) {
		ModelAndView model = new ModelAndView("restricted");
		// LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginBean") LoginBean loginBean) {
		ModelAndView model = new ModelAndView("login");
		String username = loginBean.getUsername();
		try {
			if (loginBean.getUsername().length() < 6) {
//				model = new ModelAndView("login");
				request.setAttribute("message", "username must be at least 6 character!!");
				loginBean.setSugesstedNames(null);
				return model;
			}

			boolean restricted = loginDelegate.checkIfUserResricted(username);
			if (restricted) {
				request.setAttribute("message", username+" is restricted username!!");
				loginBean.setSugesstedNames(loginDelegate.generateAlternatUserNames(username));
				loginBean.setUsername(username);
				return model;
			}
			boolean exist = loginDelegate.checkIfUserExist(username);
			if (exist) {
				request.setAttribute("message", username+" username already exists!!");
				loginBean.setSugesstedNames(loginDelegate.generateAlternatUserNames(username));
				return model;
			}
			request.setAttribute("message","Welcome "+ username+" is valid username");
			loginBean.setSugesstedNames(null);


		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}

	@RequestMapping(value = "/restricted", method = RequestMethod.POST)
	public ModelAndView executeRestricted(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginBean") LoginBean loginBean) {
		ModelAndView model = new ModelAndView("restricted");
		;
		String username = loginBean.getUsername();
		System.err.println("executeRestricted");
		try {
			if (loginBean.getUsername().length() < 6) {
				request.setAttribute("message", "username must be at least 6 character!!");

			}

			boolean restricted = loginDelegate.checkIfUserResricted(username);
			if (restricted) {
				request.setAttribute("message", "username is already in restricted list!!");

			} else {
				 loginDelegate.addToResticted(username);
				request.setAttribute("message", "username added successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}
}
