package com.ajp;

import java.sql.Date;
import java.util.Scanner;

import com.ajp.entity.Assignment;
import com.ajp.entity.Course;
import com.ajp.entity.Enrollment;
import com.ajp.entity.Instructor;
import com.ajp.entity.Student;
import com.ajp.entity.Subject;
import com.ajp.service.AssignmentService;
import com.ajp.service.CourseService;
import com.ajp.service.EnrollmentService;
import com.ajp.service.InstructorService;
import com.ajp.service.StudentService;
import com.ajp.service.SubjectService;
import com.ajp.serviceImpl.AssignementServiceImpl;
import com.ajp.serviceImpl.CourseServiceImpl;
import com.ajp.serviceImpl.EnrollmentServiceImpl;
import com.ajp.serviceImpl.InstructorServiceImpl;
import com.ajp.serviceImpl.StudentServiceImpl;
import com.ajp.serviceImpl.SubjectServiceImpl;

public class StudentMgmtSystem {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Student Management System Application");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		StudentService sservice = new StudentServiceImpl();
		EnrollmentService eservice = new EnrollmentServiceImpl();
		CourseService cservice = new CourseServiceImpl();
		SubjectService subservice = new SubjectServiceImpl();
		AssignmentService aservice = new AssignementServiceImpl();
		InstructorService iservice = new InstructorServiceImpl();
		
		int a = 0;		
		System.out.println("1. Insert Student");
		System.out.println("2. Insert Enrollment");
		System.out.println("3. Insert Course");
		System.out.println("4. Insert Subject");
		System.out.println("5. Insert Assignment");
		System.out.println("6. Insert Instructor");
		
		System.out.println("7. Update Student");
		System.out.println("8. Update Enrollment");
		System.out.println("9. Update Course");
		System.out.println("10. Update Subject");
		System.out.println("11. Update Assignemnt");
		System.out.println("12. Update Instructor");
		
		System.out.println("13. Delete Student");
		System.out.println("14. Delete Enrollment");
		System.out.println("15. Delete Course");
		System.out.println("16. Delete Subject");
		System.out.println("17. Delete Assignment");
		System.out.println("18. Delete Instructor");
		
		System.out.println("19. Get Student List");
		System.out.println("20. Get Enrollment List");
		System.out.println("21. Get Course List");
		System.out.println("22. Get Subject List");
		System.out.println("23. Get Assignment List");
		System.out.println("24. Get Instructor List");
		
		System.out.println("25. Get Student by Id");
		System.out.println("26. Get Enrollment by Id");
		System.out.println("27. Get Course by Id");
		System.out.println("28. Get Subject by Id");
		System.out.println("29. Get Assignment by Id");
		System.out.println("30. Get Instructor by Id");
		
		Student s = new Student();
		Enrollment en = new Enrollment();
		Course c = new Course();
		Subject sub = new Subject();
		Assignment as = new Assignment();
		Instructor i = new Instructor();
		
		Integer sid = null;
        Integer eid = null;
        Integer cid = null;
        Integer subid = null;
        Integer aid = null;
        Integer iid = null;

