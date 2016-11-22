package io.github.printf.educake;

import io.github.printf.educake.controller.ScreensController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Educake extends Application {

    public static String loginID = "login";
    public static String loginFile = "login.fxml";

//    public static String mainID = "main";
//    public static String mainFile = "main.fxml";
//
//    public static String addStudentID = "addStudent";
//    public static String addStudentFile = "addStudent.fxml";
//
//    public static String addPaymentID = "addPayment";
//    public static String addPaymentFile = "addPayment.fxml";

    @Override
    public void start(Stage primaryStage) {

        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(loginID, loginFile);
//        mainContainer.loadScreen(this.mainID, this.mainFile);
//        mainContainer.loadScreen(this.addStudentID, this.addStudentFile);
//        mainContainer.loadScreen(this.addPaymentID, this.addStudentFile);

        mainContainer.setScreen(loginID);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
