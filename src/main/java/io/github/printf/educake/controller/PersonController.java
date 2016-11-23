package io.github.printf.educake.controller;

import io.github.printf.educake.model.Address;
import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Phone;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public class PersonController {
    Person person = new Person();

    public Person setPerson(String name,
                            String birth,
                            String cpf,
                            Address address,
                            String... phones) throws Exception {

        person.setName(name);
        person.setBirthdate(birth);
        person.setCpf(cpf);

        for (String phone : phones) {
            if (!(phone.trim()).isEmpty()) {
                person.addPhone(new Phone(phone));
            }
        }

        person.setAddress(address);

        return person;
    }
}
