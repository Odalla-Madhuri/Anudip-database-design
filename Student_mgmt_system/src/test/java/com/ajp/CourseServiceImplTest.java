package com.ajp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ajp.entity.Course;
import com.ajp.serviceImpl.CourseServiceImpl;

public class CourseServiceImplTest {

	CourseServiceImpl csimpl = new CourseServiceImpl();
	Course c = new Course();
	
	@Test
	void deleteCourseTest() {
		int co = csimpl.deleteCourse(1);
		assertEquals(1, co);
	}
	
}
