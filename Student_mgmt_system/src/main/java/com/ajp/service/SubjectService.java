package com.ajp.service;

import com.ajp.entity.Subject;

public interface SubjectService {
	
	int insertSubject(Subject sub);
	void updateSubject(Integer subid);
	int deleteSubject(Integer subid);
	void displaySubject();
	void getSubject(Integer subid);

}
