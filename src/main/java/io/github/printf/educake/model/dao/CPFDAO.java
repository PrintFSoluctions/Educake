package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.CPF;

import java.util.List;

/**
 *
 * @author Albino Freitas
 */
public class CPFDAO extends DataAccessObject<CPF> {

    @Override
    public List<CPF> findAll() {
        return getSession().createQuery("FROM CPF").list();
    }

    @Override
    public CPF getById(Integer id) {
        return getSession().load(CPF.class, id);
    }

    @Override
    public boolean removeById(Integer id) {
        boolean result = true;

        try {
            CPF cpf = this.getById(id);
            super.remove(cpf);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

}
