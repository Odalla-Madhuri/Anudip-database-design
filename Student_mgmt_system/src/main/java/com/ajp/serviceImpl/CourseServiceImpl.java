package com.ajp.serviceImpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ajp.entity.Course;
import com.ajp.entity.Instructor;
import com.ajp.service.CourseService;
import com.ajp.utility.UtilityConfig;

import jakarta.persistence.TypedQuery;

public class CourseServiceImpl implements CourseService {

	Session session = UtilityConfig.getSession();
	Transaction transaction = session.beginTransaction();
	
	@SuppressWarnings("deprecation")
	public int insertCourse(Course c, Integer id) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            Instructor i = session.get(Instructor.class, id);
            c.setInstructor(i);
            session.save(c);
    		transaction.commit();
    		System.out.println("Student course details inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
		return 1;
	}

	@SuppressWarnings("deprecation")
	public void updateCourse(Integer cid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(cid);
    		transaction.commit();
    		System.out.println("Student course details updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	public int deleteCourse(Integer cid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(cid);
    		transaction.commit();
    		System.out.println("Student course details deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
		return 1;
	}

	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	public void displayCourse() {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            TypedQuery tq = session.createQuery("from Course");
    		List<Course> list = tq.getResultList();
    		Iterator<Course> itr = list.iterator();

    		while(itr.hasNext()) {
    			System.out.println(itr.next());
    		}    		
    		transaction.commit();
    		System.out.println("Student course details deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
	}

	@Override
	public void getCourse(Integer cid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            Course c = session.get(Course.class, cid);
            transaction.commit();
    		System.out.println(c.getCourseId() + " " + c.getCourseName() + " " + c.getCourseDuration() + " " + c.getCourseFee());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
