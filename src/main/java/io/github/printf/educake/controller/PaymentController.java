package io.github.printf.educake.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import io.github.printf.educake.Educake;
import io.github.printf.educake.controller.base.ModalErrorDialog;
import io.github.printf.educake.dao.PaymentDAO;
import io.github.printf.educake.model.Payment;
import io.github.printf.educake.model.Student;
import io.github.printf.educake.util.EasyDate;
import io.github.printf.educake.util.components.MaskField;
import io.github.printf.educake.util.interfaces.ControlledScreen;
import io.github.printf.educake.util.validators.Validator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */
public class PaymentController implements Initializable, ControlledScreen {

    @FXML
    private JFXButton confirmationButton;
    @FXML
    private TableView<Payment> paymentsTable;
    @FXML
    private JFXTextField searchTextField;
    @FXML
    private JFXCheckBox installmentsCheck;
    @FXML
    private JFXTextField nameTextField, valueTextField, monthsTextField;
    @FXML
    private MaskField dueTextField;
    @FXML
    private HBox installments, form;

    private PaymentDAO dao = new PaymentDAO();
    private PaymentDAO studentDAO = new PaymentDAO();
    private FilteredList<Payment> paymentsFiltered;

    private static Student student;
    private ObservableList<Payment> payments;

    private ScreensController myController;
    private Validator validator = new Validator();

