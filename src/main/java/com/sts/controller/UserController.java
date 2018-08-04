package com.sts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sts.domain.UserForm;
import com.sts.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/UserRegister",method=RequestMethod.GET)
	public ModelAndView UserRegister()
	{
		return new ModelAndView("UserRegister","user",new UserForm());
	}
	
	@RequestMapping(value="/UserRegister",method=RequestMethod.POST)
	public ModelAndView UserRegisterProcess(@ModelAttribute("user") UserForm user,@RequestParam("file") CommonsMultipartFile file)
	{
		if(!file.isEmpty())
		{
				byte[] bytes=file.getBytes();
				user.setPhoto(bytes);
		}
		userService.userRegister(user);
		return new ModelAndView("UserRegister");
	}
}
