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
import static com.example.sw_final.WelcomeControl.logger;
public class MyHouse implements Initializable{
private  int indexhouse;
private  String  tenantname;
    VBox houseBox;
    HouseClass house1;
    ImageView imageView;
    @FXML
    private VBox houseContainer;
    private  boolean flag=false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        populateHouses();
    }
    private void populateHouses() {

        houseContainer.getChildren().clear();

        for (  HouseClass house: Sakanat.house1) {
            if(flag)continue;

            house1 = house;
            try {
                createimge() ;
            } catch (FileNotFoundException e) {
                logger.log(null, "error");
            }

        }

    }
    public  void createimge() throws FileNotFoundException {
        indexhouse();
                 houseBox = new VBox();
            houseBox.setSpacing(5);
            imageView = new ImageView();
            try {
                Image image = new Image(new FileInputStream(Sakanat.house1.get(indexhouse).getPicture()));
                imageView.setImage(image);
                imageView.setFitWidth(200);
                imageView.setPreserveRatio(true);
            }
            catch (FileNotFoundException e) {
                logger.log(null, "An error occurred while opening a new window:");
            }
            setlabel();
            houseContainer.getChildren().add(houseBox);
        }


    public void setlabel() {
        String  x=Sakanat.house1.get(indexhouse).getNumberhouse()+"";
        Label tenantuser = new Label();
        Label tenantphoe=new Label();

        if (tenantindex() == -1) {
            tenantuser.setText(" This house is not Booked yes");
        }
        else
        {
            tenantuser.setText("Tenant Name:" + Sakanat.tenant1.get(tenentinfo()).getUsername());
             tenantphoe = new Label("Tenant Phone Number" + Sakanat.tenant1.get(tenentinfo()).getPhoneNumber());

        }


            // Create labels to display house information
            Label floorLabel = new Label("Floor Number: " + x.charAt(2) + x.charAt(3) + "");
            Label apartment = new Label("Apartment Number: " + x.charAt(4) + x.charAt(5) + x.charAt(6) + "");
            Label balconyLabel = new Label("Balcony: " + Sakanat.house1.get(indexhouse).getBalcony());
            Label bedroomLabel = new Label("Bedroom: " + Sakanat.house1.get(indexhouse).getBedroom());
            Label bathroomLabel = new Label("Bathroom: " + Sakanat.house1.get(indexhouse).getBathroom());
            houseBox.getChildren().addAll(
                    imageView, floorLabel, apartment, balconyLabel, bedroomLabel, bathroomLabel, tenantuser,tenantphoe
            );
    }
    public int  owneridbyname()
    {
        for(int i=0;i<Sakanat.owner1.size();i++)
        {
            if(LoginControl1.userlog.trim().equals(Sakanat.owner1.get(i).getUsername().trim()))
            {
                return i;
            }
        }
        return -1;
    }
    public  void indexhouse()
    {
        for(int i=0;i<Sakanat.house1.size();i++)
        {
            if(Sakanat.house1.get(i).getIdOwner()==Sakanat.owner1.get(owneridbyname()).getid())
            {

                indexhouse=i;

            }
        }
    }
    public  int tenantindex()
    {
        for(int i=0;i<Sakanat.request.size();i++)
        {
            if(Sakanat.house1.get(indexhouse).getNumberhouse()==Sakanat.request.get(i).getHouseNum())
            {
                tenantname=Sakanat.request.get(i).getUsername();
                flag=true;
                return i ;
            }
        }
        return -1;
    }

    public  int  tenentinfo()
    {
       for(int i=0;i<Sakanat.tenant1.size();i++)
       {
           if(tenantname.trim().equals(Sakanat.tenant1.get(i).getUsername().trim()))
           {
return i;
           }
       }
       return -1;
    }




}























