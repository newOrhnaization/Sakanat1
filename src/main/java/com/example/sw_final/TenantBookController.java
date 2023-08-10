package com.example.sw_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TenantBookController implements Initializable {

    @FXML
    private DatePicker moveInDatePicker;
    @FXML
    private TextField leaseDurationTextField;

    @FXML
    private Button bookButton;

    @FXML
    private Label daysLeftLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookButton.setOnAction(this::bookButtonHandler);
    }

    @FXML
    private void bookButtonHandler(ActionEvent event) {
        LocalDate moveInDate = moveInDatePicker.getValue();
        int leaseDuration = Integer.parseInt(leaseDurationTextField.getText());

        LocalDate currentDate = LocalDate.now();
        LocalDate leaseEndDate = moveInDate.plusMonths(leaseDuration);
        long daysLeft = currentDate.until(leaseEndDate).getDays();

        if (daysLeft > 0) {
            daysLeftLabel.setText("Days Left in Residence: " + daysLeft);
        } else {
            daysLeftLabel.setText("Lease Expired");
        }
    }

}
