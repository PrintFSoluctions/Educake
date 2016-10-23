package io.github.printf.educake.model;

import javax.persistence.*;
import java.io.Serializable;

import io.github.printf.educake.util.Enums.PhoneType;

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
    
    @Column
    private String ddd;
    
    @Column
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private PhoneType definition;

    public Phone() {}

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

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneType getDefinition() {
        return definition;
    }

    public void setDefinition(PhoneType definition) {
        this.definition = definition;
    }
    
    
}
