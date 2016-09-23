package io.github.printf.educake;

import io.github.printf.educake.controller.EasyDate;
import io.github.printf.educake.model.*;
import io.github.printf.educake.model.dao.PaymentDAO;
import io.github.printf.educake.model.dao.PersonDAO;
import io.github.printf.educake.model.dao.StudentDAO;

public class Educake {

    public static void main(String[] args) {

        StudentDAO studantDAO = new StudentDAO();
        Student student = new Student();
        PersonDAO personDAO = new PersonDAO();

        Person person = new Person();
        person.setName("Joaquim");
        person.setSurname("Maria");
        person.setBirthdate(EasyDate.toDate(10, 5, 2000));
//
//        Person person2 = new Person();
//        person2.setName("João");
//        person2.setSurname("Silva");
//        person2.setBirthdate(EasyDate.toDate(3, 5, 1991));
//
//        Person person3 = new Person();
//        person3.setName("José");
//        person3.setSurname("Henrique");
//        person3.setBirthdate(EasyDate.toDate(25, 9, 1988));
//        personDAO.persist(person3);
//
//        student.setIdResponsible(person2);
//        student.setPerson(person);
//        student.setRm("1552031");

        studantDAO.persist(student);

        PaymentDAO paydao = new PaymentDAO();
        Bill bill = new Bill();
        Installment installment = new Installment();

        bill.setBillType(new BillType("Matrícula"));
        bill.setOpeningDate(EasyDate.toDate(1995, 9, 29));
        bill.setPerson(person);

        for (int i = 0; i < 5; i++) {
            bill.addInstallment(new Installment(bill, 100d, EasyDate.toDate(2016, 9+i, 29)));
        }

        paydao.persist(installment);

        System.exit(0);
    }

}
