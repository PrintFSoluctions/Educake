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

    @Column(name = "`name`")
    private String name;

    @Column
    private double value;

    @Column
    @Temporal(TemporalType.DATE)
    private Date due;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idPerson", nullable = false)
    private Person person;

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}