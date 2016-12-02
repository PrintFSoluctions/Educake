package io.github.printf.educake.dao;

import io.github.printf.educake.model.Payment;

import java.util.List;

/**
 * Created by Vitor on 24/09/2016.
 */
public class PaymentDAO extends DataAccessObject<Payment> {

    @Override
    public List findAll() {
        return getSession().createQuery("FROM Payment WHERE activated = 1").list();
    }

    @Override
    public Payment getById(Integer id) {
        return (Payment) getSession().createQuery("FROM Payment WHERE activated = 1 AND idPayment = "+id).list().get(0);
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