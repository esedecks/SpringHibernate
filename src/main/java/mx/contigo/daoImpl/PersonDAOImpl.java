package mx.contigo.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import mx.contigo.dao.PersonDAO;
import mx.contigo.persistence.HibernateUtil;
import mx.contigo.pojo.Person;

import java.util.ArrayList;
import org.hibernate.HibernateException;

public class PersonDAOImpl implements PersonDAO {

	

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
//	@Override
//	public void save(Person p) {
//		Session session = this.sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		session.persist(p);
//		tx.commit();
//		session.close();
//	}

	
//	@Override
//	public List<Person> getAll() {
//		Session session = this.sessionFactory.openSession();
//		List<Person> personList = new ArrayList<>(); 
//		List<?> objectList = session.createCriteria(Person.class).list();
//		
//		for (Object object : objectList) {
//			if(object instanceof Person)
//				personList.add((Person)object);
//		}
//		session.close();
//		return personList;
//	}

	
	
	
	@Override
	public void save(Person person) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(person);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Person person) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(person);
		tx.commit();
		session.close();

	}

	@Override
	public void delete(Person person) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(person);
		tx.commit();
		session.close();
	}

	@Override
	public List<Person> getAll() throws HibernateException {
		List<Person> PersonsList = new ArrayList<>();
		List<?> objectList = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		objectList = session.createCriteria(Person.class).list();
		for (Object ob : objectList) {
			if (ob instanceof Person) {
				PersonsList.add((Person) ob);
			}
		}
		session.close();
		return PersonsList;
	}

	@Override
	public Person getById(Integer id) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Person person = (Person) session.get(Person.class, id);
		session.close();
		return person;
	}
}
