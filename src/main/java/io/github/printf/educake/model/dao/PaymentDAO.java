package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.Payment;

import java.util.List;

/**
 * Created by Vitor on 24/09/2016.
 */
public class PaymentDAO extends DataAccessObject<Payment> {

  @Override
  public List<Payment> findAll() {
    return null;
  }

  @Override
  public Payment getById(Integer id) {
    return null;
  }

  @Override
  public boolean removeById(Integer id) {
    return false;
  }
}
