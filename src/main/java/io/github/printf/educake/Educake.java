package io.github.printf.educake;

import io.github.printf.educake.controller.ScreensController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Educake extends Application {

    public static Stage primaryStage;
    public static ScreensController mainContainer = new ScreensController();
    public static String activeScreen = "";

    public static String studentID = "student";
    public static String studentFile = "student.fxml";

    public static String studentDashID = "studentDash";
    public static String studentDashFile = "studentDash.fxml";

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader myLoader;
        VBox login = null;

        try {
        myLoader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
            login = myLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(login);
        Educake.primaryStage = primaryStage;
        Educake.primaryStage.setScene(scene);
        Educake.primaryStage.show();
        primaryStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
