package io.github.printf.educake.dao;

import io.github.printf.educake.model.Address;

import java.util.List;

/**
 *
 * @author a1402056
 */
public class AddressDAO extends DataAccessObject<Address>{

    @Override
    public List findAll() {
        return getSession().createQuery("FROM Address").list();
    }

    @Override
    public Address getById(Integer id) {
        return getSession().load(Address.class, id);
    }

    @Override
    public boolean removeById(Integer id) {
        boolean result = true;

        try {
            Address address = this.getById(id);
            super.remove(address);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }
}
