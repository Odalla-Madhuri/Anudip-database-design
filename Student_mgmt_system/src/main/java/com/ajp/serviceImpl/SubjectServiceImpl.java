package com.ajp.serviceImpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ajp.entity.Subject;
import com.ajp.service.SubjectService;
import com.ajp.utility.UtilityConfig;

import jakarta.persistence.TypedQuery;

public class SubjectServiceImpl implements SubjectService {

	Session session = UtilityConfig.getSession();
	Transaction transaction = session.beginTransaction();
	
	
	@SuppressWarnings("deprecation")
	public int insertSubject(Subject sub) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(sub);
    		transaction.commit();
    		System.out.println("Subject details inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
		return 1;
	}

	@SuppressWarnings("deprecation")
	public void updateSubject(Integer subid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(subid);
    		transaction.commit();
    		System.out.println("Subject details updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	public int deleteSubject(Integer subid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(subid);
    		transaction.commit();
    		System.out.println("Subject details deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
		return 1;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public void displaySubject() {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            TypedQuery tq = session.createQuery("from Subject");
    		List<Subject> list = tq.getResultList();

    		Iterator<Subject> itr = list.iterator();

    		while(itr.hasNext()) {
    			System.out.println(itr.next());
    		}
    		transaction.commit();
    		System.out.println("Subject details updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
	}

	@Override
	public void getSubject(Integer subid) {
		try (Session session = UtilityConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            Subject sub = session.get(Subject.class, subid);
            transaction.commit();
    		System.out.println(sub.getSubjectId() + " " + sub.getSubjectName());
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			session.close();
		}
	}
	
}
