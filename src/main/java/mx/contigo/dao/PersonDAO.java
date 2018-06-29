package mx.contigo.dao;

import java.util.List;

import org.hibernate.HibernateException;

import mx.contigo.pojo.Person;

public interface PersonDAO {
	public void save(Person person) throws HibernateException;

	public void update(Person person) throws HibernateException;

	public void delete(Person person) throws HibernateException;

	public List<Person> getAll() throws HibernateException;

	public Person getById(Integer id) throws HibernateException;
}
