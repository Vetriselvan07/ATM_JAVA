package UiLayer;

import Main.User;
import MiddleLayer.GetUserProfile;

import java.sql.ResultSet;

public class SeeProfile {
    public void seeProfile(int userId)
    {
        try {
            ResultSet rs=GetUserProfile.getUserProfile(userId);
            rs.next();

            String name=rs.getString("userName");
            int age=rs.getInt("userAge");
            String gender=rs.getString("userGender");
            String pass=rs.getString("userPassword");
            String phoneNumber=rs.getString("userPhoneNumber");
            long accountNumber=rs.getLong("userAccountNumber");
            long accountBalance=rs.getLong("userAccountBalance");

            User user=new User(name,age,gender,phoneNumber,pass,accountNumber,accountBalance);

            System.out.println("********************************************************");
            System.out.println("Name           : "+user.getName());
            System.out.println("Age            : "+user.getAge());
            System.out.println("Gender         : "+user.getGender());
            System.out.println("Phone Number   : "+user.getPhoneNumber());
            System.out.println("Account Number : "+user.getAccountNo());
            System.out.println("**********************************************************");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }
}



