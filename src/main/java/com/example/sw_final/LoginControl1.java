package com.example.sw_final;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javax.swing.*;
import java.io.IOException;

import static com.example.sw_final.AddHousecontrol.logger;

public  class LoginControl1 {
    public static  final  boolean LOGINCLCKED=true;
public static  final  boolean ADMINLOGIN=false;
    public static final boolean  ADMINLOGIN1=true;

    @FXML
   private    RadioButton adminRadio;
   @FXML
   private  Button loginbutton;

   @FXML
   private    RadioButton ownerRadio;

   @FXML
   private    PasswordField password;

   @FXML
   private  RadioButton tenantRadio;

   @FXML
   private Label type;

   @FXML
   private    ToggleGroup user;

   @FXML
   private  TextField username;
    public String getUserlog() {
        return userlog;
    }

    public void setUserlog(String userlog) {
        LoginControl1.userlog = userlog;
    }

    protected static String userlog;


    @FXML
void  loginbutton(MouseEvent event) {
       try {
           if(username.getText().isEmpty()||password.getText().isEmpty())
               JOptionPane.showMessageDialog(null, "User name or Password is empty ", "unvalied", JOptionPane.ERROR_MESSAGE);
else {

if(adminislogin())
    NextPage.make("adminpage.fxml", "Admin Page");

else  if (ownerislogin())
    NextPage.make("insert.fxml", "houses");
else  if (tenentislogin())
               NextPage.make("tenantMainScreen.fxml", "Tenant Page");

               else {
                   JOptionPane.showMessageDialog(null, "Please select one of radio button ", "Unvalid", JOptionPane.ERROR_MESSAGE);
               }

           }
       }

       catch (IOException e) {
           logger.log(null, "An error occurred while opening a new window:");
       }
   }

  public  boolean adminislogin() {
      if (adminRadio.isSelected()) {
          TESTLOGIN.fun(1);
          if (TESTLOGIN.userNametest(username.getText()) && TESTLOGIN.passWordtest(password.getText()))
              return true;
      }
      return  false;
  }


  public boolean ownerislogin() {
      if (ownerRadio.isSelected()) {
          TESTLOGIN.fun(2);
          if (TESTLOGIN.userNametest(username.getText()) && TESTLOGIN.passWordtest(password.getText()))
          {
              userlog = username.getText();
              setUserlog( username.getText())  ;
              return true;

          }
      }
      return  false;
  }

    public boolean tenentislogin() {
        if (tenantRadio.isSelected()) {
            TESTLOGIN.fun(3);
            if (TESTLOGIN.userNametest(username.getText()) && TESTLOGIN.passWordtest(password.getText()))
            {
                userlog = username.getText();
                setUserlog( username.getText())  ;
                return true;
            }
        }
        return  false;
    }




}