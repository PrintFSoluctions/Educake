package io.github.printf.educake.controller;

import io.github.printf.educake.controller.service.AddressService;
import io.github.printf.educake.controller.service.PersonService;
import io.github.printf.educake.controller.service.PhoneService;
import io.github.printf.educake.controller.service.StudentService;
import io.github.printf.educake.model.Address;
import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Phone;
import io.github.printf.educake.model.Student;
import io.github.printf.educake.view.main.MainFrame;
import io.github.printf.educake.view.person.AddressPanel;
import io.github.printf.educake.view.person.PersonPanel;
import io.github.printf.educake.view.person.PhonePanel;
import io.github.printf.educake.view.person.student.StudentDash;
import io.github.printf.educake.view.person.student.StudentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitor on 02/10/2016.
 */
public class StudentController {
  private Person person;
  private Address address;
  private ArrayList<Phone> phones = new ArrayList<>();

  private PersonService personService = new PersonService();
  private PhoneService phonesService = new PhoneService();
  private AddressService addressService = new AddressService();
  private StudentService studentService = new StudentService();

  private PersonPanel personPanel;
  private AddressPanel addressPanel;
  private PhonePanel phonePanel;
  private StudentView studentView;
  private StudentDash studentDash;

  public ActionListener persist(Person responsible) {
    return (ActionEvent e) -> {
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
        phonesService.setPhones(tels, types);
        addressService.setAddress(street, housenumber, complement, city, CEP, state);
        personService.setPerson(name, surname, birthDate);
        System.out.println(name+" "+surname+" : "+birthDate);

        phones = phonesService.getPhones();
        address = addressService.getAddress();
        person = personService.getPerson();

        person.setPhones(phones);
        person.setAddress(address);

        studentService.setStudent(person);

        if(studentService.isOfAge() || studentService.getResponsible() != null){
          studentService.persist();
        }else{
          MainFrame.goTo("attachResponsible", person.getIdPerson());
        }

      }catch (Exception ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
        studentService.rollback();
      }
    };
  }

  public ActionListener update() {
    return (ActionEvent e) -> {
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
        phonesService.setPhones(tels, types);
        addressService.setAddress(street, housenumber, complement, city, CEP, state);
        personService.setPerson(name, surname, birthDate);
        System.out.println(name + " " + surname + " : " + birthDate);

        phones = phonesService.getPhones();
        address = addressService.getAddress();
        person = personService.getPerson();

        person.setPhones(phones);
        person.setAddress(address);

        Student temporaryStudent = studentService.getStudent();
        Student editedStudent = studentService.getStudentById(studentView.getId());
        temporaryStudent.setRm(editedStudent.getRm());

        studentService.setStudent(temporaryStudent);
        studentService.update();
      }catch (Exception ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
        studentService.rollback();
      }
    };
  }

  public MouseAdapter delete(int id){
    return new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        int opt = JOptionPane.showConfirmDialog(null,
            "Tem certeza que deseja remover este aluno?", "Remoção de Aluno",
            JOptionPane.YES_NO_OPTION);

        if (opt == JOptionPane.YES_OPTION){
          studentService.remove(id);
        }
      }
    };
  }

  public Student getStudentById(int id){
    return studentService.getStudentById(id);
  }

  public void setView(StudentView view) {
    this.studentView = view;
    personPanel = studentView.getPersonPanel();
    addressPanel = studentView.getAddressPanel();
    phonePanel = studentView.getPhonesPanel();
  }

  public void setDash(StudentDash dash){
    this.studentDash = dash;
    dash.showAll(studentService.getAllStudents());
  }
}
