package com.example.sw_final;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.util.logging.Logger;


public class AddHousecontrol {
    static Logger logger = Logger.getLogger(AddHousecontrol.class.getName());

    @FXML
    private Button add;

    @FXML
    private Button myhouse;

    @FXML
    void insert(MouseEvent event) {
        try {
            NextPage.make("hello-view.fxml","Houses");

        }
        catch (IOException e) {
            logger.log(null, "An error occurred while opening a new window:");
        }
    }

    @FXML
    void viewMyhouse(MouseEvent event) {
        try {
            NextPage.make("myhouse.fxml","Houses");
        }
        catch (IOException e) {
            logger.log(null, "An error occurred while opening a new window:");
        }
    }

}