    @FXML
    public void persistPendencies() {
        try {
            Payment payment;
            GregorianCalendar gc = new GregorianCalendar();

            String name = nameTextField.getText();
            String value = valueTextField.getText();
            int months = (installmentsCheck.isSelected())?validator.integer(monthsTextField.getText()) : 1;
            Date due = validator.date(dueTextField.getText());
            gc.setTime(due);

            for (int i = 0; i < months; i++) {
                payment = new Payment();
                payment.setName(name);
                payment.setValue(value);
                payment.setDue(gc.getTime());
                System.out.println(PaymentController.student.getPerson().getName());
                payment.setPerson(PaymentController.student.getPerson());
                gc.set(Calendar.MONTH, gc.get(Calendar.MONTH)+1);
                student.getPerson().addPayment(payment);
                dao.persist(payment);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        myController.setScreen(Educake.paymentDashID);
            
    }


    public void updateTable(){
        System.out.println(searchTextField.getText());
    searchTextField.setText(" ");
        searchTextField.setText("");
    }
    
    public void setStudent(Student student) {
        PaymentController.student = student;

        payments = FXCollections.observableArrayList(student.getPerson().getPayments());
        paymentsTable.setItems(payments);
        paymentsFiltered = new FilteredList<>(payments, p -> true);
        paymentsFiltered.setPredicate(payment -> true);

        searchTextField.textProperty().addListener((observable, oldValue, newValue) ->
            paymentsFiltered.setPredicate(payment -> {

                if(!payment.isActivated()){
                return false;
                }
                
                // Se o texto do campo estiver vazio, mostra todos (tudo bate com o vazio)
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                String date = EasyDate.toString(payment.getDue()).split("/")[1];

                if (date.toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Caso o mês bata
                }

                return false; // Caso nada bata, remove da lista
            }));

        paymentsTable.setItems(paymentsFiltered);
        paymentsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        if (paymentsTable.getColumns().size() == 0) {
            TableColumn<Payment, String> typeColumn = new TableColumn<>("Conta");
            TableColumn<Payment, String> dueColumn = new TableColumn<>("Vencimento");
            TableColumn<Payment, String> paymentDateColumn = new TableColumn<>("Data de Pagamento");

            typeColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            dueColumn.setCellValueFactory(new PropertyValueFactory<>("stringDue"));
            paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("stringPaymentDate"));

            typeColumn.prefWidthProperty().bind(paymentsTable.widthProperty().multiply(0.1));
            paymentDateColumn.prefWidthProperty().bind(paymentsTable.widthProperty().multiply(2));
            dueColumn.prefWidthProperty().bind(paymentsTable.widthProperty().multiply(2));

            dueColumn.setMaxWidth(100);
            paymentDateColumn.setMaxWidth(250);

            dueColumn.setMinWidth(100);
            paymentDateColumn.setMinWidth(250);


            paymentsTable.getColumns().addAll(typeColumn, dueColumn, paymentDateColumn);
        }

    }

    public void activateInstallments() {
        installments.setDisable(!installmentsCheck.isSelected());
    }

    public void pay() {
        if (paymentsTable.getSelectionModel().getSelectedIndex() >= 0) {
            Payment payment = paymentsTable.getSelectionModel().getSelectedItem();
            payment.setPaymentDate(new Date(System.currentTimeMillis()));
            dao.update(payment);
        } else {
            new ModalErrorDialog("Selecione um aluno", "É necessário selecionar um aluno antes de tentar atualizá-lo.");
        }
updateTable();
            
    }

    public void goToNewPayment() {
        Educake.activeScreen = "";

        Educake.mainContainer.unloadScreen(Educake.paymentID);
        Educake.mainContainer.loadScreen(Educake.paymentID, Educake.paymentFile);
        Educake.mainContainer.setScreen(Educake.paymentID);

        if (nameTextField != null) {
            nameTextField.setText("");
            valueTextField.setText("");
            dueTextField.setText("");
            monthsTextField.setText("");
            installmentsCheck.setSelected(false);
            activateInstallments();

            confirmationButton.setText("Cadastrar");
            confirmationButton.setOnAction(event -> persistPendencies());
        }
    }

    public void setPaymentToForm(Payment payment){
        myController.setScreen(Educake.paymentID);

        String name = payment.getName();
        String value = String.valueOf(payment.getValue()).replaceAll("\\.",",");
        String due = EasyDate.toString(payment.getDue());

        nameTextField.setText(name);
        valueTextField.setText(value);
        dueTextField.setPlainText(due);
        form.getChildren().remove(installments);

        confirmationButton.setText("Atualizar");
        confirmationButton.setOnAction(event -> updatePayment(payment));
        updateTable();
    }

    public void goToUpdatePayment() {
        if (paymentsTable.getSelectionModel().getSelectedIndex() >= 0) {
            Payment payment = paymentsTable.getSelectionModel().getSelectedItem();
            ((PaymentController) myController.getControlledScreen(Educake.paymentID)).setPaymentToForm(payment);

        } else {
            new ModalErrorDialog("Selecione uma pendência", "É necessário selecionar uma pendência antes de tentar atualizá-la.");
        }
    }

    private void updatePayment(Payment payment) {
        try {
            int index = student.getPerson().getPayments().indexOf(payment);

            String name = nameTextField.getText();
            String value = valueTextField.getText();
            Date due = validator.date(dueTextField.getText());

            payment.setName(name);
            payment.setValue(value);
            payment.setDue(due);

            student.getPerson().setPayment(index, payment);

            dao.update(payment);

            initialize(null,null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Educake.mainContainer.setScreen(Educake.paymentDashID);
            
    }

    public void removePayment() {
        if (paymentsTable.getSelectionModel().getSelectedIndex() >= 0) {
            Payment payment = paymentsTable.getSelectionModel().getSelectedItem();
            payment.setActivated(false);
            dao.update(payment);
            updateTable();
        } else {
            new ModalErrorDialog("Selecione uma pendência", "É necessário selecionar uma pendência antes de tentar excluí-la.");
        }
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        this.myController = screenParent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void generateBill() {
        if (paymentsTable.getSelectionModel().getSelectedIndex() >= 0) {
            Payment payment = paymentsTable.getSelectionModel().getSelectedItem();
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","EDUCAKE","root");

                String path = "src/main/resources/reports/payment.jrxml";
                JasperReport jr = JasperCompileManager.compileReport(path);

                Map<String, Object> param = new HashMap<>();
                param.put("bill", payment.getIdPayment());

                JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
                JasperViewer.viewReport(jp, false);
                con.close();
            } catch (JRException | ClassNotFoundException | SQLException e) {
                e.printStackTrace(); 
            }
        } else {
            new ModalErrorDialog("Selecione uma pendência", "É necessário selecionar uma pendência antes de gerar o recibo.");
        }
    }
}
