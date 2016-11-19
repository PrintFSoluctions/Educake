/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.Phone;
import org.hibernate.Query;

import java.util.ArrayList;

/**
 *
 * @author AlbinoFreitas
 */
public class PhoneDAO extends DataAccessObject<Phone>{

    @Override
    public ArrayList<Phone> findAll() {
        return (ArrayList<Phone>) getSession().createQuery("FROM Phone").list();
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

    public ArrayList<Phone> getByIdPerson(int id) {
        Query query = getSession().createQuery("FROM Phone WHERE idPerson = :id");
        query.setParameter("id", id);

        return (ArrayList<Phone>) query.list();
    }

    public void deleteByIdPerson(int id){
        getByIdPerson(id).forEach(phone -> getSession().delete(phone));
    }
}