		System.out.println("Enter your option: ");
		a = sc.nextInt();	
		while(a>0) {
			switch(a) {
			case 1: System.out.println("Enter student id: ");
            		s.setStudentId(sc.nextInt());
		            System.out.println("Enter firstName: ");
		            sc.nextLine(); // Consume newline character
		            s.setFirstName(sc.nextLine());
		            System.out.println("Enter lastName: ");
		            s.setLastName(sc.nextLine());
		            System.out.println("Enter email: ");
		            s.setEmail(sc.nextLine());
		            System.out.println("Enter phoneNo: ");
		            s.setPhoneNo(sc.nextInt());
		            sservice.insertStudent(s);
		            break;
			case 2: System.out.println("Enter enrollment id: ");
		            en.setEnrollmentId(sc.nextInt());
		            sc.nextLine(); // Consume newline character		
		            System.out.println("Enter enrollment date (yyyy-MM-dd): ");
		            String enrollmentDateStr = sc.nextLine();	
		            System.out.println("Enter student id: ");
		            System.out.println("Enter course id: ");
		            // Validate and parse the enrollment date
		            try {
		                Date enrollmentDate = Date.valueOf(enrollmentDateStr);
		                en.setEnrollmentDate(enrollmentDate);
		                eservice.insertEnrollment(en, sc.nextInt());
		            } 
		            catch (IllegalArgumentException e) {
		                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
		            } 
		            break;
			case 3: System.out.println("Enter course id: ");
		            c.setCourseId(sc.nextInt());
		            System.out.println("Enter course name: ");
		            sc.nextLine(); // Consume newline character
		            c.setCourseName(sc.nextLine());
		            System.out.println("Enter course duration: ");
		            c.setCourseDuration(sc.nextInt());
		            System.out.println("Enter course fee: ");
		            c.setCourseFee(sc.nextInt());
		            System.out.println("Enter instructor id: ");
		            cservice.insertCourse(c, sc.nextInt());
		            break;
			case 4: System.out.println("Enter subject id: ");
		            sub.setSubjectId(sc.nextInt());
		            System.out.println("Enter subject name: ");
		            sc.nextLine(); // Consume newline character
		            sub.setSubjectName(sc.nextLine());
		            subservice.insertSubject(sub);
		            break;
			case 5: System.out.println("Enter assignment id: ");
		            as.setAssignmentId(sc.nextInt());
		            System.out.println("Enter assignment name: ");
		            sc.nextLine(); // Consume newline character
		            as.setAssignmentName(sc.nextLine());
		            System.out.println("Enter dueDate (yyyy-MM-dd): ");
		            String dueDateStr = sc.nextLine();
		            System.out.println("Enter subject id: ");
		            // Validate and parse the due date
		            try {
		                Date dueDate = Date.valueOf(dueDateStr);
		                as.setDuedate(dueDate);
		                aservice.insertAssignment(as, sc.nextInt());
		            } 
		            catch (IllegalArgumentException e) {
		                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
		            }
		            break;
			case 6: System.out.println("Enter instructor id: ");
		            i.setInstructorId(sc.nextInt());
		            System.out.println("Enter firstName: ");
		            sc.nextLine(); // Consume newline character
		            i.setFirstName(sc.nextLine());
		            System.out.println("Enter lastName: ");
		            i.setLastName(sc.nextLine());
		            System.out.println("Enter email: ");
		            i.setEmail(sc.nextLine());
		            iservice.insertInstructor(i);
		            break;
		            
			case 7: System.out.println("Enter student id you want to update: ");
	        		s.setStudentId(sc.nextInt());
		            System.out.println("Enter firstName: ");
		            sc.nextLine(); // Consume newline character
		            s.setFirstName(sc.nextLine());
		            System.out.println("Enter lastName: ");
		            s.setLastName(sc.nextLine());
		            System.out.println("Enter email: ");
		            s.setEmail(sc.nextLine());
		            System.out.println("Enter phoneNo: ");
		            s.setPhoneNo(sc.nextInt());
		            sservice.updateStudent(sid);
		            break;
			case 8: System.out.println("Enter enrollment id you want to update: ");
		            en.setEnrollmentId(sc.nextInt());
		            sc.nextLine(); // Consume newline character
		
		            System.out.println("Enter enrollment date (yyyy-MM-dd): ");
		            enrollmentDateStr = sc.nextLine();
		
		            // Validate and parse the enrollment date
		            try {
		                Date enrollmentDate = Date.valueOf(enrollmentDateStr);
		                en.setEnrollmentDate(enrollmentDate);
		                eservice.updateEnrollment(eid);
		            } 
		            catch (IllegalArgumentException e) {
		                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
		            } 
		            break;
			case 9: System.out.println("Enter course id you want to update: ");
		            c.setCourseId(sc.nextInt());
		            System.out.println("Enter course name: ");
		            sc.nextLine(); // Consume newline character
		            c.setCourseName(sc.nextLine());
		            System.out.println("Enter course duration: ");
		            c.setCourseDuration(sc.nextInt());
		            System.out.println("Enter course fee: ");
		            c.setCourseFee(sc.nextInt());
		            cservice.updateCourse(cid); 
		            break;
			case 10: System.out.println("Enter subject id you want to update: ");
			         sub.setSubjectId(sc.nextInt());
			         System.out.println("Enter subject name: ");
			         sc.nextLine(); // Consume newline character
			         sub.setSubjectName(sc.nextLine());
			         subservice.updateSubject(subid);
			         break;
			case 11: System.out.println("Enter assignment id you want to update: ");
			         as.setAssignmentId(sc.nextInt());
			         System.out.println("Enter assignment name: ");
			         sc.nextLine(); // Consume newline character
			         as.setAssignmentName(sc.nextLine());
			         System.out.println("Enter dueDate (yyyy-MM-dd): ");
			         dueDateStr = sc.nextLine();
			         // Validate and parse the due date
			         try {
			             Date dueDate = Date.valueOf(dueDateStr);
			             as.setDuedate(dueDate);
			             aservice.updateAssignment(aid);
			         } 
			         catch (IllegalArgumentException e) {
			             System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
			         }
			         break;
			case 12: System.out.println("Enter instructor id you want to update: ");
			         i.setInstructorId(sc.nextInt());
			         System.out.println("Enter firstName: ");
			         sc.nextLine(); // Consume newline character
			         i.setFirstName(sc.nextLine());
			         System.out.println("Enter lastName: ");
			         i.setLastName(sc.nextLine());
			         System.out.println("Enter email: ");
			         i.setEmail(sc.nextLine());
			         iservice.updateInstructor(iid);
			         break;
				
			case 13: System.out.println("Enter student id you want to delete");
					 sservice.deleteStudent(sid);
					 break;
			case 14: System.out.println("Enter enrollment id you want to delete");
					 eservice.deleteEnrollment(eid);
					 break;
			case 15: System.out.println("Enter course id you want to delete");
					 cservice.deleteCourse(cid);
					 break;
			case 16: System.out.println("Enter subject id you want to delete");
					 subservice.deleteSubject(subid);
					 break;
			case 17: System.out.println("Enter assignment id you want to delete");
					 aservice.deleteAssignment(aid);
					 break;
			case 18: System.out.println("Enter instructor id you want to delete");
					 iservice.deleteInstructor(iid);
					 break;
				
			case 19: sservice.displayStudent();
                     break;
            case 20: eservice.displayEnrollment();
                     break;
            case 21: cservice.displayCourse();
                     break;
            case 22: subservice.displaySubject();
                     break;
            case 23: aservice.displayAssignment();
            		 break;
            case 24: iservice.displayInstructor();
                	 break;
                
            case 25: System.out.println("Enter student id you want to get:");
            		 sid = sc.nextInt();
                	 sservice.getStudent(sid);
                	 break;
            case 26: System.out.println("Enter enrollment id you want to get:");
            		 eid  = sc.nextInt();
   	                 eservice.getEnrollment(eid);
	                 break;
            case 27: System.out.println("Enter course id you want to get: ");
            		 cid  = sc.nextInt();
                     cservice.getCourse(cid);
                     break;
            case 28: System.out.println("Enter subject id you want to get: ");
                     subid  = sc.nextInt();
                     subservice.getSubject(subid);
                     break;
            case 29: System.out.println("Enter assignment id you want to get: ");
            		 aid  = sc.nextInt();
                     aservice.getAssignment(aid);
                     break;
            case 30: System.out.println("Enter instructor id you want to get: ");
            		 iid  = sc.nextInt();
                     iservice.getInstructor(iid);
                     break;
            default: System.out.println("Invalid option chosen.");
                     break;
			}
			// Ask user if they want to continue
            System.out.println("Do you want to continue? (yes/no): ");
            String continueChoice = sc.next();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                break;
            }
        }
	}
}
