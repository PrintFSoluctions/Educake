package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.Bill;

import java.util.List;

/**
 *
 * @author Albino Freitas
 */
public class BillDAO extends DataAccessObject<Bill> {

    @Override
    public List findAll() {
        return getSession().createQuery("FROM Bill").list();
    }

    @Override
    public Bill getById(Integer id) {
        return getSession().load(Bill.class, id);
    }

    @Override
    public boolean removeById(Integer id) {
        boolean result = true;

        try {
            Bill bill = this.getById(id);
            super.remove(bill);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }
}
