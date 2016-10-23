package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.Teacher;
import java.util.List;

/**
 *
 * @author Thaila
 */
public class TeacherDAO extends DataAccessObject<Teacher> {

    @Override
    public List findAll() {
        return getSession().createQuery("FROM Teacher").list();
    }

    @Override
    public Teacher getById(Integer id) {
        return getSession().load(Teacher.class, id);
    }

    @Override
    public boolean removeById(Integer id) {
        boolean result = true;

        try {
            Teacher teacher = this.getById(id);
            super.remove(teacher);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }
}
