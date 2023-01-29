package com.example.phonebook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<Person, String> columnName;

    @FXML
    private TableColumn<Person, String> columnSurname;

    @FXML
    private DatePicker datePickerBirthday;

    @FXML
    private TableView<Person> tablePersons;

    @FXML
    private TextField textFieldAddress;

    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldSurname;


    @FXML
    private TextField textFieldTelephone;

    private ObservableList<Person> persons = FXCollections.observableArrayList();

    public void setTablePersons() {
        columnName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        columnSurname.setCellValueFactory(new PropertyValueFactory<Person, String>("surname"));
        tablePersons.setItems(persons);
        tablePersons.refresh();
    }

    public void showPerson(Person person) {
        if (person != null) {
            textFieldName.setText(person.getName());
            textFieldSurname.setText(person.getSurname());
            datePickerBirthday.setValue(person.getBirthday());
            textFieldAddress.setText(person.getAddress());
            textFieldTelephone.setText(person.getTelephoneNumber());
        } else {
            textFieldName.setText("");
            textFieldSurname.setText("");
            datePickerBirthday.setValue(LocalDate.now());
            textFieldAddress.setText("");
            textFieldTelephone.setText("");
        }
    }

    @FXML
    void addNewPerson(ActionEvent event) {
        persons.add(new Person(textFieldName.getText(), textFieldSurname.getText(), datePickerBirthday.getValue(),
                textFieldAddress.getText(), textFieldTelephone.getText()));
    }

    @FXML
    void deletePerson(ActionEvent event) {
        if (tablePersons.getSelectionModel().getSelectedIndex() != -1)
            persons.remove(tablePersons.getSelectionModel().getSelectedIndex());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        persons.add(new Person("Kenan", "Göztas", LocalDate.of(1980, 01, 01), "Ulm", "0123456"));
        setTablePersons();
        tablePersons.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPerson(newValue)
        );




    }


}