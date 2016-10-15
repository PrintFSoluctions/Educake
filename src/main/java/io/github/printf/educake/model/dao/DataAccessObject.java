package io.github.printf.educake.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import org.hibernate.HibernateException;

public abstract class DataAccessObject<E> {

    private static final SessionFactory sessionFactory =
		new Configuration().configure().buildSessionFactory();;
    private static final ThreadLocal session = new ThreadLocal();

    protected DataAccessObject() {}

    public static Session getSession() {
        Session session = (Session) DataAccessObject.session.get();

        if (session == null) {
            session = sessionFactory.openSession();
            DataAccessObject.session.set(session);
        }

        return session;
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            System.out.println("Não foi possível fazer rollback da transação");
        }

        try {
            getSession().close();
        } catch (HibernateException e) {
            System.out.println("Não foi possível fazer fechar a sessão");
        }

        DataAccessObject.session.set(null);
    }

    public static void close() {
        getSession().close();
        DataAccessObject.session.set(null);
    }

    public abstract List<E> findAll();

    public boolean persist(E object) {
        boolean result = true;
        try {
            begin();
            getSession().persist(object);
            commit();
        } catch (Exception ex) {
            rollback();
        }

        return result;
    }

    public boolean remove(E object){
        boolean result = true;
        try {
            begin();
            getSession().delete(object);
            commit();
        } catch (Exception ex) {
            rollback();
        }

        return result;
    }
    
    public abstract E getById(final Integer id);

    public abstract boolean removeById(final Integer id);

}
