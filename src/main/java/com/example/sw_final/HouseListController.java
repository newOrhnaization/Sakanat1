package com.example.sw_final;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.sw_final.WelcomeControl.logger;

public class HouseListController implements Initializable {

    @FXML
    private VBox houseContainer;

    protected     int houseNum;
   protected  static boolean bookedTenant;
    protected static String  tenantUsername;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateHouses();



    }

    private void bookButtonHandls(int selectedHouseNum) throws RuntimeException {
        TenantClass tenantB = null;
        houseNum = selectedHouseNum;

        tenantUsername = LoginControl1.userlog;// Get the tenant ID from login page
        for (TenantClass tenant : Sakanat.tenant1) {
            if (tenantUsername.equals(tenant.getUsername())) {
                tenantB = tenant;
                break; // Found the tenant, no need to continue looping
            }
        }

        if (tenantB.isBooked()) {
            bookedTenant= tenantB.isBooked();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You are already booked");
            alert.setHeaderText(null);
            alert.setContentText("You have already booked a house.");
            alert.showAndWait();
        } else {
            tenantB.setBooked(true);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Booking Successful");
            alert.setHeaderText(null);
            alert.setContentText("You have successfully booked a house.");
            alert.showAndWait();

            AdminRequist request = new AdminRequist();
            request.setUsername(tenantUsername);
            request.setHouseNum(houseNum);
            Sakanat.request.add(request);

            try {
                NextPage.make("tenantBook.fxml","login page");

            }
            catch (IOException e) {
                logger.log(null, "An error occurred while opening a new window:");
            }
        }
    }

    public static String getTenantName()
    {

        return tenantUsername;}
    private void populateHouses() {
        houseContainer.getChildren().clear();

        for (HouseClass house : Sakanat.house1) {
            VBox houseBox = new VBox();
            houseBox.setSpacing(5);
            houseNum = house.getNumberhouse();
            ImageView imageView = new ImageView();
            try {
                Image image = new Image(new FileInputStream(house.getPicture()));
                imageView.setImage(image);
                imageView.setFitWidth(200);
                imageView.setPreserveRatio(true);
            } catch (FileNotFoundException e) {
                logger.log(null, "An ele opening a new window:");
            }

            Label houseNumberLabel = new Label("House Number: " + house.getNumberhouse());
            Label locationLabel = new Label("Location: " + house.getLocation());
            Label priceLabel = new Label("Price: $" + house.getPrice());
            Label servicesLabel = new Label("Services: " + house.getServices());
            Label balconyLabel = new Label("Balcony: " + house.getBalcony());
            Label bedroomLabel = new Label("Bedroom: " + house.getBedroom());

          Button  bookHouse = new Button("BOOK");


            bookHouse.setOnAction(e -> bookButtonHandls(house.getIdOwner())); // Pass the house number to the handler
            houseBox.getChildren().addAll(
                    imageView, houseNumberLabel, locationLabel, priceLabel,
                    servicesLabel, balconyLabel, bedroomLabel,bookHouse
            );

            houseContainer.getChildren().add(houseBox);

            // here I want to put a button action event for each button

        }
    }
}
