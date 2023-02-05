module com.example.phonebook {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;

    opens com.example.phonebook to javafx.fxml, java.xml.bind, java.lang;
    exports com.example.phonebook;
}
