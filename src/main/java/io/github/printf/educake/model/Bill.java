package io.github.printf.educake.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * @author Vitor "Pliavi" Silvério
 */
@Entity
@Table
public class Bill implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BILL_SEQUENCE")
  @SequenceGenerator(name = "BILL_SEQUENCE", sequenceName = "BILL_SEQUENCE", allocationSize = 1, initialValue = 1)
  @Column
  private long idBill;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "idPerson", nullable = false)
  private Person person;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "idBillType", nullable = false)
  private BillType billType;

  @Column
  @Temporal(TemporalType.DATE)
  private Date openingDate;

  @OneToMany(
      mappedBy = "bill",
      targetEntity = Installment.class,
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL)
  private List<Installment> installments = new ArrayList<Installment>();

  public Bill() {
  }

  public Bill(Person person, BillType billType){
    this.person = person;
    this.billType = billType;
    this.openingDate = new Date();
  }

  public List<Installment> getInstallments() {
    return installments;
  }

  public void setInstallments(ArrayList<Installment> installments) {
    this.installments = installments;
  }

  public void addInstallment(Installment installment){
    installment.setBill(this);
    this.installments.add(installment);
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

  public Date getOpeningDate() {
    return openingDate;
  }

  public void setOpeningDate(Date openingDate) {
    this.openingDate = openingDate;
  }

}
