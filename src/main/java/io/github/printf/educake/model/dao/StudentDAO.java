package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.Student;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Albino Freitas
 */
public class StudentDAO extends DataAccessObject{

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object getById(Integer id) {
        return null;
    }

    @Override
    public boolean removeById(Integer id) {
        return false;
    }
    
    public Student getLastStudent(){
        Query query = getSession().createQuery("FROM Student");
        Student student;
        
        if(!query.list().isEmpty())
            student = (Student) query.list().get(query.list().size()-1);
        else{
            student = new Student();
        }

        return student;
    }
}
