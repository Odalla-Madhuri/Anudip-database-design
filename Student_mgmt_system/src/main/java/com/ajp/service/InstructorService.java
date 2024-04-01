package com.ajp.service;

import com.ajp.entity.Instructor;

public interface InstructorService {

	int insertInstructor(Instructor i);
	void updateInstructor(Integer iid);
	int deleteInstructor(Integer iid);
	void displayInstructor();
	void getInstructor(Integer iid);

}
