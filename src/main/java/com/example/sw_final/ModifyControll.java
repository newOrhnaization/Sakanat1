package com.example.sw_final;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

import static com.example.sw_final.WelcomeControl.logger;

public class ModifyControll {
    public  static final boolean ISMODIFY=false;
public static  final   boolean CHECKED=false;
protected    String temp=Sakanat.house1.get(Sakanat.m).getPicture();
    @FXML
    private TextField balcony1;

    @FXML
    private TextField bathroom1;

    @FXML
    private TextField bedroom1;

    @FXML
    private Button click;

    @FXML
    private TextField house12;

    @FXML
    private ImageView imigeview;

    @FXML
    private Button importPicture2;

    @FXML
    private TextField location1;

    @FXML
    private Button modify;

    @FXML
    private Button next;

    @FXML
    private TextField price1;

    @FXML
    private TextField services1;

    @FXML
    void click(MouseEvent event) {
        if (Sakanat.m!= Sakanat.house1.size()) {

            location1.setText(Sakanat.house1.get(Sakanat.m).getLocation());
            price1.setText(Sakanat.house1.get(Sakanat.m).getPrice() + "");
            services1.setText(Sakanat.house1.get(Sakanat.m).getServices());
            bedroom1.setText(Sakanat.house1.get(Sakanat.m).getBedroom() + "");
            bathroom1.setText(Sakanat.house1.get(Sakanat.m).getBathroom() + "");
            balcony1.setText(Sakanat.house1.get(Sakanat.m).getBalcony() + "");
            house12.setText(Sakanat.house1.get(Sakanat.m).getNumberhouse()+"");
            imigeview.setImage(new Image(Sakanat.house1.get(Sakanat.m).getPicture()));
        } else {
            try {
                NextPage.make("adminpage.fxml", "Houses");
            } catch (IOException e) {
                logger.log(null, "An error occurred while opening a new window:");
            }
        }

    }

    @FXML
    void importpictureclicked(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        Stage stage=(Stage) importPicture2.getScene().getWindow();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file=fileChooser.showOpenDialog(stage);

        if (file != null) {
            String iconimagepath = file.getAbsolutePath();
            imigeview.setImage(new Image(iconimagepath));
            temp=iconimagepath;
        }
        else if(!TESTINPUT.housePictureTest(temp)) JOptionPane.showMessageDialog(null,"Unvalied Picture","errorMassage",JOptionPane.ERROR_MESSAGE);


    }

    @FXML
    void modify(MouseEvent event) {
          if(checkdata()&&checkpicture())
        {
            Sakanat.house1.get(Sakanat.m).setLocation(location1.getText());
            Sakanat.house1.get(Sakanat.m).setPrice(Integer.parseInt(price1.getText()));
            Sakanat.house1.get(Sakanat.m).setServices(services1.getText());
            Sakanat.house1.get(Sakanat.m).setBedroom(Integer.parseInt(bedroom1.getText()));
            Sakanat.house1.get(Sakanat.m).setBathroom(Integer.parseInt(bathroom1.getText()));
            Sakanat.house1.get(Sakanat.m).setBalcony(Integer.parseInt(balcony1.getText()));
            Sakanat.house1.get(Sakanat.m).setNumberhouse(Integer.parseInt(house12.getText()));
            Sakanat.house1.get(Sakanat.m).setPicture(temp);

        }
         else  JOptionPane.showMessageDialog(null,"Data you entered is unvalid ","errorMassage",JOptionPane.ERROR_MESSAGE);

    }

    @FXML
    void next(MouseEvent event) {
        if (Sakanat.m != Sakanat.house1.size()) {
            inceamentM ();
            try {
                NextPage.make("modify.fxml", "Houses");
            } catch (IOException e) {
                logger.log(null, "An error occurred while opening a new window:");
            }
        }


    }

public static void inceamentM ()
{
    Sakanat.m++;
}


    public  boolean checkdata() {

        if(TESTINPUT.houseServicesTest(services1.getText())&&TESTINPUT.priceTest(price1.getText())&&TESTINPUT.houseBedroomTest(bedroom1.getText()) &&TESTINPUT.houseBathroomTest(bathroom1.getText())&&TESTINPUT.houseBalconyTest(balcony1.getText()))
        {
            if(Sakanat.house1.get(Sakanat.m).getNumberhouse()==Integer.parseInt(house12.getText()))
            {

                return true;
            }
            else  return TESTINPUT.houseNumbertest(house12.getText());
        }
        return  false;
    }
    public  boolean  checkpicture() {
        if(temp.equals(Sakanat.house1.get(Sakanat.m).getPicture()))
            return  true;
        for(int i=0;i<Sakanat.house1.size();i++)
        {
            if(temp.equals(Sakanat.house1.get(i).getPicture()))
                return  false;
        }
        return  true;
    }
    public static  boolean isModifyTEST()
    {
     return   !ISMODIFY;

    }



}
