package com.bway.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bway.springproject.daos.StudentDao;
import com.bway.springproject.models.Student;

@RestController
@RequestMapping("api/student")
public class StudentRestController 
{
	@Autowired
	private StudentDao sdao;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudent(Model model)
	{
		ResponseEntity<List<Student>> slist = new ResponseEntity<List<Student>>(sdao.getALL(), HttpStatus.OK);
		
		return slist;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Student> getById(@PathVariable("id") int id)
	{
		ResponseEntity<Student> s = new ResponseEntity<Student>(sdao.getById(id), HttpStatus.OK);
		
		return s;
	}
	
	
	@RequestMapping(value="/currency", method=RequestMethod.GET)
	public ResponseEntity<String> getTodayRate()
	{
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> resp = restTemplate.getForEntity("http://data.fixer.io/api/latest?access_key=3f6c703b7138ec075a735bf14b6ccb04&format=1", String.class);
		
		return resp;
	}

}
