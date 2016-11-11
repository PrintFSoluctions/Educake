package io.github.printf.educake.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/** @author Vitor "Pliavi" Silvério */

@Entity
@Table        
public class BillType implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BILLTYPE_SEQUENCE")
  @SequenceGenerator(name = "BILLTYPE_SEQUENCE", sequenceName = "BILLTYPE_SEQUENCE", allocationSize = 1, initialValue = 1)
  @Column private long idBillType;
  
  @Column(name = "name") private String typeName;

  @OneToMany(
      mappedBy = "billType",
      targetEntity = Bill.class,
      fetch = FetchType.LAZY,
      cascade = CascadeType.ALL)
  private List<Bill> bills = new ArrayList<Bill>();

  public BillType() {
  }

  public BillType(String type) {
    this.typeName = type;
  }

  public long getIdBillType() {
    return idBillType;
  }

  public void setIdBillType(long idBillType) {
    this.idBillType = idBillType;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public void addBill(Bill bill){
    bill.setBillType(this);
    this.bills.add(bill);
  }

  public List<Bill> getBills() {
    return bills;
  }
}
