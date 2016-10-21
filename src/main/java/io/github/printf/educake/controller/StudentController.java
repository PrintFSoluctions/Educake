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
  private PersonPanel personPanel = studentView.getPersonPanel();
  private AddressPanel addressPanel = studentView.getAddressPanel();
  private PhonePanel phonePanel = studentView.getPhonesPanel();

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

      try {
        personService.persist(name, surname, birthDate);
        person = personService.getPeson();

        phonesService.persist(person, types, tels);
        phones = phonesService.getPhones();

        addressService.persist(person, CEP, street, city, state, housenumber, complement);
        address = addressService.getAddress();

        studentService.setPerson(person);
        studentService.setPhone(phones);
        studentService.setAddress(address);
        studentService.persist();
      }catch (Exception ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
        studentService.rollback();
      }
    };
  }

  public void start() {
    SwingUtilities.invokeLater(() -> {
      try {
        studentView = new StudentView();
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }
}
