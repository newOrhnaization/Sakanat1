package com.example.sw_final;

import javax.swing.*;

public class TESTLOGIN {
    protected   static int typeuser;
    public static   void fun(int x)
    {
        typeuser=x;
    }
    private static   String x="user not found";
    private    static  String y="incorrect";
    private TESTLOGIN()
    {
    }
    protected  static boolean flag=true;
    public static boolean userNametest(String string2) {
        if(typeuser==1)
        {
          return   checkuser1( string2);
        }
        else if (typeuser==2)
        {
          return   checkuser2(string2);
        }
        else if(typeuser==3)
        {
           return checkuser3(string2);
        }
        return false;
    }




    public static boolean passWordtest(String string2)

    {
        if(typeuser==1)
        {
         return    checkpass1(string2);
        }
        else if (typeuser==2)
        {
          return   checkpass2(string2);
        }
        else if(typeuser==3)
        {
         return    checkpass3(string2);
        }
        return false;
    }



    public  static boolean  checkuser1( String string2)
    {
        if(Sakanat.admin1.get(0).getUsername().trim().equals(string2.trim()))
            return true;
        else if(Sakanat.admin1.get(1).getUsername().trim().equals(string2.trim()))
            return true;
        else {
            JOptionPane.showMessageDialog(null, x, y, JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public  static  boolean checkuser2(String string2)
    {
        for (int i=0;i<Sakanat.owner1.size();i++)
        {
            if(Sakanat.owner1.get(i).getUsername().trim().equals(string2.trim()))
            {
                HelloController.ownerid=Sakanat.owner1.get(i).getid();
                return true;
            }
            else   flag=false;
        }
        JOptionPane.showMessageDialog(null, x, y, JOptionPane.ERROR_MESSAGE);
        flag=true;
        return  false;
    }

    public  static  boolean checkuser3(String string2)
    {
        for (int i=0;i<Sakanat.tenant1.size();i++)
        {
            if(Sakanat.tenant1.get(i).getUsername().trim().equals(string2.trim()))
                return true;
            else   flag=false;
        }

        JOptionPane.showMessageDialog(null, x, y, JOptionPane.ERROR_MESSAGE);
        flag=true;
        return  false;
    }

    public  static  boolean checkpass1(String string2)
    {
        if(Sakanat.admin1.get(0).getPassword().trim().equals(string2.trim()))
            return true;

        return Sakanat.admin1.get(1).getPassword().trim().equals(string2.trim());

    }

    public  static  boolean checkpass2(String string2)
    {
        for (int i=0;i<Sakanat.owner1.size();i++)
        {
            if(Sakanat.owner1.get(i).getPassword().trim().equals(string2.trim()))
                return true;
            else   flag=false;
        }

        JOptionPane.showMessageDialog(null, x, y, JOptionPane.ERROR_MESSAGE);
        flag=true;
        return  false;
    }



    public  static  boolean checkpass3(String string2)
    {
        for (int i=0;i<Sakanat.tenant1.size();i++)
        {
            if(Sakanat.tenant1.get(i).getPassword().trim().equals(string2.trim()))
                return true;
            else  flag=false;

        }

        JOptionPane .showMessageDialog(null, x, y, JOptionPane.ERROR_MESSAGE);
        flag=true;
        return  false;
    }
}
