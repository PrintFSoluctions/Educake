package io.github.printf.educake.controller.service;

import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Student;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Albino Freitas
 */
public class StudentService {

    Student student = new Student();

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
        
        rm += getLastID();
        
        this.student.setRm(rm);
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

    private int getLastID() {
        return 0;
    }
}
