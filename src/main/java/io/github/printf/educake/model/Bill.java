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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Vitor "Pliavi" Silvério
 */
@Entity
@Table
public class Bill implements Serializable {

  @Id
  @GeneratedValue
  @Column
  private Long idBill;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "idPerson", nullable = false)
  private Person person;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "idBillType", nullable = false)
  private BillType billType;

  @Column
  private float value;

  @Column
  @Temporal(TemporalType.DATE)
  private Date firstInstallment;

  @Column
  private int installments = 1;

  @Column
  @Temporal(TemporalType.DATE)
  private Date due;

  public Bill() {
  }

  public Long getIdBill() {
    return idBill;
  }

  public void setIdBill(Long idBill) {
    this.idBill = idBill;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public BillType getBillType() {
    return billType;
  }

  public void setBillType(BillType billType) {
    this.billType = billType;
  }

  public float getValue() {
    return value;
  }

  public void setValue(float value) {
    this.value = value;
  }

  public Date getFirstInstallment() {
    return firstInstallment;
  }

  public void setFirstInstallment(Date firstInstallment) {
    this.firstInstallment = firstInstallment;
  }

  public int getInstallments() {
    return installments;
  }

  public void setInstallments(int installments) {
    this.installments = installments;
  }

  public Date getDue() {
    return due;
  }

  public void setDue(Date due) {
    this.due = due;
  }

}
