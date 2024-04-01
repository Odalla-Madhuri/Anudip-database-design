package com.ajp.service;

import com.ajp.entity.Assignment;

public interface AssignmentService {

	int insertAssignment(Assignment a, Integer id);
	void updateAssignment(Integer aid);
	int deleteAssignment(Integer aid);
	void displayAssignment();
	void getAssignment(Integer aid);

}
