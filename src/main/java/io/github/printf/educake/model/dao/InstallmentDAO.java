package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.Installment;

import java.util.List;

/**
 * Created by Vitor on 24/09/2016.
 */
public class InstallmentDAO extends DataAccessObject<Installment>{


  @Override
  public List<Installment> findAll() {
    return null;
  }

  @Override
  public Installment getById(Integer id) {
    return null;
  }

  @Override
  public boolean removeById(Integer id) {
    return false;
  }
}
