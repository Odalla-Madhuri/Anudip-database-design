package com.ajp.serviceImpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ajp.entity.Instructor;
import com.ajp.service.InstructorService;
import com.ajp.utility.UtilityConfig;

import jakarta.persistence.TypedQuery;

public class InstructorServiceImpl implements InstructorService {

	Session session = UtilityConfig.getSession();
	Transaction transaction = session.beginTransaction();
	
	@SuppressWarnings("deprecation")
	public int insertInstructor(Instructor i) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(i);
    		transaction.commit();
    		System.out.println("Instructor details inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
		return 1;
	}

	@SuppressWarnings("deprecation")
	public void updateInstructor(Integer iid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(iid);
    		transaction.commit();
    		System.out.println("Instructor details updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	public int deleteInstructor(Integer iid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(iid);
    		transaction.commit();
    		System.out.println("Instructor details deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
		return 1;
	}

	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	public void displayInstructor() {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            TypedQuery tq = session.createQuery("from Instructor");
    		List<Instructor> list = tq.getResultList();
    		Iterator<Instructor> itr = list.iterator();

    		while(itr.hasNext()) {
    			System.out.println(itr.next());
    		}
    		transaction.commit();
    		System.out.println("Instructor details deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
	}

	@Override
	public void getInstructor(Integer iid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            Instructor i = session.get(Instructor.class, iid);
            transaction.commit();
    		System.out.println(i.getInstructorId() + " " + i.getFirstName() + " " + i.getLastName() + " " + i.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
	}
	
}
