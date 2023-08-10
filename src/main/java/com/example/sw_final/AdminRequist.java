package com.example.sw_final;

public class AdminRequist {


    public AdminRequist(AdminRequist data) {
        this.username=data.username;
        this.houseNum  = data.houseNum;

    }    public AdminRequist() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    private String username;

    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    private int houseNum;


}
