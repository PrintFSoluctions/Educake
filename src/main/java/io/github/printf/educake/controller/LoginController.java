package io.github.printf.educake.controller;

import io.github.printf.educake.dao.LoginDAO;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public class LoginController {

    LoginDAO dao = new LoginDAO();

    public boolean tryLogin(String user, String pass){
        return dao.tryLogin(user, pass);
    }

}
