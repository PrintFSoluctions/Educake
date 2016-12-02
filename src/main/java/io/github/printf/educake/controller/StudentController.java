package io.github.printf.educake.controller;

import io.github.printf.educake.Educake;
import io.github.printf.educake.controller.base.ModalErrorDialog;
import io.github.printf.educake.dao.StudentDAO;
import io.github.printf.educake.model.*;
import io.github.printf.educake.util.EasyDate;
import io.github.printf.educake.util.components.MaskField;
import io.github.printf.educake.util.generators.WebServiceCep;
import io.github.printf.educake.util.interfaces.ControlledScreen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author Vitor Silvério de Souza On nov, 2016
 */
public class StudentController implements Initializable, ControlledScreen {

    @FXML
    public ToggleGroup courses;
    @FXML
    private TextField nameTextField, stateTextField, cityTextField, districtTextField,
        streetTextField, houseNumberTextField, complementTextField, searchTextField;
    @FXML
    private MaskField cpfTextField, phone1TextField, phone2TextField, cepTextField, birthTextField;
    @FXML
    private Button confirmationButton;
    @FXML
    private TableView<Student> studentsTable;

    ScreensController myController;
    private StudentDAO studentDAO = new StudentDAO();
    private Student student = new Student();

    Person person = new Person();
    private PersonController personController = new PersonController();

    Address address = new Address();
    private AddressController addressController = new AddressController();
    private WebServiceCep addressByCEP;


    @FXML
    public void persistStudent() {

        String name = nameTextField.getText();
        String birth = birthTextField.getText();
        String cpf = cpfTextField.getPlainText();
        String phone1 = phone1TextField.getPlainText();
        String phone2 = phone2TextField.getPlainText();
        String cep = cepTextField.getPlainText();
        String state = stateTextField.getText();
        String city = cityTextField.getText();
        String district = districtTextField.getText();
        String street = streetTextField.getText();
        String houseNumber = houseNumberTextField.getText();
        String complement = complementTextField.getText();
        Course course;

        try {
            try {
                course = Course.valueOf(((ToggleButton) courses.getSelectedToggle()).getId());
            } catch (Exception e) {
                throw new Exception("É necessário selecionar um curso");
            }

            address = addressController.setAddress(cep, state, city, district, street, houseNumber, complement);
            person = personController.setPerson(name, birth, cpf, address, phone1, phone2);
            student.setPerson(person);
            student.generateRM();
            student.setCourse(course);
            studentDAO.persist(student);
        } catch (Exception e) {
            new ModalErrorDialog("Erro de Validação", e.getMessage());
        }

        Educake.mainContainer.setScreen(Educake.studentDashID);
        initialize(null,null);
    }

    @FXML
    public void setStudentToForm(Student student) {

        myController.setScreen(Educake.studentID);
        person = student.getPerson();
        address = person.getAddress();

        String name = person.getName();
        System.out.println(person.getBirthdate());
        String birth = EasyDate.toString(person.getBirthdate());
        List<Phone> phones = person.getPhones();
        String cpf = person.getCpf();
        String cep = address.getCep();
        String state = address.getState();
        String city = address.getCity();
        String district = address.getDistrict();
        String street = address.getStreet();
        String houseNumber = String.valueOf(address.getHouseNumber());
        String complement = address.getComplement();
        Course course = student.getCourse();

        nameTextField.setText(name);
        birthTextField.setText(birth);
        cpfTextField.setPlainText(cpf);
        phone1TextField.setPlainText(phones.get(0).getNumber());
        phone2TextField.setPlainText(phones.get(1).getNumber());
        cepTextField.setPlainText(cep);
        stateTextField.setText(state);
        cityTextField.setText(city);
        districtTextField.setText(district);
        streetTextField.setText(street);
        houseNumberTextField.setText(houseNumber);
        complementTextField.setText(complement);
        courses.selectToggle(courses.getToggles().get(course.ordinal()));

        confirmationButton.setText("Atualizar");
        confirmationButton.setOnAction(event -> updateStudent(student));
    }

    public void updateStudent(Student student) {

        String name = nameTextField.getText();
        String birth = birthTextField.getText();
        String cpf = cpfTextField.getPlainText();
        String phone1 = phone1TextField.getPlainText();
        String phone2 = phone2TextField.getPlainText();
        String cep = cepTextField.getPlainText();
        String state = stateTextField.getText();
        String city = cityTextField.getText();
        String district = districtTextField.getText();
        String street = streetTextField.getText();
        String houseNumber = houseNumberTextField.getText();
        String complement = complementTextField.getText();
        Course course;

        person = student.getPerson();
        address = person.getAddress();

        try {
            try {
                course = Course.valueOf(((ToggleButton) courses.getSelectedToggle()).getId());
            } catch (Exception e) {
                throw new Exception("É necessário selecionar um curso");
            }

            person.setName(name);
            person.setCpf(cpf);
            person.setBirthdate(birth);
            person.setPhones(phone1, phone2);

            address.setCep(cep);
            address.setState(state);
            address.setCity(city);
            address.setDistrict(district);
            address.setStreet(street);
            address.setHouseNumber(houseNumber);
            address.setComplement(complement);

            student.setCourse(course);

            studentDAO.update(student);
        } catch (Exception e) {
            new ModalErrorDialog("Erro de Validação", e.getMessage());
        }

        Educake.mainContainer.setScreen(Educake.studentDashID);
        initialize(null,null);
    }

