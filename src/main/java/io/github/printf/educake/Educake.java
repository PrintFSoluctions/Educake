package io.github.printf.educake;

import io.github.printf.educake.model.dao.BillDAO;
import io.github.printf.educake.model.dao.PaymentDAO;
import io.github.printf.educake.model.Bill;
import io.github.printf.educake.model.BillType;
import io.github.printf.educake.model.Payment;
import io.github.printf.educake.model.Person;
import java.util.Date;
import java.util.GregorianCalendar;

public class Educake {

  public static void main(String[] args) {

    PaymentDAO paydao = new PaymentDAO();
    Person person = new Person();
    Bill bill = new Bill();
    Payment pay = new Payment();
    
    person.setName("Fulano");
    person.setSurname("Da Silva");
    person.setBirthdate(new Date(new GregorianCalendar(1995, 9, 29).getTimeInMillis()));
    
    bill.setValue(100);
    bill.setBill(new BillType("Material"));
    bill.setDue(new Date(new GregorianCalendar(2016, 10, 4).getTimeInMillis()));
    bill.setFirstInstallment(new Date(new GregorianCalendar(2016, 10, 4).getTimeInMillis()));
    bill.setPerson(person);
    
    pay.setBill(bill);
    pay.setPaymentDate(new Date(new GregorianCalendar(2016, 10, 4).getTimeInMillis()));
    pay.setValue(100);
    
    paydao.persist(pay);
    
    System.exit(0);
  }

}
