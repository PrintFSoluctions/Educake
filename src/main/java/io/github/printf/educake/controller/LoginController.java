package io.github.printf.educake.controller;

import io.github.printf.educake.ScreensController;
import io.github.printf.educake.dao.LoginDAO;
import io.github.printf.educake.view.ControlledScreen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * @author Vitor Silvério de Souza On nov, 2016
 */
public class LoginController implements Initializable, ControlledScreen {

    @FXML
    private TextField user;
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
        String username = user.getText();
        String password = pass.getText();

        return dao.tryLogin(username, password);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
