package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.Payment;

import java.util.List;

/**
 *
 * @author Vitor
 */
public class PaymentDAO extends DataAccessObject{

  @Override
  public List findAll() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Payment getById(Long id) {
    return entityManager.find(Payment.class, id);
  }

  @Override
  public boolean removeById(Long id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}
