package com.ajp.serviceImpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ajp.entity.Student;
import com.ajp.service.StudentService;
import com.ajp.utility.UtilityConfig;

import jakarta.persistence.TypedQuery;

public class StudentServiceImpl implements StudentService {

	Session session = UtilityConfig.getSession();
	Transaction transaction = session.beginTransaction();
	
	@SuppressWarnings("deprecation")
	public int insertStudent(Student s) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(s);
    		transaction.commit();
    		System.out.println("Student inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
		return 1;
	}

	@SuppressWarnings("deprecation")
	public void updateStudent(Integer sid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(sid);
    		transaction.commit();
    		System.out.println("Student updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	public int deleteStudent(Integer sid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(sid);
    		transaction.commit();
    		System.out.println("Student deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
		return 1;
	}
	
	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	public void displayStudent() {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            TypedQuery tq = session.createQuery("from Student");
    		List<Student> list = tq.getResultList();
    		Iterator<Student> itr = list.iterator();

    		while(itr.hasNext()) {
    			System.out.println(itr.next());
    		}
    		transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
		
	}

	@Override
	public void getStudent(Integer sid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            Student s = session.get(Student.class, sid);
            transaction.commit();
            System.out.println(s.getStudentId() + " " + s.getFirstName() + " " + s.getLastName() + " " + s.getEmail() + " " + s.getPhoneNo());
        } catch (Exception e) {
            e.printStackTrace();
        }		
		finally {
			session.close();
		}
	}

}
