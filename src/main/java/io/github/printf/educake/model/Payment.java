package io.github.printf.educake.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Vitor on 24/09/2016.
 */
@Entity
@Table
public class Payment implements Serializable{

  @Id
  @GeneratedValue
  @Column
  private Integer idPayment;

  @Temporal(TemporalType.TIMESTAMP)
  private Date paymentDate;

  @OneToOne
  @JoinColumn(name = "idInstallment", nullable = false)
  private Installment installment;

  public Payment() {
    this.paymentDate = new Date();
  }

  public Payment(Installment installment) {
    this.paymentDate = new Date();
    this.installment = installment;
  }

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

  public Installment getInstallment() {
    return installment;
  }

  public void setInstallment(Installment installment) {
    this.installment = installment;
    installment.setPayment(this);
  }
}
