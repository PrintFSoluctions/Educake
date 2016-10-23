package io.github.printf.educake.controller;

import io.github.printf.educake.controller.service.AddressService;
import io.github.printf.educake.controller.service.PersonService;
import io.github.printf.educake.controller.service.PhoneService;
import io.github.printf.educake.controller.service.StudentService;
import io.github.printf.educake.model.Address;
import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Phone;
import io.github.printf.educake.view.person.AddressPanel;
import io.github.printf.educake.view.person.PersonPanel;
import io.github.printf.educake.view.person.PhonePanel;
import io.github.printf.educake.view.person.student.StudentView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitor on 02/10/2016.
 */
public class StudentController {

  private StudentView studentView;
  private PersonService personService = new PersonService();
  private Person person;
  private Address address;
  private ArrayList<Phone> phones = new ArrayList<>();
  private PhoneService phonesService = new PhoneService();
  private AddressService addressService = new AddressService();
  private StudentService studentService = new StudentService();
  private PersonPanel personPanel;
  private AddressPanel addressPanel;
  private PhonePanel phonePanel;

  public ActionListener persist() {
    return e -> {
      String name = personPanel.getName();
      String surname = personPanel.getSurname();
      String birthDate = personPanel.getBirth();

      List<String> types = phonePanel.getPhoneTypes();
      List<String> tels = phonePanel.getPhones();

      String CEP = addressPanel.getCEP();
      String street = addressPanel.getStreet();
      String city = addressPanel.getCity();
      String state = addressPanel.getState();
      String housenumber = addressPanel.getHouseNumber();
      String complement = addressPanel.getComplement();

//      try {
//        phonesService.setPhones(types, tels);
//        addressService.setAddress(CEP, street, city, state, housenumber, complement);
//        personService.setPerson(name, surname, birthDate);
//
//        phones = phonesService.getPhones();
//        address = addressService.getAddress();
//        person = personService.getPerson();
//
//        person.setPhones(phones);
//        person.setAddress(address);
//
//        studentService.setStudent(person);
//        studentService.persist();
//      }catch (Exception ex){
//        JOptionPane.showMessageDialog(null, ex.getMessage());
//        studentService.rollback();
//      }
    };
  }

  public void start() {
    SwingUtilities.invokeLater(() -> {
      try {
        studentView = new StudentView();
        personPanel = studentView.getPersonPanel();
        addressPanel = studentView.getAddressPanel();
        phonePanel = studentView.getPhonesPanel();
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }
}
