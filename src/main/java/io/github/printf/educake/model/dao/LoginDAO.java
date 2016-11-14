/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.printf.educake.model.dao;

import io.github.printf.educake.model.Login;
import io.github.printf.educake.util.BCrypt;
import org.hibernate.Query;

import java.util.List;

/**
 *
 * @author a1402056
 */
public class LoginDAO extends DataAccessObject<Login> {
    Login login = new Login();

    @Override
    public List<Login> findAll() {
        return getSession().createQuery("FROM Login").list();
    }

    public Login getByUser(String user) {
        return getSession().load(Login.class, user);
    }

    public boolean removeByUser(String user) {
        boolean result = true;
        try {
            login = this.getByUser(user);
            super.remove(login);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public boolean tryLogin(String user, String password){
        boolean result = true;

        Query query = getSession().createQuery("FROM Login WHERE user = :user");
        query.setParameter("user", user);

        login = (Login) query.uniqueResult();

        if(login != null){
            result = BCrypt.checkpw(password, login.getPassword());
            System.out.println("senha "+((!result)?"in":"")+"correta");
        }else{
            System.out.println("não existe usuário");
            result = false;
        }

        return result;
    }

    @Override
    public Login getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
