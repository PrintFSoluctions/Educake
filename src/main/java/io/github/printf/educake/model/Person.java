package io.github.printf.educake.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** @author Vitor "Pliavi" Silvério */

@Entity
@Table
public class Person implements Serializable {
  
  @Id
  @GeneratedValue
  @Column
  private int idPerson;

  @Column
  private String name;

  @Column
  private String surname;

  @Column
  @Temporal(TemporalType.DATE)
  private Date birthdate;
  
  @OneToMany(
      mappedBy = "person",
      targetEntity = Phone.class,
      fetch = FetchType.LAZY,
      cascade = CascadeType.ALL)
  private List<Phone> phones = new ArrayList<>();

  public Person() {}

  public Person(String name, String surname, Date birthdate) {
    this.name = name;
    this.surname = surname;
    this.birthdate = birthdate;
  }

  public int getIdPerson() {
    return idPerson;
  }

  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }
  
  public void addPhone(Phone phone){
      phones.add(phone);
  }
  
  
}
