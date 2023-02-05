package com.example.phonebook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonNew;

    @FXML
    private Button buttonReset;

    @FXML
    private TableColumn<Employee, String> columnName;

    @FXML
    private TableColumn<Employee, String> columnSurname;

 //   @FXML
//    private DatePicker datePickerBirthday;

    @FXML
    private TableView<Employee> tablePersons;

    @FXML
    private TextField textFieldAddress;

    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldSurname;


    @FXML
    private TextField textFieldTelephone;

    private ObservableList<Employee> persons = FXCollections.observableArrayList();

    public void setTablePersons() {
        columnName.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        columnSurname.setCellValueFactory(new PropertyValueFactory<Employee, String>("surname"));
        tablePersons.setItems(persons);
        tablePersons.refresh();
    }

    public void showPerson(Employee person) {
        if (person != null) {
            textFieldName.setText(person.getName());
            textFieldSurname.setText(person.getSurname());
   //         datePickerBirthday.setValue(person.getBirthday());
            textFieldAddress.setText(person.getAddress());
            textFieldTelephone.setText(person.getTelephoneNumber());
        } else {
            textFieldName.setText("");
            textFieldSurname.setText("");
       //     datePickerBirthday.setValue(LocalDate.now());
            textFieldAddress.setText("");
            textFieldTelephone.setText("");
        }
    }

    @FXML
    void addNewPerson(ActionEvent event) {
       /* persons.add(new Person(textFieldName.getText(), textFieldSurname.getText(), /* datePickerBirthday.getValue(), /
                textFieldAddress.getText(), textFieldTelephone.getText()));*/
    }

    @FXML
    void deletePerson(ActionEvent event) {
        if (tablePersons.getSelectionModel().getSelectedIndex() != -1)
            persons.remove(tablePersons.getSelectionModel().getSelectedIndex());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTablePersons();
        tablePersons.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPerson(newValue)
        );
    }

    public void openXML(ActionEvent actionEvent) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeMap.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        EmployeeMap empMap = (EmployeeMap) jaxbUnmarshaller.unmarshal( new File("c:/tmp/employees.xml"));
        persons.clear();
        persons.addAll(empMap.getEmployeeMap().values());
        tablePersons.setItems(persons);
        tablePersons.refresh();
    }
}