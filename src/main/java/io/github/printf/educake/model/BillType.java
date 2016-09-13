package io.github.printf.educake.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** @author Vitor "Pliavi" Silvério */

@Entity
@Table        
public class BillType implements Serializable {
  @Id
  @GeneratedValue
  @Column private long idBillType;
  
  @Column(name = "name") private String typeName;

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

  public String getName() {
    return typeName;
  }

  public void setName(String name) {
    this.typeName = name;
  }
  
  
}
