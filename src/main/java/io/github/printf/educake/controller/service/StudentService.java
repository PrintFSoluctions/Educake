package io.github.printf.educake.controller.service;

import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Student;
import io.github.printf.educake.model.dao.StudentDAO;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Albino Freitas
 */
public class StudentService extends PersonService{

    private final Student student;
    private final StudentDAO studentDAO;
    private Person responsible = null;

    public StudentService() {
        this.studentDAO = new StudentDAO();
        this.student = new Student();
    }

    public void setStudent(Person person, Person responsible) {
        this.student.setPerson(person);
        this.student.setResponsible(responsible);
        generateRm();
    }

    public void setStudent(Person person) {
        this.student.setPerson(person);
        this.student.setResponsible(person);
        generateRm();
    }

    public Student getStudent() {
        return this.student;
    }

    public boolean persist() {
        return studentDAO.persist(this.student);
    }

    public boolean remove() {
        return studentDAO.remove(student);
    }

    public boolean removeById(Integer id) {
        return studentDAO.removeById(id);
    }

    public void rollback() {
        // TODO: Deve apagar tudo vinculado ao aluno e o próprio aluno
    }

    //Private Methods

    private void generateRm() {
        String rm = getSystemYear() + getSystemMonth();

        rm += getNextID();

        this.student.setRm(rm);
    }

    private String getSystemYear() {
        DateFormat systemYear = new SimpleDateFormat("yy");
        Date date = new Date();

        return systemYear.format(date);
    }

    private String getSystemMonth() {
        DateFormat systemMonth = new SimpleDateFormat("MM");
        Date date = new Date();

        return systemMonth.format(date);
    }

    private String getNextID() {
        Student lastStudent = getLastStudent();

        String rm = lastStudent.getRm();

        if (rm != null) {
            rm = rm.substring(4);

            if (rm.equals("999")) {
                rm = "001";
            } else {
                DecimalFormat decimal = new DecimalFormat("000");
                int temp = Integer.parseInt(rm);
                temp++;
                rm = decimal.format(temp);
            }
        } else {
            rm = "001";
        }

        return rm;
    }

    private Student getLastStudent() {
        return new StudentDAO().getLastStudent();
    }

    public boolean isOfAge() {
        return true;
    }

    public Person getResponsible() {
        return responsible;
    }

    public void setResponsible(Person responsible) {
        this.responsible = responsible;
    }

    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }
}
