package com.example.sw_final;

public class HouseClass {
    private  int idOwner;

    private String picture;
    private String services;
    private String location;
    private int price;
    private int bathroom;
    private int bedroom ;
    private int balcony ;
    private int numberHouse ;
    private int numberTenant;
    private  boolean showed;
    private  boolean accepted;
    public HouseClass()
    {

    }
    public HouseClass(HouseClass data)
    {
        this.picture=data.picture;
        this.services=data.services;
        this.location=data.location;
        this.balcony=data.balcony;
        this.bedroom=data.bedroom;
        this.bathroom=data.bathroom;
        this.numberHouse=data.numberHouse;
        this.price=data.price;
        this.numberTenant=0;
        this.accepted=false;
        this.showed=false;
        this.idOwner=data.idOwner;
    }
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getServices() {
        return services;
    }
    public void setServices(String services) {
        this.services = services;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getBathroom() {
        return bathroom;
    }
    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }
    public int getBedroom() {
        return bedroom;
    }
    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }
    public int getBalcony() {
        return balcony;
    }
    public void setBalcony(int balcony) {
        this.balcony = balcony;
    }
    public int getNumberhouse() {
        return numberHouse;
    }
    public void setNumberhouse(int numberHouse) {
        this.numberHouse = numberHouse;
    }
    public int getNumbertenant() {
        return numberTenant;
    }
    public void setNumbertenant(int numberTenant) {
        this.numberTenant = numberTenant;
    }
    public boolean getaccepted() {
        return accepted;
    }
    public void setaccepted(boolean accepte) {
        this.accepted = accepte;
    }
    public boolean isShowed() {
        return showed;
    }
    public void setShowed(boolean showed) {
        this.showed = showed;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }
}
