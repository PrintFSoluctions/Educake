package io.github.printf.educake.model;

import io.github.printf.educake.util.EnumPhone;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Albino Freitas
 */

@Entity
@Table
public class Phone implements Serializable{
    
    @Id
    @GeneratedValue
    @Column
    private Integer idPhone;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPerson", nullable = false)
    private Person person;
    
    @Column
    private String ddd;
    
    @Column
    private String phoneNumber;
    
    @Column
    private String operator;
    
    @Enumerated(EnumType.STRING)
    private EnumPhone definition;

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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public EnumPhone getDefinition() {
        return definition;
    }

    public void setDefinition(EnumPhone definition) {
        this.definition = definition;
    }
    
    
}
