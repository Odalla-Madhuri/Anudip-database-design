package com.ajp.service;

import com.ajp.entity.Student;

public interface StudentService {

	int insertStudent(Student s);
	void updateStudent(Integer sid);
	int deleteStudent(Integer sid);
	void displayStudent();
	void getStudent(Integer sid);
	
}
