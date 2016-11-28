package io.github.printf.educake.controller.base;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public class ErrorDialogController implements Initializable{

    @FXML
    private Button okButton;
    @FXML
    private Label messageLabel, detailsLabel;

    public void setDialog(String message, String details){
        setMessage(message);
        setDetails(details);
    }

    public void setDetails(String detailsLabel) {
        this.detailsLabel.setText(detailsLabel);
    }

    public void setMessage(String messageLabel) {
        this.messageLabel.setText(messageLabel);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void close(ActionEvent actionEvent) {
    }

    public void setOkButtonAction(EventHandler<ActionEvent> e) {
        this.okButton.setOnAction(e);
    }
}
