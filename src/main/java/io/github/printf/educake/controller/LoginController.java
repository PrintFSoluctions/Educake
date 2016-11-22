package io.github.printf.educake.controller;

import io.github.printf.educake.dao.LoginDAO;
import io.github.printf.educake.util.interfaces.ControlledScreen;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Vitor Silvério de Souza On nov, 2016
 */
public class LoginController implements Initializable, ControlledScreen {

    @FXML
    private TextField user, tel;
    @FXML
    private PasswordField pass;
    ScreensController myController;
    LoginDAO dao = new LoginDAO();

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @FXML
    public boolean tryLogin() {
        System.out.println(tel.getText());
        String username = user.getText();
        String password = pass.getText();

//        Login login = new Login(username, password);
//        dao.persist(login);
        return dao.tryLogin(username, password);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
    }

}
