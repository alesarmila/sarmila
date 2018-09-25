package com.bway.springproject.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.HomeController;
import com.bway.springproject.daos.StudentDao;
import com.bway.springproject.daos.UserDao;
import com.bway.springproject.models.User;

@Controller
public class LoginController 
{
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	@Autowired
	private UserDao udao;
	
	@Autowired
	private StudentDao sdao;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginForm()
	{
		logger.info("inside login page method");
		
		return "login";
	}
	
	@RequestMapping (value="/login", method=RequestMethod.POST)
	public String isExist(@ModelAttribute User user, Model model, HttpServletRequest req, HttpSession session) throws IOException
	{
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		
		String input = req.getParameter("g-recaptcha-response");
		boolean verify = VerifyRecaptcha.verify(input);
		
		if(verify) {
		
			if(udao.login(user.getUsername(), user.getPassword()))
			{
				logger.info("Login success!");
				
				session.setAttribute("username", user.getUsername());
				session.setMaxInactiveInterval(10 * 60);
				
				model.addAttribute("user", user.getUsername());
				model.addAttribute("slist", sdao.getALL());
				return "home";
			}
			else 
			{
				logger.info("Login fail!");
				
				model.addAttribute("error", "user does not exist!");
				return "login";
			}
		}
		
		logger.info("Login fail!");
		
		model.addAttribute("error", "you are not human!");
		return "login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session)
	{
		logger.info("User logout seccess");
		session.invalidate();
		
		return "login";
	}
	

	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public String fbLogin(){
		
		//String secret_key = "c85c3bbaeded9ce1ea6af891cc8733c2";
		//String app_id = "2187484124842729";
		
		return "redirect:https://www.facebook.com/dialog/oauth?client_id=2187484124842729&redirect_uri=http://localhost:8081/springproject/authorize/facebook&response_type=code&scope=email";
	}
	
	
	
	@RequestMapping(value = "/authorize/facebook", method = RequestMethod.GET)
	public String saveFbUser(String code, Model model, HttpServletRequest request){
		
		model.addAttribute("slist", sdao.getALL());
		
	      return "home";
	      
	      
	      
	      }
	      
	
	

}
