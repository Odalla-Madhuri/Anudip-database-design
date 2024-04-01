package com.ajp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ajp.entity.Enrollment;
import com.ajp.serviceImpl.EnrollmentServiceImpl;

public class EnrollmentServiceImplTest {
	
	EnrollmentServiceImpl esimpl = new EnrollmentServiceImpl();
	Enrollment en = new Enrollment();
	
	@Test
	void deleteEnrollmentTest() {
		int enr = esimpl.deleteEnrollment(1);
		assertEquals(1, enr);
	}

}
