package com.ajp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ajp.entity.Assignment;
import com.ajp.serviceImpl.AssignementServiceImpl;

public class AssignmentServiceImplTest {

	AssignementServiceImpl asimpl = new AssignementServiceImpl();
	Assignment a = new Assignment();
	
	@Test
	void deleteAssignmentTest() {
		int as = asimpl.deleteAssignment(1);
		assertEquals(1,as);
	}
	
}
