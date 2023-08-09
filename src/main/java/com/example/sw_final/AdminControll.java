
package com.example.sw_final;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import static com.example.sw_final.WelcomeControl.logger;


public class AdminControll {

    String msg="An error occurred while opening a new window:";
String y="Houses";
    public static final boolean REQUESTCLICKED=true;
    public static final boolean CONTROLIN=true;
    public static  final boolean MODIFYCLICKED =true;
    public static  final boolean  ISACCEPT=false;
    public static  final boolean ISACCEPT2=true;



    @FXML
    private Button addhouse;

    @FXML
    private Button modifyhouse;

    @FXML
    private Button request;

    @FXML
    private Button reservation;



    @FXML
    void addhouses(MouseEvent event) {

        try {
            NextPage.make("hello-view.fxml",y);

        }
        catch (IOException e) {
            logger.log(null, msg);
        }
    }

    @FXML
    void modifyhouses(MouseEvent event) {
        try {
            NextPage.make("modify.fxml", y);
        }
        catch (IOException e) {
            logger.log(null, msg);
        }



    }

    @FXML
    void requestcheck(MouseEvent event) {
            try {
                    NextPage.make("request.fxml", y);
            }
            catch (IOException e) {
                logger.log(null, msg);
            }

    }
    @FXML
    void reservationcheck(MouseEvent event) {
        try {
            NextPage.make("reservation.fxml", y);
        }
        catch (IOException e) {
            logger.log(null, msg);
        }
    }

}

