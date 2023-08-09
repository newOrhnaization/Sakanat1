package com.example.sw_final;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
;

public class TenantFurnitureController {
    String ERROR_MASSAGE=" SOMTHING ERROR";
    @FXML
    private TextField furnitureTitleTextField;
    @FXML
    private TextArea furnitureDescriptionTextArea;
    @FXML
    private Button addFurniture;
    @FXML
    private ImageView furniturePicture;

    private String fDescription;
    private String fName;
    private String fPicture;
    private String temp;
    Furniture f1 =new Furniture();

    @FXML
    private void setAddFurniture(ActionEvent event) throws RuntimeException {
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) addFurniture.getScene().getWindow();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            String iconimagepath = file.getAbsolutePath();
            furniturePicture.setImage(new Image(iconimagepath));
            temp = iconimagepath;
        } else if (!TESTINPUT.housePictureTest(temp))

            JOptionPane.showMessageDialog(null, "Unvalied Picture", ERROR_MASSAGE, JOptionPane.ERROR_MESSAGE);

        f1.setPhoto(temp);
        f1.setName(furnitureTitleTextField.getText());
        f1.setDescription(furnitureDescriptionTextArea.getText());
        Sakanat.furniture.add(f1 );
        JOptionPane.showMessageDialog(null, "name: "+Sakanat.furniture.get(0).getName(), "correct", JOptionPane.PLAIN_MESSAGE);

    }




}













