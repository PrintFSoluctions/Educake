package io.github.printf.educake.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/** @author Vitor "Pliavi" Silvério*/

@Entity
@Table
public class Installment implements Serializable {

  @Id
  @Column
  @GeneratedValue
  private Integer idInstallment;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idBill", nullable = false)
  private Bill bill;

  @Column
  private Double value;

  @Column
  @Temporal(TemporalType.DATE)
  private Date dueDate;

  @Transient
  @OneToOne
  private Payment payment;

  public Installment() {
  }

  public Installment(Bill bill, Double value, Date dueDate) {
    this.bill = bill;
    this.value = value;
    this.dueDate = dueDate;
  }

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
    payment.setInstallment(this);
  }

  public Integer getIdInstallment() {
    return idInstallment;
  }

  public void setIdInstallment(Integer idInstallment) {
    this.idInstallment = idInstallment;
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
