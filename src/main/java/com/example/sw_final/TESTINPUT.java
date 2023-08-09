package com.example.sw_final;

import java.util.Date;

public  class TESTINPUT {
    private TESTINPUT() {
    }


    public static boolean priceTest(String price) {
        boolean g = false;
        int num = Integer.parseInt(price);
        if (num > 0) g = true;

        if (price.length() > 0) {
            boolean flag = true;
            for (int i = 0; i < price.length(); i++) {
                if (!Character.isDigit(price.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            return (flag && g);
        }
        return false;
    }

    public static boolean housePictureTest(String string2) {
        return (string2.indexOf(".png") != -1 || string2.indexOf(".jpg") != -1);
    }

    public static boolean houseServicesTest(String services) {
        boolean flag = true;
        for (int i = 0; i < services.length(); i++) {
            if (Character.isDigit(services.charAt(i))) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static boolean houseBedroomTest(String string2) {
        return TESTINPUT.priceTest(string2);

    }

    public static boolean houseBathroomTest(String string2) {
        return TESTINPUT.priceTest(string2);
    }

    public static boolean houseBalconyTest(String string2) {
        int num = Integer.parseInt(string2);
        if (num == 0)
            return true;
        return TESTINPUT.priceTest(string2);
    }
    public static boolean houseNumbertest(String string2) {
        boolean f=false;

        if ((string2.length() == 7)&&Character.isDigit(string2.charAt(0)) && Character.isDigit(string2.charAt(1)) && (Character.isDigit(string2.charAt(2)) || (string2.charAt(2) == 'G') || (string2.charAt(2) == 'B') || (string2.charAt(2) == 'g') || (string2.charAt(2) == 'b')) &&
                Character.isDigit(string2.charAt(3)) && Character.isDigit(string2.charAt(4)) && Character.isDigit(string2.charAt(5)) && Character.isDigit(string2.charAt(6)))
            f= true;

return f;
    }

    public static boolean testfail(String string, String string2)
    {
        String ss="0";
        boolean s;
        boolean p;
        boolean b1;
        boolean b3;
        boolean b2;
        boolean m;
        boolean h;
        h=true;
        s=true;b1=true;b2=true;b3=true;
        m=true;
        if(string.equals("Services")){
         s=!TESTINPUT.houseServicesTest(string2);
        }

        else if (string.equals("Bedroom")) {
           b1=TESTINPUT.houseBedroomTest(string2);
        }
        else if (string.equals("Bathroom")) {
           b2=TESTINPUT.houseBathroomTest(string2);
        }
        else if(string.equals("Balcony")){
          b3=TESTINPUT.houseBalconyTest(string2);
        }

        else  if(string.equals("housenumber")){
           h= TESTINPUT.houseNumbertest(string2);
        }
        else if(string.equals("Location"))
        {
            return  false;
        }
        p=TESTINPUT.priceTest(ss);
        return  (s&&p&&b1&&b2&&b3&&h&&m);

    }
}
