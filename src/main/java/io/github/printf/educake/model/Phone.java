package io.github.printf.educake.model;

import io.github.printf.educake.util.validators.Validator;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Albino Freitas
 */

@Entity
@Table
public class Phone implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PHONE_SEQUENCE")
    @SequenceGenerator(name="PHONE_SEQUENCE", sequenceName = "PHONE_SEQUENCE", allocationSize = 1,initialValue = 1)
    @Column
    private Integer idPhone;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPerson", referencedColumnName="idPerson", nullable = false)
    private Person person;

    @Column(name="`number`")
    private String number;

    @Transient
    Validator validator = new Validator();
    
    public Phone() {}

    public Phone(String number) throws Exception {
        this.number = validator.phone(number);
    }

    public Integer getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(Integer idPhone) {
        this.idPhone = idPhone;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) throws Exception {
        this.number = validator.phone(number);
    }

}
