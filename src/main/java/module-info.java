module com.example.phonebook {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;


    opens com.example.phonebook to javafx.fxml;
    exports com.example.phonebook;
}