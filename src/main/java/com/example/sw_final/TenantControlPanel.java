package com.example.sw_final;
 import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Label;

        import javafx.scene.layout.VBox;

        import javax.swing.*;
        import java.net.URL;
        import java.util.ResourceBundle;

public class TenantControlPanel implements Initializable {

    @FXML
    private VBox houseContainer;

    private int houseNum;
    protected boolean bookedTenant;
    AdminRequist req1 = new AdminRequist();
    HouseClass hu  =  new HouseClass();
    HouseClass own  =  new HouseClass();

    private String ownerN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateHouses();


    }


    public  String ownerName()
    {
        for(int i=0;i<Sakanat.tenant1.size();i++)
        {
            if(Sakanat.tenant1.get(i).getHouseNumber() ==Sakanat.request.get(i).getHouseNum())
            {
                return Sakanat.owner1.get(i).getUsername();
            }
        }
        return "ss";
    }

    public  String  ownerinfo()
    {
        for(int i=0;i<Sakanat.owner1.size();i++)
        {
            if(houseNum == Sakanat.owner1.get(i).getid())
            {
                ownerN= Sakanat.owner1.get(i).getUsername();
                return ownerN;
            }
        }
        return ownerN;
    }


    private void populateHouses() {

        houseContainer.getChildren().clear();
        JOptionPane.showMessageDialog(null,LoginControl1.userlog );
        for (TenantClass tenant : Sakanat.tenant1) {

            if (   LoginControl1.userlog.equals(tenant.getUsername())   ){


                VBox houseBox = new VBox();
                houseBox.setSpacing(5);


                Label tenantName = new Label("Tenant Username: " + tenant.getUsername());
                Label age = new Label("Age:  " + tenant.getAge());
                Label status = new Label("status:  " + tenant.isBooked());
                Label major = new Label("Major: " + tenant.getUniversityMajors());
                Label gender = new Label("Gender: " + tenant.getGender());
                Label phone = new Label("Phone Number: " + tenant.getPhoneNumber());
                Label ownerName = new Label("Owner Name: " + ownerinfo() );

                houseBox.getChildren().addAll(
                        tenantName, age, status,
                        major, gender, phone,ownerName
                );

                houseContainer.getChildren().add(houseBox);



            }

        }
    }
}










