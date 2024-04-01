package com.ajp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ajp.entity.Student;
import com.ajp.serviceImpl.StudentServiceImpl;

public class StudentServiceImplTest {
	
	StudentServiceImpl ssimpl = new StudentServiceImpl();
	Student s = new Student();
	
	@Test
	void deleteStudentTest() {
		int st = ssimpl.deleteStudent(1);
		assertEquals(1, st);
	}
	
}
