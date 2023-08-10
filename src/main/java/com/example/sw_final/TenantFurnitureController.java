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

import static com.example.sw_final.HelloController.errorMassage;

public class TenantFurnitureController {
    @FXML
    private TextField furnitureTitleTextField;
    @FXML
    private TextArea furnitureDescriptionTextArea;
    @FXML
    private Button addFurniture;
    @FXML
    private Button doneFurniture;

    @FXML
    private ImageView furniturePicture;


    private String temp;
    Furniture f1 =new Furniture();


    @FXML
    void checkForNull(ActionEvent event) {



        if(furnitureTitleTextField.getText().length() == 0 || furnitureDescriptionTextArea.getText().length() == 0)
            JOptionPane.showMessageDialog(null, "PLEASE FILL ALL FIELDS");

        else if (!TESTINPUT.housePictureTest(temp)){
            JOptionPane.showMessageDialog(null, "invalied Picture","error" , JOptionPane.ERROR_MESSAGE);

        }
        else {
            String fName = furnitureTitleTextField.getText();
            String fDescription = furnitureDescriptionTextArea.getText();


            f1.setPhoto(temp);
            f1.setName(fName);
            f1.setDescription(fDescription);
            f1.setTenantName(LoginControl1.userlog);
            Sakanat.furniture.add(f1 );
            JOptionPane.showMessageDialog(null, "Furniture Added:   "+Sakanat.furniture.get(0).getName(), "correct", JOptionPane.PLAIN_MESSAGE);
        }


    }



     @FXML
    private void setAddFurniture(ActionEvent event)  {

         FileChooser fileChooser = new FileChooser();
         Stage stage = (Stage) addFurniture.getScene().getWindow();
         fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
         File file = fileChooser.showOpenDialog(stage);



         if (file != null) {
             String iconimagepath = file.getAbsolutePath();
             furniturePicture.setImage(new Image(iconimagepath));
             temp = iconimagepath;
         }

     }


}





