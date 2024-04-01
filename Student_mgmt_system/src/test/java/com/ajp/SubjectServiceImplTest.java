package com.ajp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ajp.entity.Subject;
import com.ajp.serviceImpl.SubjectServiceImpl;

public class SubjectServiceImplTest {

	SubjectServiceImpl subsimpl = new SubjectServiceImpl();
	Subject sub = new Subject();
	
	@Test
	void deleteSubjectTest() {
		int subject = subsimpl.deleteSubject(1);
		assertEquals(1, subject);
	}
	
}
