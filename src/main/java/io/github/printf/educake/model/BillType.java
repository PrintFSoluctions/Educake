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
  @Column private int idBillType;
  
  @Column(name = "name") private String typeName;

  public BillType(String type) {
    this.typeName = type;
  }

  public int getIdBillType() {
    return idBillType;
  }

  public void setIdBillType(int idBillType) {
    this.idBillType = idBillType;
  }

  public String getName() {
    return typeName;
  }

  public void setName(String name) {
    this.typeName = name;
  }
  
  
}
