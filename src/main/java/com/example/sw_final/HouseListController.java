package com.example.sw_final;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Label;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.VBox;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.scene.control.Alert;
        import javafx.scene.control.Button;
        import javax.swing.*;
        import java.io.IOException;


        import static com.example.sw_final.WelcomeControl.logger;
public class HouseListController implements Initializable {
    VBox houseBox;
    HouseClass house1;
    ImageView imageView;
    @FXML
    private VBox houseContainer;
    private Button bookHouse;
    protected    static int houseNum;
    public static  String ownerId;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        populateHouses();
    }
    @FXML
    private void bookButtonHandls(int selectedHouseNum) throws RuntimeException {

        TenantClass tenantB = null;

        // Find the tenant with the matching ID
        String tenantUsername = LoginControl1.userlog;// Get the tenant ID from login page
        for (TenantClass tenant : Sakanat.tenant1) {
            if (tenantUsername.equals(tenant.getUsername())) {
                tenantB = tenant;
                break; // Found the tenant, no need to continue looping
            }
        }

        if (tenantB == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("// Tenant with the specified ID was not found");
            alert.setHeaderText(null);
            alert.setContentText("You have already booked a house.");
            alert.showAndWait();
            return;
        }

        if (tenantB.isBooked()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You are already booked");
            alert.setHeaderText(null);
            alert.setContentText("You have already booked a house.");
            alert.showAndWait();
        } else {
            tenantB.setBooked(true);

            // Display a success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Booking Successful");
            alert.setHeaderText(null);
            alert.setContentText("You have successfully booked a house.");
            alert.showAndWait();
            AdminRequist request = new AdminRequist();
            request.setUsername(tenantUsername);
            request.setHouseNum(houseNum);
            Sakanat.request.add(request);
            JOptionPane.showMessageDialog(null,Sakanat.request.get(0).getHouseNum() + Sakanat.request.get(0).getUsername() );

            try {
                NextPage.make("tenantBook.fxml","login page");

            }
            catch (IOException e) {
                logger.log(null, "An error occurred while opening a new window:");
            }
        }
    }

    private void populateHouses() {

        houseContainer.getChildren().clear();

        for (  HouseClass house: Sakanat.house1) {
            house1 = house;
            createimge() ;

        }

    }




    public  void createimge() {
        if (house1.getaccepted()) {
            houseBox = new VBox();
            houseBox.setSpacing(5);
            imageView = new ImageView();
            try {
                Image image = new Image(new FileInputStream(house1.getPicture()));
                imageView.setImage(image);
                imageView.setFitWidth(200);
                imageView.setPreserveRatio(true);
            } catch (FileNotFoundException e) {
            logger.log(null, "An error occurred while opening a new window:");
            }

            setlabel();
            houseContainer.getChildren().add(houseBox);
        }
    }


    public void setlabel()
    {
        // Create labels to display house information
        Label houseNumberLabel = new Label("House Number: " + house1.getNumberhouse());
        Label locationLabel = new Label("Location: " + house1.getLocation());
        Label priceLabel = new Label("Price: $" + house1.getPrice());
        Label servicesLabel = new Label("Services: " + house1.getServices());
        Label balconyLabel = new Label("Balcony: " + house1.getBalcony());
        Label bedroomLabel = new Label("Bedroom: " + house1.getBedroom());
        Label ownerid = new Label("Owner: " + house1.getIdOwner());
        bookHouse = new Button("BOOK");
        bookHouse.setOnAction(e -> bookButtonHandls(house1.getIdOwner()));
        houseBox.getChildren().addAll(
                imageView, houseNumberLabel, locationLabel, priceLabel,
                servicesLabel, balconyLabel, bedroomLabel,bookHouse
        );

    }



}
