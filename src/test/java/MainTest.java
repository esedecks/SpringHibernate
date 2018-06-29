import java.util.List;

import mx.contigo.dao.PersonDAO;
import mx.contigo.daoImpl.PersonDAOImpl;
import mx.contigo.pojo.Person;

public class MainTest {

	public static void main(String[] args) {
		PersonDAO personDao = new PersonDAOImpl(); 
		Person person = new Person(); 
		person.setName("Ariel");
		person.setCountry("México");
		try {
			personDao.save(person);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		List<Person> personList = personDao.getAll();
		for (Person p : personList) {
			System.out.println(p.toString());
		}
	}

}
