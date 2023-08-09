package com.example.sw_final;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
public class  ReservationControl implements Initializable {
   protected int indexhouse;
   protected    int indextenant;
    VBox houseBox;
   AdminRequist house1;
    ImageView imageView;
    @FXML
    private VBox houseContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        populateHouses();
    }

    private void populateHouses() {

        houseContainer.getChildren().clear();

        for (  AdminRequist house: Sakanat.request) {
            house1 = house;
            indexhouse=findhouse();
            indextenant=findtenent();
            createimge() ;
        }

    }




    public  void createimge() {
            houseBox = new VBox();
            houseBox.setSpacing(5);
            imageView = new ImageView();
            try {
                Image image = new Image(new FileInputStream(Sakanat.house1.get(indexhouse).getPicture()));
                imageView.setImage(image);
                imageView.setFitWidth(200);
                imageView.setPreserveRatio(true);
            } catch (FileNotFoundException e) {
            logger.log(null, "An error occurred while opening a new window:");
            }
            setlabel();
            houseContainer.getChildren().add(houseBox);
    }
    public void setlabel()
    {

        Label houseNumberLabel = new Label("House Number: " + Sakanat.house1.get(indexhouse).getNumberhouse());
        Label locationLabel = new Label("Location: " + Sakanat.house1.get(indexhouse).getLocation());
        Label priceLabel = new Label("Price: $" + Sakanat.house1.get(indexhouse).getPrice());
        Label servicesLabel = new Label("Services: " + Sakanat.house1.get(indexhouse).getServices());
        Label balconyLabel = new Label("Balcony: " + Sakanat.house1.get(indexhouse).getBalcony());
        Label bedroomLabel = new Label("Bedroom: " +Sakanat.house1.get(indexhouse).getBedroom());
        Label tenantname = new Label("Tenant User name: " + Sakanat.tenant1.get(indextenant).getUsername());
        Label tenantmeger = new Label(" Tenant University Majors: " + Sakanat.tenant1.get(indextenant).getUniversityMajors());
        Label tenantphone = new Label("Tenant Phone Number: " +Sakanat.tenant1.get(indextenant).getPhoneNumber());
        houseBox.getChildren().addAll(
                imageView, houseNumberLabel, locationLabel, priceLabel,
                servicesLabel, balconyLabel, bedroomLabel,tenantname ,tenantphone,tenantmeger
        );
    }
    public int findhouse()
    {
        for(int i=0;i<Sakanat.house1.size();i++)
        {
            if( house1.getHouseNum()==Sakanat.house1.get(i).getNumberhouse())
            {
           return i;}
        }
        return -1;
    }



    public int findtenent()
    {
        for(int i=0;i<Sakanat.tenant1.size();i++)
        {
            if( house1.getUsername().trim().equals(Sakanat.tenant1.get(i).getUsername().trim()))
                return i;
        }
        return -1;
    }


}
