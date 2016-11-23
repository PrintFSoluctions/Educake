package io.github.printf.educake.controller;

import io.github.printf.educake.dao.StudentDAO;
import io.github.printf.educake.model.Address;
import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Phone;
import io.github.printf.educake.model.Student;
import io.github.printf.educake.util.EasyDate;
import io.github.printf.educake.util.interfaces.ControlledScreen;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public class StudentController implements Initializable, ControlledScreen {

    @FXML
    private TextField
        nameTextField, birthTextField, cpfTextField, phone1TextField, phone2TextField, cepTextField,
        stateTextField,cityTextField, districtTextField, streetTextField, houseNumberTextField,
        complementTextField;
    @FXML
    private Button confirmationButton;
    @FXML
    private Button removeButton;

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
            address = addressController.setAddress(cep, state, city, district, street, houseNumber, complement);
            person = personController.setPerson(name, birth, cpf, address, phone1, phone2);
            student.setPerson(person);
            student.generateRM();
            studentDAO.persist(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void setStudentToForm(int idStudent){

        student = studentDAO.getById(idStudent);
        person = student.getPerson();
        address = person.getAddress();

        String name = person.getName();
        System.out.println(person.getBirthdate());
        String birth = EasyDate.toString(person.getBirthdate());
        List<Phone> phones = person.getPhones();
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
        phone1TextField.setText(phones.get(0).getNumber());
        phone2TextField.setText(phones.get(1).getNumber());
        cepTextField.setText(cep);
        stateTextField.setText(state);
        cityTextField.setText(city);
        districtTextField.setText(district);
        streetTextField.setText(street);
        houseNumberTextField.setText(houseNumber);
        complementTextField.setText(complement);
        confirmationButton.setText("Atualizar");
        confirmationButton.setOnAction(event -> updateStudent(idStudent));
    }


    public void updateStudent(int idStudent) {

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

        student = studentDAO.getById(idStudent);
        person = student.getPerson();
        address = person.getAddress();

        try {
            person.setName(name);
            person.setCpf(cpf);
            person.setBirthdate(birth);
            person.setPhones(phone1, phone2);

            address.setCep(cep);
            address.setState(state);
            address.setCity(city);
            address.setDistrict(district);
            address.setStreet(street);
            address.setHouseNumber(houseNumber);
            address.setComplement(complement);

            studentDAO.update(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // FIXME: Na verdade o id deve ser retirado da tabela
    @FXML
    public void removeStudent(int idStudent){
        studentDAO.remove(studentDAO.getById(idStudent));
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setStudentToForm(1);
    }
}
