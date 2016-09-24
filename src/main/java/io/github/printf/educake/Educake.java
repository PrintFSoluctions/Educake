package io.github.printf.educake;

import io.github.printf.educake.model.Address;
import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Student;
import io.github.printf.educake.model.Teacher;
import io.github.printf.educake.model.dao.AddressDAO;
import io.github.printf.educake.model.dao.PersonDAO;
import io.github.printf.educake.model.dao.StudentDAO;
import io.github.printf.educake.model.dao.TeacherDAO;
import io.github.printf.educake.util.EasyDate;

public class Educake {

  public static void main(String[] args) {

      StudentDAO studantDAO = new StudentDAO();
      Student student = new Student();
      PersonDAO personDAO = new PersonDAO();
      Teacher teacher = new Teacher();
      TeacherDAO teacherDAO = new TeacherDAO();
      Address address = new Address();
      AddressDAO addressDAO = new AddressDAO();
      
      Person person = new Person();
      person.setName("Joaquim");
      person.setSurname("Maria");
      person.setBirthdate(EasyDate.toDate(10, 5, 2000));
      
      Person person2 = new Person();
      person2.setName("João");
      person2.setSurname("Silva");
      person2.setBirthdate(EasyDate.toDate(3, 5, 1991));
      
      Person person3 = new Person();
      person3.setName("José");
      person3.setSurname("Henrique");
      person3.setBirthdate(EasyDate.toDate(25, 9, 1988));
      personDAO.persist(person3);
      
      
      address.setIdPerson(person);
      address.setCep("11223344");
      address.setCity("N.Y");
      address.setHouseNumber(1234);
      address.setState("N.Y");
      address.setStreet("122nd");
      address.setComplement("none");
      
      addressDAO.persist(address);
  
      //student.setIdResponsible(person2);
      //student.setPerson(person);
      //student.setRm("1552031");
      
  
      
      
      //studantDAO.persist(student);
     
      
//    PaymentDAO paydao = new PaymentDAO();
//    Person person = new Person();
//    Bill bill = new Bill();
//    Payment pay = new Payment();
//
//    person.setName("SUS");
//    person.setSurname("SUSU");
//    person.setBirthdate(EasyDate.toDate(2000, 11, 10));
//
//    bill.setValue(100);
//    bill.setBill(new BillType("new"));
//    bill.setDue(EasyDate.toDate(1995, 9, 29));
//    bill.setFirstInstallment(EasyDate.toDate(1995, 9, 29));
//    bill.setPerson(person);
//
//    pay.setBill(bill);
//    pay.setPaymentDate(EasyDate.toDate(1995, 9, 29));
//    pay.setValue(100);
//
//    paydao.persist(pay);

    System.exit(0);
  }

}
