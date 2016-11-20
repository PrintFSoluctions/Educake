/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package io.github.printf.educake.model;

import io.github.printf.educake.util.validators.BCrypt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author a1402056
 */
@Entity
@Table
public class Login {
  @Id
  @Column(name = "`user`")
  private String user;

  @Column(name = "`password`")
  private String password;

  public Login(String user, String password) {
    setUser(user);
    setPassword(password);
  }

  public Login() {}

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    String salt = BCrypt.gensalt(12);
    String hashed_password = BCrypt.hashpw(password, salt);
    this.password = hashed_password;
  }
}
