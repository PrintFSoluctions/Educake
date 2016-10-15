package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Student;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Albino Freitas
 */
public class StudentDAO extends DataAccessObject<Student> {

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Student getById(Integer id) {
        return getSession().load(Student.class, id);
    }

    @Override
    public boolean removeById(Integer id) {
        boolean result = true;

        try {
            Student student = this.getById(id);
            super.remove(student);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    public Student getLastStudent() {
        Query query = getSession().createQuery("FROM Student");
        Student student;

        if (!query.list().isEmpty()) {
            student = (Student) query.list().get(query.list().size() - 1);
        } else {
            student = new Student();
        }

        return student;
    }
}
