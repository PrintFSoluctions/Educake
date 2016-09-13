package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.Bill;

import java.util.List;

/**
 *
 * @author Vitor
 */
public class BillDAO extends DataAccessObject{

  @Override
  public List findAll() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Bill getById(Long id) {
    return entityManager.find(Bill.class, id);
  }

  @Override
  public boolean removeById(Long id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}
