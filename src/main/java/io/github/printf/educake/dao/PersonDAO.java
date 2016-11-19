package io.github.printf.educake.dao;

import io.github.printf.educake.model.Person;
import org.hibernate.Query;

import java.util.List;

/**
 *
 * @author Vitor
 */
public class PersonDAO extends DataAccessObject<Person>{

  @Override
  public List findAll() {
    return getSession().createQuery("FROM Person").list();
  }

  @Override
  public Person getById(Integer id) {
    return getSession().load(Person.class, id);
  }
  
  public List<Person> getByName(String name) {
      Query query = getSession().createQuery("FROM person WHERE CONCAT(CONCAT(NAME,' '),SURNAME) LIKE '%:name%'");
      query.setParameter("name", name);
      return query.list();
  }

  @Override
  public boolean removeById(Integer id) {
    boolean result = true;
    
      try {
          Person person = this.getById(id);
          super.remove(person);
      } catch (Exception e) {
          e.printStackTrace();
          result = false;
      }
    
    return result;
  }
}
