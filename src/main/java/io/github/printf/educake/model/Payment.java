package io.github.printf.educake.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jhones Henrique
 */
@Entity
@Table
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYMENT_SEQUENCE")
    @SequenceGenerator(name = "PAYMENT_SEQUENCE", sequenceName = "PAYMENT_SEQUENCE", allocationSize = 1, initialValue = 1)
    @Column
    private Integer idPayment;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column
    private String name;

    @Column
    private double value;

    @Column
    @Temporal(TemporalType.DATE)
    private Date due;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPerson", nullable = false)
    private Person idPerson;

    /**
     * @return the idPayment
     */
    public Integer getIdPayment() {
        return idPayment;
    }

    /**
     * @param idPayment the idPayment to set
     */
    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    /**
     * @return the paymentDate
     */
    public Date getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return the due
     */
    public Date getDue() {
        return due;
    }

    /**
     * @param due the due to set
     */
    public void setDue(Date due) {
        this.due = due;
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

}
