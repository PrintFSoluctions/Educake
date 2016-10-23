/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.Phone;
import java.util.List;

/**
 *
 * @author AlbinoFreitas
 */
public class PhoneDAO extends DataAccessObject<Phone>{

    @Override
    public List findAll() {
        return getSession().createQuery("FROM Phone").list();
    }

    @Override
    public Phone getById(Integer id) {
        return getSession().load(Phone.class, id);
    }

    @Override
    public boolean removeById(Integer id) {
        boolean result = true;

        try {
            Phone phone = this.getById(id);
            super.remove(phone);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    public void removeAllPhones(int idPerson) {

    }
}
