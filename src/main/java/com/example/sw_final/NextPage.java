package com.example.sw_final;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NextPage {
    private NextPage()
    {

    }

    public static void make(String x,String y) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(x));
        Parent myroot = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle(y);
        stage.setScene(new Scene(myroot));
        stage.show();
    }
}