    @FXML
    public void removeStudent() {
        if (studentsTable.getSelectionModel().getSelectedIndex() >= 0) {
            int idStudent = studentsTable.getSelectionModel().getSelectedItem().getIdStudent();

            Student removed = studentDAO.getById(idStudent);
            removed.setActivated(false);

            studentDAO.update(removed);
            initialize(null, null);
        } else {
            new ModalErrorDialog("Selecione um aluno", "É necessário selecionar um aluno antes de tentar excluí-lo.");
        }
    }

    public void goToNewStudent() {
        Educake.activeScreen = "";

        Educake.mainContainer.unloadScreen(Educake.studentID);
        Educake.mainContainer.loadScreen(Educake.studentID, Educake.studentFile);
        Educake.mainContainer.setScreen(Educake.studentID);

        myController.setScreen(Educake.studentID);

        if (nameTextField != null) {
            nameTextField.setText("");
            birthTextField.setText("");
            cpfTextField.setText("");
            phone1TextField.setText("");
            phone2TextField.setText("");
            cepTextField.setText("");
            stateTextField.setText("");
            cityTextField.setText("");
            districtTextField.setText("");
            streetTextField.setText("");
            houseNumberTextField.setText("");
            complementTextField.setText("");

            confirmationButton.setText("Cadastrar");
            confirmationButton.setOnAction(event -> persistStudent());
        }

    }

    public void goToUpdateStudent() {
        if (studentsTable.getSelectionModel().getSelectedIndex() >= 0) {
            Student student = studentsTable.getSelectionModel().getSelectedItem();
            ((StudentController) myController.getControlledScreen(Educake.studentID)).setStudentToForm(student);
        } else {
            new ModalErrorDialog("Selecione um aluno", "É necessário selecionar um aluno antes de tentar atualizá-lo.");
        }
    }

    public void goToPayment() {
        if (studentsTable.getSelectionModel().getSelectedIndex() >= 0) {
            Student student = studentsTable.getSelectionModel().getSelectedItem();
            myController.setScreen(Educake.paymentDashID);
            ((PaymentController) myController.getControlledScreen(Educake.paymentDashID)).setStudent(student);
        } else {
            new ModalErrorDialog("Selecione um aluno", "É necessário selecionar um aluno antes de tentar gerar qualquer boleto.");
        }
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Educake.activeScreen.equals(Educake.studentDashID)) {

            ObservableList<Student> students = FXCollections.observableArrayList(studentDAO.findAll());
            FilteredList<Student> studentsFiltered = new FilteredList<>(students, p -> true);


            searchTextField.textProperty().addListener((observable, oldValue, newValue) ->
                studentsFiltered.setPredicate(student -> {

                    // Se o texto do campo estiver vazio, mostra todos (tudo bate com o vazio)
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase();

                    if (student.getName().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Caso o nome bata
                    } else if (student.getCourseString().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // caso o curso bata
                    } else if (student.getRm().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // caso o rm bata
                    }

                    return false; // Caso nada bata, remove da lista
                }));

            studentsTable.setItems(studentsFiltered);
            studentsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

            if (studentsTable.getColumns().size() == 0) {
                TableColumn<Student, String> rmColumn = new TableColumn<>("RM");
                TableColumn<Student, String> nameColumn = new TableColumn<>("Nome");
                TableColumn<Student, String> courseColumn = new TableColumn<>("Curso");

                rmColumn.setCellValueFactory(new PropertyValueFactory<>("rm"));
                nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
                courseColumn.setCellValueFactory(new PropertyValueFactory<>("courseString"));

                nameColumn.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.1));
                rmColumn.prefWidthProperty().bind(studentsTable.widthProperty().multiply(2));
                courseColumn.prefWidthProperty().bind(studentsTable.widthProperty().multiply(2));

                rmColumn.setMaxWidth(100);
                courseColumn.setMaxWidth(150);

                rmColumn.setMinWidth(100);
                courseColumn.setMinWidth(150);

                rmColumn.setResizable(false);
                courseColumn.setResizable(false);

                studentsTable.getColumns().addAll(rmColumn, nameColumn, courseColumn);
            }
        } else if (Educake.activeScreen.equals(Educake.studentID)){
            cepTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if(!newValue){
                    try {
                        addressByCEP = WebServiceCep.searchCep(cepTextField.getPlainText().trim());
                        stateTextField.setText(addressByCEP.getUf());
                        cityTextField.setText(addressByCEP.getCidade());
                        districtTextField.setText(addressByCEP.getBairro());
                        streetTextField.setText(addressByCEP.getLogradouroFull());
                        houseNumberTextField.requestFocus();
                    }catch (Exception ignored){}
                }
            });
        }

    }

    public void generateProfile() {
        if (studentsTable.getSelectionModel().getSelectedIndex() >= 0) {
            Student student = studentsTable.getSelectionModel().getSelectedItem();
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","EDUCAKE","root");

                String path = "src/main/resources/reports/student.jrxml";
                JasperReport jr = JasperCompileManager.compileReport(path);

                Map<String, Object> param = new HashMap<>();
                param.put("RM", student.getIdStudent());

                JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
                JasperViewer.viewReport(jp, false);
                con.close();
            } catch (JRException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } else {
            new ModalErrorDialog("Selecione um aluno", "É necessário selecionar um aluno para ver seus dados.");
        }
    }

    public void updateTable(ActionEvent actionEvent) {
        searchTextField.setText(" ");
        searchTextField.setText("");
    }
}
