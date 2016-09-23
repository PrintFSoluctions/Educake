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
public class Installment implements Serializable {

  @Id
  @Column
  @GeneratedValue
  private long idPayment;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "idBill", nullable = false)
  private Bill bill;

  @Column
  private Double value;

  @Column
  @Temporal(TemporalType.DATE)
  private Date dueDate;

  public Installment() {
  }

  public Installment(Bill bill, Double value, Date dueDate) {
    this.bill = bill;
    this.value = value;
    this.dueDate = dueDate;
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

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  
  
}
