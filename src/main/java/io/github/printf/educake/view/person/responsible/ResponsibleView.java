/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.printf.educake.view.person.responsible;

import io.github.printf.educake.controller.ResponsibleController;
import io.github.printf.educake.util.Components.DefaultView;
import io.github.printf.educake.view.person.AddressPanel;
import io.github.printf.educake.view.person.PersonPanel;
import io.github.printf.educake.view.person.PhonePanel;
import io.github.printf.educake.view.person.student.StudentView;

import javax.swing.*;

/**
 *
 * @author a1402056
 */
public class ResponsibleView extends DefaultView {
  private PhonePanel phonesPanel = new PhonePanel();
  private PersonPanel personPanel = new PersonPanel();
  private AddressPanel addressPanel = new AddressPanel();

  private ResponsibleController responsibleController = new ResponsibleController();

  public ResponsibleView(StudentView studentView) {
    super("Resposável", "Confirmar");

    try {
      phonesPanel = studentView.getPhonesPanel().clone();
      addressPanel = studentView.getAddressPanel().clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }

    body.add(personPanel);
    body.add(phonesPanel);
    body.add(addressPanel);
    titlePanel.getButton("Confirmar").addActionListener(responsibleController.persist());
    responsibleController.setView(this);
}

  public PhonePanel getPhonesPanel() {
    return (PhonePanel)phonesPanel;
  }

	public PersonPanel getPersonPanel() {
		return (PersonPanel)personPanel;
	}

  public AddressPanel getAddressPanel() {
    return (AddressPanel)addressPanel;
  }

  @Override
  public JPanel[] getPanels() {
    return null;
  }
}

