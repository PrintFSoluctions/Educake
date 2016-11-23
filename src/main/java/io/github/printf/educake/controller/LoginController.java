package io.github.printf.educake.controller;

import io.github.printf.educake.Educake;
import io.github.printf.educake.dao.LoginDAO;
import io.github.printf.educake.util.interfaces.ControlledScreen;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

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
    public void tryLogin() {
        String username = user.getText();
        String password = pass.getText();

//        dao.persist(new Login(username, password));

        if(dao.tryLogin(username, password)){
            ScreensController mainContainer = new ScreensController();
            mainContainer.loadScreen(Educake.studentID, Educake.studentFile);
            mainContainer.setScreen(Educake.studentID);

            Scene scene = new Scene(mainContainer);
            scene.getStylesheets().add("view/css/components.css");
            Educake.primaryStage.setScene(scene);
            Educake.primaryStage.centerOnScreen();
            Educake.primaryStage.show();
        }
    }

    @FXML
    public void exit(){
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
    }

}
