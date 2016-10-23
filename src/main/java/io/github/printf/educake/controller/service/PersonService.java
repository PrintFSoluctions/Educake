package io.github.printf.educake.controller.service;

import io.github.printf.educake.model.Address;
import io.github.printf.educake.model.CPF;
import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Phone;
import io.github.printf.educake.model.dao.PersonDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vitor on 02/10/2016.
 */
public class PersonService {

    private final Person person;
    private final PersonDAO personDAO;

    public PersonService() {
        this.person = new Person();
        this.personDAO = new PersonDAO();
    }

    public void setPerson(String name, String surname, String birthDate) throws Exception {
        validateNameAndSurname(name, surname);
        validateDate(birthDate);
    }

    public Person getPerson() {
        return this.person;
    }

    public void addPhone(Phone phone) {
        this.person.addPhone(phone);
    }

    public void addPhones(ArrayList<Phone> phones) {
        this.person.setPhones(phones);
    }
    
    public void setAddress(Address address){
        this.person.setAddress(address);
    }
    
    public void setCPF(CPF cpf){
        this.person.setCpf(cpf);
    }

    public boolean persist() {
        return personDAO.persist(this.person);
    }

    //Private Methods
    private boolean validateNameAndSurname(String name, String surname) throws Exception {
        String regx = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        name = name.trim();
        surname = surname.trim();
        Matcher matcherName = pattern.matcher(name);
        Matcher matcherSurname = pattern.matcher(surname);

        if (!matcherName.find()) {
            throw new Exception("Nome é inválido ou está vazio");
        }

        if (!matcherSurname.find()) {
            throw new Exception("Sobrenome é inválido ou está vazio");
        }

        this.person.setName(name);
        this.person.setSurname(surname);
        return true;
    }

    private boolean validateDate(String birthDate) throws ParseException {
        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            date = sdf.parse(birthDate);
        } catch (ParseException ex) {
            throw new ParseException("Data fora do padrão - DD/MM/AAAA", ex.getErrorOffset());
        }

        this.person.setBirthdate(date);

        return true;
    }
}
