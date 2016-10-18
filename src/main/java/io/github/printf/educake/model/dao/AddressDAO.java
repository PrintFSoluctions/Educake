package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.Address;
import io.github.printf.educake.model.Student;
import static io.github.printf.educake.model.dao.DataAccessObject.getSession;
import java.util.List;

/**
 *
 * @author a1402056
 */
public class AddressDAO extends DataAccessObject{

    @Override
    public List findAll() {
        return getSession().createQuery("FROM Address").list();
    }

    @Override
    public Object getById(Integer id) {
        return getSession().load(Address.class, id);
    }

    @Override
    public boolean removeById(Integer id) {
        boolean result = true;

        try {
            Address address = (Address) this.getById(id);
            super.remove(address);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }
}
