package io.github.printf.educake.model;

import javax.persistence.*;
import java.io.Serializable;
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
    private String surname;

    @Column
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @OneToMany(
            mappedBy = "person",
            targetEntity = Phone.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Phone> phones = new ArrayList<Phone>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CPF cpf;

    public Person() {
    }

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

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        cpf.setPerson(this);
        this.cpf = cpf;
    }
    
    
}
