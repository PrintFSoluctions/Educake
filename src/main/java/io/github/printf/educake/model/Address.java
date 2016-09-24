/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.printf.educake.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author a1402056
 */

@Entity
@Table
public class Address implements Serializable {
    @Id
    @GeneratedValue
    @Column
    private Integer idAddress;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPerson", nullable = false)
    private Person idPerson;
    
    @Column
    private String street;
    
    @Column
    private String city;
    
    @Column
    private String cep;
    
    @Column
    private String state;
    
    @Column
    private Integer houseNumber;
    
    @Column
    private String complement;

    /**
     * @return the idAddress
     */
    public Integer getIdAddress() {
        return idAddress;
    }

    /**
     * @param idAddress the idAddress to set
     */
    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    /**
     * @return the idPerson
     */
    public Person getIdPerson() {
        return idPerson;
    }

    /**
     * @param idPerson the idPerson to set
     */
    public void setIdPerson(Person idPerson) {
        this.idPerson = idPerson;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the houseNumber
     */
    public Integer getHouseNumber() {
        return houseNumber;
    }

    /**
     * @param houseNumber the houseNumber to set
     */
    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * @return the complement
     */
    public String getComplement() {
        return complement;
    }

    /**
     * @param complement the complement to set
     */
    public void setComplement(String complement) {
        this.complement = complement;
    }
}
