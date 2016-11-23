
package io.github.printf.educake.model;

import io.github.printf.educake.util.validators.Validator;
import org.apache.commons.lang3.text.WordUtils;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author a1402056
 */

@Entity
@Table
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQUENCE")
    @SequenceGenerator(name = "ADDRESS_SEQUENCE", sequenceName = "ADDRESS_SEQUENCE", allocationSize = 1, initialValue = 1)
    @Column
    private Integer idAddress;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPerson", nullable = false)
    private Person person;

    @Column
    private String street;

    @Column
    private String district;

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

    @Transient
    Validator validator = new Validator();

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = WordUtils.capitalizeFully(street);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws Exception {
        this.city = WordUtils.capitalizeFully(validator.city(city));
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) throws Exception {
        this.cep = validator.cep(cep);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state.toUpperCase();
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) throws Exception {
        this.houseNumber = validator.houseNumber(houseNumber);
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) throws Exception {
        this.district = WordUtils.capitalizeFully(validator.district(district));
    }
}
