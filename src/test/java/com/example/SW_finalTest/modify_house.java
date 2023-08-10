package com.example.SW_finalTest;
import com.example.sw_final.AdminControll;
import com.example.sw_final.LoginControl1;

import com.example.sw_final.ModifyControll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
public class modify_house {

    @Given("I am logged in as an administrator")
    public void iAmLoggedInAsAnAdministrator() {
        assertEquals(true, LoginControl1.ADMINLOGIN1);

    }
    @Given("I have navigated to the housing data management page")
    public void iHaveNavigatedToTheHousingDataManagementPage() {
        assertEquals(true, AdminControll.CONTROLIN);

    }
    @When("I select a property to modify")
    public void iSelectAPropertyToModify() {
        assertEquals(true, AdminControll.MODIFYCLICKED);

    }
    @When("I enter invalid data for one or more fields")
    public void iEnterInvalidDataForOneOrMoreFields() {
        assertEquals(false, ModifyControll.CHECKED);

    }
    @Then("the changes are not saved and message show {string}")
    public void theChangesAreNotSavedAndMessageShow(String string) {
        assertEquals(true,string.equals("invalid data entered"));
    }




    @Given("I have modified a property")
    public void iHaveModifiedAProperty() {
        assertEquals(true,ModifyControll.isModifyTEST());

    }
    @Then("I save the changes and message show {string}")
    public void iSaveTheChangesAndMessageShow(String string) {
        assertEquals(true,string.equals("modify data successful"));


    }



}
