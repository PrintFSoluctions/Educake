package io.github.printf.educake.model;

import io.github.printf.educake.util.validators.Validator;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author Vitor "Pliavi" Silvério
*/
@Entity
@Table
public class Person implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQUENCE")
  @SequenceGenerator(name = "PERSON_SEQUENCE", sequenceName = "PERSON_SEQUENCE", allocationSize = 1, initialValue = 1)
  @Column
  private Integer idPerson;

  @Column
  private String name;

  @Column
  private String cpf;

  @Column
  @Temporal(TemporalType.DATE)
  private Date birthdate;

  @OneToMany(
  mappedBy = "person",
  targetEntity = Phone.class,
  fetch = FetchType.LAZY,
  cascade = CascadeType.ALL)
  private List<Phone> phones = new ArrayList<Phone>();

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
  private Address address;

  Validator validator = new Validator();

  public Person() {}

    public int getIdPerson() {
      return idPerson;
    }

    public void setIdPerson(int idPerson) {
      this.idPerson = idPerson;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) throws Exception {
      this.name = validator.name(name);
    }

    public String getCpf() {
      return cpf;
    }

    public void setCpf(String cpf) throws Exception {
      this.cpf = validator.cpf(cpf);
    }

    public Date getBirthdate() {
      return birthdate;
    }

    public void setBirthdate(String birthdate) throws ParseException {
      this.birthdate = validator.birthDate(birthdate);
    }

    public void setPhones(List<Phone> phones) {
      this.phones = phones;
      phones.stream().forEach((phone) -> {
        phone.setPerson(this);
      });
    }

    public List<Phone> getPhones() {
      return phones;
    }

    public void addPhone(Phone phone) {
      phone.setPerson(this);
      phones.add(phone);
    }

    public Address getAddress() {
      return address;
    }

    public void setAddress(Address address) {
      address.setPerson(this);
      this.address = address;
    }

  }
