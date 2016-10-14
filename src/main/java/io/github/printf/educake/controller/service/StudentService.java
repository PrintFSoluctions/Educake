package io.github.printf.educake.controller.service;

import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Student;
import io.github.printf.educake.model.dao.StudentDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Albino Freitas
 */
public class StudentService {

    Student student = new Student();
    StudentDAO studnetDAO = new StudentDAO();

    public Student getStudent() {
        return this.student;
    }

    public void setResponsible(Person person) {
        this.student.setResponsible(person);
    }

    public void setPerson(Person person) {
        this.student.setPerson(person);
    }

    public void generateRm() {
        String rm = getSystemYear() + getSystemMonth();

        rm += getNextID();

        this.student.setRm(rm);
    }
    
    public boolean persist(){
        boolean result = true;
        
        result = studnetDAO.persist(this.student);
        
        return result;
    }

    private String getSystemYear() {
        DateFormat systemYear = new SimpleDateFormat("yyyy");
        Date date = new Date();

        return systemYear.format(date);
    }

    private String getSystemMonth() {
        DateFormat systemMonth = new SimpleDateFormat("MM");
        Date date = new Date();

        return systemMonth.format(date);
    }

    private String getNextID() {
        Student lastStudent = getLastStudant();

        String rm = lastStudent.getRm();

        if (rm != null) {
            rm = rm.substring(4);
            
            if (rm.equals("999")) {
                rm = "001";
            } else {
                int temp = Integer.parseInt(rm)+1;
                rm = String.valueOf(temp);
            }
        }else{
            rm = "001";
        }

        return rm;
    }

    private Student getLastStudant() {
        StudentDAO studentDAO = new StudentDAO();

        return studentDAO.getLastStudent();
    }
}
