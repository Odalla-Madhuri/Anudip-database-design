package com.ajp.service;

import com.ajp.entity.Enrollment;

public interface EnrollmentService {

	int insertEnrollment(Enrollment en, Integer id);
	void updateEnrollment(Integer eid);
	int deleteEnrollment(Integer eid);
	void displayEnrollment();
	void getEnrollment(Integer eid);
	
}
