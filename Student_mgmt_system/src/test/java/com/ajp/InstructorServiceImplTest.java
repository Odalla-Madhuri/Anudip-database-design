package com.ajp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ajp.entity.Instructor;
import com.ajp.serviceImpl.InstructorServiceImpl;

public class InstructorServiceImplTest {

	InstructorServiceImpl isimpl = new InstructorServiceImpl();
	Instructor i = new Instructor();
	
	@Test
	void deleteInstructorTest() {
		int in = isimpl.deleteInstructor(1);
		assertEquals(1, in);
	}
	
}
