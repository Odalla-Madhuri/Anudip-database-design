package com.ajp.service;

import com.ajp.entity.Course;

public interface CourseService {
	
	int insertCourse(Course c, Integer id);
	void updateCourse(Integer cid);
	int deleteCourse(Integer cid);
	void displayCourse();
	void getCourse(Integer cid);

}
