package com.example.phonebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainClass extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("phonebook.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("PhoneBook");
        stage.setScene(scene);
        stage.show();
    }


}