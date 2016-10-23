package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.Installment;

import java.util.List;

/**
 * Created by Vitor on 24/09/2016.
 */
public class InstallmentDAO extends DataAccessObject<Installment> {

    @Override
    public List findAll() {
        return getSession().createQuery("FROM Installment").list();
    }

    @Override
    public Installment getById(Integer id) {
        return getSession().load(Installment.class, id);
    }

    @Override
    public boolean removeById(Integer id) {
        boolean result = true;

        try {
            Installment installment = this.getById(id);
            super.remove(installment);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }
}
