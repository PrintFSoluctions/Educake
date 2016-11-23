package io.github.printf.educake.model;

import io.github.printf.educake.util.validators.Validator;
import org.apache.commons.lang3.text.WordUtils;

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

  @Transient
  private Validator validator = new Validator();

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
    this.name = WordUtils.capitalizeFully(validator.name(name));
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

  public void setPhones(String phone1, String phone2) {
    try {
      this.phones.set(0, new Phone(phone1));
      if(!phone2.trim().isEmpty()){
        this.phones.set(1, new Phone(phone2));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
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
