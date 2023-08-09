package com.example.sw_final;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TenantControlPanel implements Initializable {

    private VBox houseContainer;

    public int houseNum;
    protected boolean bookedTenant;
    AdminRequist req1 = new AdminRequist();
    TenantClass tenant = new TenantClass();
    HouseClass hu  =  new HouseClass();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateHouses();


    }

    private void populateHouses() {
        houseContainer.getChildren().clear();
        JOptionPane.showMessageDialog(null, tenant.getUsername());
        JOptionPane.showMessageDialog(null,LoginControl1.userlog );
        for (TenantClass tenant : Sakanat.tenant1) {

            if (   LoginControl1.userlog.equals(tenant.getUsername())   ){


                VBox houseBox = new VBox();
                houseBox.setSpacing(5);


                Label tenantName = new Label("Tenant Username: " + tenant.getUsername());
                Label Age = new Label("Age:  " + tenant.getAge());
                Label status = new Label("status:  " + tenant.isBooked());
                Label Major = new Label("Major: " + tenant.getUniversityMajors());
                Label Gender = new Label("Gender: " + tenant.getGender());
                Label Phone = new Label("Phone Number: " + tenant.getPhoneNumber());
                Label ownerNumber = new Label("Owner Number: " + HouseListController.ownerId);

                houseBox.getChildren().addAll(
                        tenantName, Age, status,
                        Major, Gender, Phone, ownerNumber
                );

                houseContainer.getChildren().add(houseBox);



            }

        }
    }
}










