package io.github.printf.educake.controller.base;

import io.github.printf.educake.controller.ScreensController;
import io.github.printf.educake.util.interfaces.ControlledScreen;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public class HeaderController implements Initializable, ControlledScreen {
    ScreensController myController;

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
