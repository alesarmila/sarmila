package com.bway.springproject.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/upload")
public class FileUploadController 
{
	@RequestMapping(method=RequestMethod.GET)
	public String uploadImage()
	{
		return "fileUpload";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file, Model model) throws IOException
	{
		
		if(!file.isEmpty())
		{
			FileOutputStream out = new FileOutputStream("F:\\JavaPackage\\springproject\\src\\main\\webapp\\resources\\imgs\\"+file.getOriginalFilename());
			out.write(file.getBytes());
			
			out.close();
		}
		
		model.addAttribute("msg", "File upload success!");
		return"fileUpload";
	}

}
