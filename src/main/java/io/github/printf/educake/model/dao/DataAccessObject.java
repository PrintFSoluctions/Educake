package io.github.printf.educake.model.dao;

import io.github.printf.educake.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class DataAccessObject<E> {

  public abstract List<E> findAll();

  public boolean persist(E object) {

    boolean result = true;

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.persist(object);
    session.getTransaction().commit();

    return result;
  }

  public abstract E getById(final Integer id);

  public abstract boolean removeById(final Integer id);

}