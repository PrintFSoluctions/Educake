package io.github.printf.educake.view.person.student;

import io.github.printf.educake.view.person.AddressPanel;
import io.github.printf.educake.view.person.PersonPanel;
import io.github.printf.educake.view.person.PhonePanel;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public interface StudentView {
    PhonePanel getPhonesPanel();
    PersonPanel getPersonPanel();
    AddressPanel getAddressPanel();
    int getId();
}
