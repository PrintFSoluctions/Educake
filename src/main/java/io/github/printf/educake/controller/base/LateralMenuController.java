package io.github.printf.educake.controller.base;

import io.github.printf.educake.Educake;
import io.github.printf.educake.controller.ScreensController;
import io.github.printf.educake.util.interfaces.ControlledScreen;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public class LateralMenuController  implements Initializable, ControlledScreen {
    ScreensController myController;

    @FXML
    private Button aluno;

    @FXML
    private void goToAluno(){
        myController.setScreen(Educake.studentDashID);
    }


    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
