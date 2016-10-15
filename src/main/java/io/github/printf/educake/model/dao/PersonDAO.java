package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.Person;

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
