package com.bway.springproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.daos.StudentDao;
import com.bway.springproject.models.Student;

@Controller
public class StudentController {
	@Autowired
	private StudentDao sdao;

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String getStudentForm(Model model, HttpSession session) 
	{
		if(StringUtils.isEmpty(session.getAttribute("username")))
		{
			return "login";
		}

		model.addAttribute("mstudent", new Student());

		return "studentform";
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute Student s, Model model, HttpSession session) 
	{
		if(StringUtils.isEmpty(session.getAttribute("username")))
		{
			return "login";
		}
		
		sdao.add(s);
		model.addAttribute("slist", sdao.getALL());

		return "home";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, Model model, HttpSession session) 
	{
		if(StringUtils.isEmpty(session.getAttribute("username")))
		{
			return "login";
		}
		
		sdao.delete(id);
		model.addAttribute("slist", sdao.getALL());

		return "home";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, Model model, HttpSession session) 
	{
		if(StringUtils.isEmpty(session.getAttribute("username")))
		{
			return "login";
		}

		model.addAttribute("mstudent", sdao.getById(id));

		return "editForm";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute Student s, Model model, HttpSession session) 
	{
		if(StringUtils.isEmpty(session.getAttribute("username")))
		{
			return "login";
		}
		
		sdao.update(s);
		model.addAttribute("slist", sdao.getALL());

		return "home";
	}

}
