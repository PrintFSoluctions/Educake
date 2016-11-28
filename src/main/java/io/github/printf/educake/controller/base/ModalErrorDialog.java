package io.github.printf.educake.controller.base;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public class ModalErrorDialog {
    private Stage stage;
    private ErrorDialogController errorDialog;

    public ModalErrorDialog(String message, String details) {
        init();
        stage.setTitle("Hm... Algo deu errado!");
        errorDialog.setDialog(message, details);
        stage.show();
    }

    public ModalErrorDialog(String title, String message, String details) {
        init();
        stage.setTitle(title);
        errorDialog.setDialog(message, details);
        stage.show();
    }

    private void init() {
        try {
            stage = new Stage();
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/view/base/errorDialog.fxml"));
            Parent root = myLoader.load();
            errorDialog = myLoader.getController();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.setResizable(false);
            errorDialog.setOkButtonAction(e -> stage.close());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
