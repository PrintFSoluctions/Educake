package io.github.printf.educake.controller;

import io.github.printf.educake.model.Address;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public class AddressController {
    Address address = new Address();

    public Address setAddress(String cep,
                              String state,
                              String city,
                              String district,
                              String street,
                              String houseNumber,
                              String complement) throws Exception {

        address.setCep(cep);
        address.setState(state.toUpperCase());
        address.setCity(city);
        address.setDistrict(district);
        address.setStreet(street);
        address.setHouseNumber(houseNumber);
        address.setComplement(complement);

        return address;
    }

}
