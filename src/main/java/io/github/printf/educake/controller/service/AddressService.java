package io.github.printf.educake.controller.service;

import io.github.printf.educake.model.Address;
import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.dao.AddressDAO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Albino Freitas On out, 2016
 */
// TODO: A classe completa
public class AddressService {

    private final Address address;
    private final AddressDAO addressDAO;

    public AddressService() {
        address = new Address();
        addressDAO = new AddressDAO();
    }

    //With person and complement
    public void setAddress(Person person, String district, String street, String housenumber,
                           String complement, String city, String cep, String state) throws Exception {
        this.address.setPerson(person);
        this.address.setDistrict(district);
        this.address.setStreet(street);
        validateHouseNumber(housenumber);
        this.address.setComplement(complement);
        validateCity(city);
        validateCep(cep);
        this.address.setState(state);
    }

    //With person and without complement
    public void setAddress(Person person, String district, String street, String housenumber,
                           String city, String cep, String state) throws Exception {
        this.address.setPerson(person);
        this.address.setDistrict(district);
        this.address.setStreet(street);
        validateHouseNumber(housenumber);
        validateCity(city);
        validateCep(cep);
        this.address.setState(state);
    }

    //Without person and with complement
    public void setAddress(String district, String street, String housenumber, String complement,
                           String city, String cep, String state) throws Exception {
        this.address.setDistrict(district);
        this.address.setStreet(street);
        validateHouseNumber(housenumber);
        this.address.setComplement(complement);
        validateCity(city);
        validateCep(cep);
        this.address.setState(state);
    }

    //Without person and complement
    public void setAddress(String district, String street, String housenumber, String city,
                           String cep, String state) throws Exception {
        this.address.setDistrict(district);
        this.address.setStreet(street);
        validateHouseNumber(housenumber);
        validateCity(city);
        validateCep(cep);
        this.address.setState(state);
    }

    public Address getAddress() {
        return this.address;
    }

    public boolean persist() {
        return addressDAO.persist(this.address);
    }

    //Private Methods

    private void validateCity(String city) throws Exception {
        String regx = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        city = city.trim();
        Matcher matcherCity = pattern.matcher(city);

        if (!matcherCity.find()) {
            throw new Exception("Cidade é inválida ou está vazia");
        }

        this.address.setCity(city);
    }

    private void validateCep(String cep) throws Exception {
        String regx = "^\\d{5,5}-?\\d{3,3}$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        cep = cep.trim();
        Matcher matcherCep = pattern.matcher(cep);

        if (!matcherCep.find()) {
            throw new Exception("Cep é inválido ou está vazio");
        }

        this.address.setCep(cep);
    }

    private void validateHouseNumber(String houseNumber) throws Exception {
        try {
            int hn = Integer.parseInt(houseNumber);
            if(hn >= 0)
                this.address.setHouseNumber(hn);
            else
                throw new Exception("Número da casa deve ser positivo");
        } catch (NumberFormatException e) {
            throw new Exception("Número da casa não pode conter letras ou caracteres especiais");
        }
    }
}
