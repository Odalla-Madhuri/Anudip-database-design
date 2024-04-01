package com.ajp.serviceImpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ajp.entity.Assignment;
import com.ajp.entity.Subject;
import com.ajp.service.AssignmentService;
import com.ajp.utility.UtilityConfig;

import jakarta.persistence.TypedQuery;

public class AssignementServiceImpl implements AssignmentService {

	Session session = UtilityConfig.getSession();
	Transaction transaction = session.beginTransaction();
	
	@SuppressWarnings("deprecation")
	public int insertAssignment(Assignment a, Integer id) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            Subject sub = session.get(Subject.class, id);
            a.setSubject(sub);
            session.save(a);
    		transaction.commit();
    		System.out.println("Assignment details inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
		return 1;
	}

	@SuppressWarnings("deprecation")
	public void updateAssignment(Integer aid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(aid);
    		transaction.commit();
    		System.out.println("Assignment details updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}

	}

	@SuppressWarnings("deprecation")
	public int deleteAssignment(Integer aid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(aid);
    		transaction.commit();
    		System.out.println("Assignment details deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
		return 1;
	}

	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public void displayAssignment() {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            TypedQuery tq = session.createQuery("from Assignment");
    		List<Assignment> list = tq.getResultList();

    		Iterator<Assignment> itr = list.iterator();

    		while(itr.hasNext()) {
    			System.out.println(itr.next());
    		}
    		transaction.commit();
    		System.out.println("Assignment details deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
	}

	@Override
	public void getAssignment(Integer aid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            Assignment a = session.get(Assignment.class, aid);
    		transaction.commit();
    		System.out.println(a.getAssignmentId() + " " + a.getAssignmentName() + " " + a.getDuedate());
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
	}
	
}
