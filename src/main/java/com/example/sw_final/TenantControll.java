package com.example.sw_final;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import static com.example.sw_final.AddHousecontrol.logger;

public class TenantControll {

    @FXML
    private Button view;

    @FXML
    void viewhouseclick(MouseEvent event) {
        try {
            NextPage.make("HouseListView.fxml","HousesList");
        }
        catch (IOException e) {
            logger.log(null, "An error occurred while opening a new window:");

        }
    }

}
