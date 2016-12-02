package io.github.printf.educake.controller.base;

import io.github.printf.educake.Educake;
import io.github.printf.educake.controller.ScreensController;
import io.github.printf.educake.util.interfaces.ControlledScreen;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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
        myController = Educake.mainContainer;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void showES() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","EDUCAKE","root");

            String path = "src/main/resources/reports/studentlist.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(path);

            Map<String, Object> param = new HashMap<>();
            param.put("curso", "Espanhol");
            param.put("COURSE", "ES");

            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            JasperViewer.viewReport(jp, false);
            con.close();
        } catch (JRException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void showEN() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","EDUCAKE","root");

            String path = "src/main/resources/reports/studentlist.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(path);

            Map<String, Object> param = new HashMap<>();
            param.put("curso", "Inglês");
            param.put("COURSE", "EN");

            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            JasperViewer.viewReport(jp, false);
            con.close();
        } catch (JRException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void showPT() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","EDUCAKE","root");

            String path = "src/main/resources/reports/studentlist.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(path);

            Map<String, Object> param = new HashMap<>();
            param.put("curso", "Português");
            param.put("COURSE", "PT");

            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            JasperViewer.viewReport(jp, false);
            con.close();
        } catch (JRException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void showDev() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","EDUCAKE","root");

            String path = "src/main/resources/reports/devedores.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(path);

            Map<String, Object> param = new HashMap<>();

            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            JasperViewer.viewReport(jp, false);
            con.close();
        } catch (JRException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
