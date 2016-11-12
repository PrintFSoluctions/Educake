package io.github.printf.educake.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/** @author Vitor "Pliavi" Silvério*/

@Entity
@Table
public class Installment implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSTALLMENT_SEQUENCE")
  @SequenceGenerator(name = "INSTALLMENT_SEQUENCE", sequenceName = "INSTALLMENT_SEQUENCE", allocationSize = 1, initialValue = 1)
  @Column
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
//    payment.setInstallment(this);
    this.payment = payment;
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
