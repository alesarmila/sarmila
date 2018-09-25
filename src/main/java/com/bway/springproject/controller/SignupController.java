package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.daos.UserDao;
import com.bway.springproject.models.User;

@Controller
public class SignupController 
{
	@Autowired
	private UserDao udao;
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String getSignupForm()
	{
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String userSignup(@ModelAttribute User user, Model model)
	{
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		
		udao.signup(user);
		
		return "login";
	}
	

}
