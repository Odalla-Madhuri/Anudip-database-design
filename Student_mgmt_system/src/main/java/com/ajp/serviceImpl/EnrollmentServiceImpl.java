package com.ajp.serviceImpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ajp.entity.Course;
import com.ajp.entity.Enrollment;
import com.ajp.entity.Student;
import com.ajp.service.EnrollmentService;
import com.ajp.utility.UtilityConfig;

import jakarta.persistence.TypedQuery;

public class EnrollmentServiceImpl implements EnrollmentService {
	
	Session session = UtilityConfig.getSession();
	Transaction transaction = session.beginTransaction();

	@SuppressWarnings("deprecation")
	public int insertEnrollment(Enrollment en, Integer id) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            Student s = session.get(Student.class, id);
            Course c = session.get(Course.class, id);
            en.setStudent(s);
            en.setCourse(c);
            session.save(en);
    		transaction.commit();
    		System.out.println("Student enrollement details inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
		return 1;
	}

	@SuppressWarnings("deprecation")
	public void updateEnrollment(Integer eid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(eid);
    		transaction.commit();
    		System.out.println("Student enrollement details updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	public int deleteEnrollment(Integer eid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(eid);
    		transaction.commit();
    		System.out.println("Student enrollement details deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
		return 1;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public void displayEnrollment() {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            TypedQuery tq = session.createQuery("from Enrollment");
    		List<Enrollment> list = tq.getResultList();

    		Iterator<Enrollment> itr = list.iterator();

    		while(itr.hasNext()) {
    			System.out.println(itr.next());
    		}
    		transaction.commit();
    		System.out.println("Student enrollement details deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
		
	}

	@Override
	public void getEnrollment(Integer eid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            Enrollment en = session.get(Enrollment.class, eid);
    		transaction.commit();
    		System.out.println(en.getEnrollmentId() + " " + en.getEnrollmentDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
	}
	
}
