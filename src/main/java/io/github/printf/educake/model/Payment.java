package io.github.printf.educake.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** @author Vitor "Pliavi" Silvério*/

@Entity
@Table
public class Payment implements Serializable {

  @Id
  @GeneratedValue
  @Column
  private long idPayment;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "idBill", nullable = false)
  private Bill bill;

  @Column
  private float value;

  @Column
  @Temporal(TemporalType.DATE)
  private Date paymentDate;

  public Payment() {
  }

  public long getIdPayment() {
    return idPayment;
  }

  public void setIdPayment(long idPayment) {
    this.idPayment = idPayment;
  }

  public Bill getBill() {
    return bill;
  }

  public void setBill(Bill bill) {
    this.bill = bill;
  }

  public float getValue() {
    return value;
  }

  public void setValue(float value) {
    this.value = value;
  }

  public Date getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }

  
  
}
