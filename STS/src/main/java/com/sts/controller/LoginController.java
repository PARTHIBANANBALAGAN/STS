package com.sts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sts.domain.UserForm;
import com.sts.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView LoginPage()
	{
		return new ModelAndView("Login","login",new UserForm());
	}
	
	@RequestMapping(value="/Login",method=RequestMethod.POST)
	public ModelAndView LoginProcess(@ModelAttribute("login") UserForm userForm,Model map)
	{
		boolean status=loginService.isValidate(userForm);
		if(status==true)
		{
			map.addAttribute("status","Login Successfully.");
			return new ModelAndView("UserRegister");
		}
		else
		{
			map.addAttribute("status","User Name or Password Invalid.");
			return new ModelAndView("Login");
		}
		
	}
}
