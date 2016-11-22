package io.github.printf.educake.controller;

import io.github.printf.educake.dao.StudentDAO;
import io.github.printf.educake.model.Address;
import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Student;
import io.github.printf.educake.util.EasyDate;
import io.github.printf.educake.util.interfaces.ControlledScreen;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public class StudentController implements Initializable, ControlledScreen {

    @FXML
    private TextField
        nameTextField,
        birthTextField,
        cpfTextField,
        phone1TextField,
        phone2TextField,
        cepTextField,
        stateTextField,
        cityTextField,
        districtTextField,
        streetTextField,
        houseNumberTextField,
        complementTextField;

    ScreensController myController;
    private StudentDAO studentDAO = new StudentDAO();
    private Student student = new Student();

    Person person = new Person();
    private PersonController personController = new PersonController();

    Address address = new Address();
    private AddressController addressController = new AddressController();

    @FXML
    public void persistStudent(){
        String name = nameTextField.getText();
        String birth = birthTextField.getText();
        String cpf = cpfTextField.getText();
        String phone1 = phone1TextField.getText();
        String phone2 = phone2TextField.getText();
        String cep = cepTextField.getText();
        String state = stateTextField.getText();
        String city = cityTextField.getText();
        String district = districtTextField.getText();
        String street = streetTextField.getText();
        String houseNumber = houseNumberTextField.getText();
        String complement = complementTextField.getText();

        try {
            this.address = addressController.setAddress(cep, state, city, district, street, houseNumber, complement);
            person = personController.setPerson(name, birth, cpf, this.address, phone1, phone2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        student.setPerson(person);
        student.generateRM();
        studentDAO.persist(student);
    }

    @FXML
    public void setStudentToForm(){

        String name = person.getName();
        String birth = EasyDate.toString(person.getBirthdate());
        String[] phones = (String[]) person.getPhones().toArray();
        String cpf = person.getCpf();
        String cep = address.getCep();
        String state = address.getState();
        String city = address.getCity();
        String district = address.getDistrict();
        String street = address.getStreet();
        String houseNumber = String.valueOf(address.getHouseNumber());
        String complement = address.getComplement();


        nameTextField.setText(name);
        birthTextField.setText(birth);
        cpfTextField.setText(cpf);
        phone1TextField.setText(phones[0]);
        phone2TextField.setText(phones[1]);
        cepTextField.setText(cep);
        stateTextField.setText(state);
        cityTextField.setText(city);
        districtTextField.setText(district);
        streetTextField.setText(street);
        houseNumberTextField.setText(houseNumber);
        complementTextField.setText(complement);
    }


    public boolean updateStudent() throws Exception {
        student = studentDAO.getLastStudent();
        student.getPerson().setName("Jhones Freitas");
        student.getPerson().getAddress().setCity("Caraguatatuba");
        student.getPerson().getPhones().get(0).setNumber("1238848888");

        return studentDAO.update(student);
    }

    @FXML
    public boolean removeStudent(){
        student = studentDAO.getLastStudent();

        return studentDAO.remove(student);
    }


    @Override
    public void setScreenParent(ScreensController screenParent) {
            myController = screenParent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
