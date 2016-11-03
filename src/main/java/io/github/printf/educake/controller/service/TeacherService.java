package io.github.printf.educake.controller.service;

import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Teacher;
import io.github.printf.educake.model.dao.TeacherDAO;

/**
 *
 * @author Albino Freitas
 */
public class TeacherService extends PersonService{
    
    private final Teacher teacher;
    private final TeacherDAO teacherDAO;
    
    public TeacherService() {
        teacher = new Teacher();
        teacherDAO = new TeacherDAO();
    }
    
    public void setTeacher(Person person){
        this.teacher.setPerson(person);
    }
    
    public Teacher getTeacher(){
        return this.teacher;
    }
    
    public boolean persist(){
        return teacherDAO.persist(this.teacher);    
    }
    
}
