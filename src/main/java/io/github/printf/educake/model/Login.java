/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.printf.educake.model;

import io.github.printf.educake.util.BCrypt;

import javax.persistence.*;

/**
 *
 * @author a1402056
 */
@Entity
@Table
public class Login {
    @Id
     @Column(name = "`name`")
    private String user;

    @Column(name = "`password`")
    private String password;

    public Login() {
    }

    public Login(String user, String password) {
        this.user = user;

        String salt = BCrypt.gensalt(12);
        String hashed_password = BCrypt.hashpw(password, salt);
        System.out.println(hashed_password);

        this.password = hashed_password;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


}
