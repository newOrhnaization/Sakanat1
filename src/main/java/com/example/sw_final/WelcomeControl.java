
package com.example.sw_final;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.logging.Logger;

public  class WelcomeControl {
    static Logger logger = Logger.getLogger(WelcomeControl.class.getName());

    @FXML
    private Button login1;

    @FXML
       void loginclick(MouseEvent event) {
        try {
            NextPage.make("loginpage1.fxml","login page");

        }
        catch (IOException e) {
            logger.log(null, "An error occurred while opening a new window:");
        }
    }

}

