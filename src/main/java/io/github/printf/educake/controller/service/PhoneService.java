package io.github.printf.educake.controller.service;

import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.Phone;
import io.github.printf.educake.model.dao.PhoneDAO;
import io.github.printf.educake.util.Enums.PhoneType;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Albino Freitas
 */
public class PhoneService {

    private final ArrayList<Phone> phones;
    private final PhoneDAO phoneDAO;

    public PhoneService() {
        this.phoneDAO = new PhoneDAO();
        this.phones = new ArrayList();
    }

    public void setPhones(List<String> phones, List<String> types) throws Exception {
        validatePhones(phones, types);
    }

    public void setPhones(Person person, List<String> phones, List<String> types) throws Exception {
        if (validatePhones(phones, types)) {
            for (Phone phone : this.phones) {
                phone.setPerson(person);
            }
        }
    }

    public ArrayList<Phone> getPhones() {
        return this.phones;
    }

    //Private Methods
    private boolean validatePhones(List<String> phones, List<String> types) throws Exception {
        Phone phone;

        if (phones.size() == types.size()) {
            for (int i = 0; i < phones.size(); i++) {
                phone = new Phone();
                String number = phones.get(i).trim();

                if (number.length() < 10) {
                    throw new Exception("Telefone fora do padrão - (DD)NNNN-NNNN");
                }

                phone.setDdd(number.substring(0, 2));
                phone.setPhoneNumber(number.substring(2));

                String phoneType = types.get(i);

                switch (phoneType) {
                    case "Fixo":
                        phone.setDefinition(PhoneType.T);
                        break;
                    case "Celular":
                        phone.setDefinition(PhoneType.C);
                        break;
                    default:
                        throw new Exception("Tipo ");
                }

                this.phones.add(phone);

            }
        }

        return true;
    }
}
