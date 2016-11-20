package io.github.printf.educake.controller;

import io.github.printf.educake.dao.StudentDAO;
import io.github.printf.educake.model.Address;
import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Student;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public class StudentController {

    private StudentDAO studentDAO = new StudentDAO();
    private Student student = new Student();

    Person person = new Person();
    private PersonController personController = new PersonController();

    Address address = new Address();
    private AddressController addressController = new AddressController();


    public boolean persistStudent(){
        // FIXME: Esses valores faltantes devem ser retirados do formulário
        address = addressController.setAddress(cep, state, city, district, street, houseNumber, complement);
        person = personController.setPerson(name, birth, cpf, address, phone1, phone2);

        student.setPerson(personController.setPerson(person));
        student.generateRM();
        return studentDAO.persist(student);
    }

    public boolean updateStudent() throws Exception { // O "q" é só pra mudar a sequencia de execução
        student = studentDAO.getLastStudent();
        student.getPerson().setName("Jhones Freitas");
        student.getPerson().getAddress().setCity("Caraguatatuba");
        student.getPerson().getPhones().get(0).setNumber("1238848888");

        return studentDAO.update(student);
    }

    public boolean removeStudent(){
        student = studentDAO.getLastStudent();

        return studentDAO.remove(student);
    }





}
