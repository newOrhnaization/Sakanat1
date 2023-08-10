package com.example.sw_final;
import java.util.ArrayList;
import java.util.List;

public class Sakanat {
    protected  static   int ww=0;
String f="female";
    protected static   int m=0;

    protected static final List<HouseClass> house1 = new ArrayList<>();
    protected   static final List<AdminClass> admin1 = new ArrayList<>();
    protected   static final List<OwnerClass> owner1 = new ArrayList<>();
    protected   static final List<TenantClass> tenant1 = new ArrayList<>();
    protected   static final List<AdminRequist> request = new ArrayList<>();
    protected   static final List<Furniture> furniture = new ArrayList<>();


    public Sakanat()
    {
        addadmin();
        addhouse();
        addowner();
        addtenant();
        addrequest();
    }
public static void addhouse()
{
    HouseClass h1=new HouseClass();
    h1.setPicture("C:\\Users\\hp\\Desktop\\summer2023\\SW\\houses_picture\\house1.jpg");
    h1.setServices("electricy,water");
    h1.setLocation("rafidia");
    h1.setPrice(Integer.parseInt("650"));
    h1.setBalcony(Integer.parseInt("3"));
    h1.setBedroom(Integer.parseInt("3"));
    h1.setBathroom(Integer.parseInt("3"));
    h1.setNumberhouse(Integer.parseInt("1102230"));
    h1.setIdOwner(408895811);
    h1.setaccepted(true);
    house1.add(h1);

    HouseClass h2=new HouseClass();
    h2.setPicture("C:\\Users\\hp\\Desktop\\summer2023\\SW\\houses_picture\\house2.jpg");
    h2.setServices("electricy,water,WIFI");
    h2.setLocation("najah_street");
    h2.setPrice(Integer.parseInt("700"));
    h2.setBalcony(Integer.parseInt("1"));
    h2.setBedroom(Integer.parseInt("4"));
    h2.setBathroom(Integer.parseInt("4"));
    h2.setNumberhouse(Integer.parseInt("1101180"));
    h2.setIdOwner(428678901);
    h2.setaccepted(true);
    house1.add(h2);


    HouseClass h3=new HouseClass();
    h3.setPicture("C:\\Users\\hp\\Desktop\\summer2023\\SW\\houses_picture\\house3.jpg");
    h3.setServices("water,WIFI, maintainability");
    h3.setLocation("next to 3al taree2 ");
    h3.setPrice(Integer.parseInt("650"));
    h3.setBalcony(Integer.parseInt("2"));
    h3.setBedroom(Integer.parseInt("3"));
    h3.setBathroom(Integer.parseInt("4"));
    h3.setNumberhouse(Integer.parseInt("1234567"));
    h3.setIdOwner(1234560);
    h3.setaccepted(true);
    house1.add(h3);

}

    public void addowner()
    {
        OwnerClass h1=new OwnerClass();
       h1.setid(408895811);
       h1.setAddress("Nabluse");
       h1.setPassword("12345**");
       h1.setPhonenumber(595861031);
       h1.setUsername("Abdullah Hussain");
        owner1.add(h1);

        OwnerClass h2=new OwnerClass();
        h2.setid(428678901);
        h2.setAddress("Jenen");
        h2.setPassword("987654");
        h2.setPhonenumber(597257511);
        h2.setUsername("Bader ibrahem");
        owner1.add(h2);

        OwnerClass h3=new OwnerClass();
        h3.setid(1234560);
        h3.setAddress("tell");
        h3.setPassword("00012");
        h3.setPhonenumber(578264125);
        h3.setUsername("Rania sami");
        owner1.add(h3);
    }
    public void addadmin()
    {

        AdminClass h1=new AdminClass();
        h1.setPassword("123456**");
        h1.setUsername("Raia Ishtayeh");
        admin1.add(h1);

        AdminClass h2=new AdminClass();
        h2.setPassword("654321**");
        h2.setUsername("Rayhan Mahmoud");
        admin1.add(h2);
    }
    public void addtenant()
    {
        TenantClass h1=new TenantClass();
        h1.setAge(20);
        h1.setid(425968711);
        h1.setGender(f);
        h1.setPhoneNumber(593646472);
        h1.setPassword("98765**");
        h1.setUniversityMajors("CE");
        h1.setUsername("Salma abdullah");
        h1.setBooked(true);
        tenant1.add(h1);

        TenantClass h2=new TenantClass();
        h2.setAge(30);
        h2.setid(745895644);
        h2.setGender("male");
        h2.setPhoneNumber(595761287);
        h2.setPassword("22");
        h2.setUniversityMajors("medicin");
        h2.setUsername("Ghaith");
        h2.setBooked(false);
        tenant1.add(h2);


        TenantClass t3=new TenantClass();
        t3.setAge(24);
        t3.setid(4322145);
        t3.setGender(f);
        t3.setPhoneNumber(598868402);
        t3.setPassword("33");
        t3.setUniversityMajors("Industrial Engineering");
        t3.setUsername("Azhar");
        t3.setBooked(true);
        tenant1.add(t3);


        TenantClass t4=new TenantClass();
        t4.setAge(26);
        t4.setid(123456);
        t4.setGender(f);
        t4.setPhoneNumber(598846622);
        t4.setPassword("22");
        t4.setUniversityMajors("electrical Engineering");
        t4.setUsername("afnan");
        t4.setBooked(true);
        tenant1.add(t4);
    }

    public void addrequest()
    {

        AdminRequist h1=new AdminRequist();
        h1.setHouseNum(1102230);
        h1.setUsername("Salma abdullah");
      request.add(h1);

        AdminRequist h2=new AdminRequist();
        h2.setHouseNum(1101180);
        h2.setUsername("afnan");
        request.add(h2);
    }


}
