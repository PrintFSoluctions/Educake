package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.Payment;

import java.util.List;

/**
 * Created by Vitor on 24/09/2016.
 */
public class PaymentDAO extends DataAccessObject<Payment> {

    @Override
    public List findAll() {
        return getSession().createQuery("FROM Payment").list();
    }

    @Override
    public Payment getById(Integer id) {
        return getSession().load(Payment.class, id);
    }

    @Override
    public boolean removeById(Integer id) {
        boolean result = true;

        try {
            Payment payment = this.getById(id);
            super.remove(payment);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }
}
