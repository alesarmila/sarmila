package com.bway.springproject.daos;

import java.util.List;

import com.bway.springproject.models.Student;

public interface StudentDao 
{
	void add(Student s);
	void delete(int id);
	void update(Student s);
	Student getById(int id);
	List<Student> getALL();

}
