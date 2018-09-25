package com.bway.springproject.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GalleryController 
{
	@RequestMapping(value="/gallery", method=RequestMethod.GET)
	public String displayImage(Model model)
	{
		model.addAttribute("imgList", Arrays.asList("04.jpg", "02.jpg", "03.jpg", "005.jpg", "006.jpg", "007.jpg", "008.jpg"));
		
		return "gallery";
	}

}
