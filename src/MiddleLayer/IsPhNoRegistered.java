package MiddleLayer;

import DataLayer.SetRegisterDetails;

public class IsPhNoRegistered {//While sending money to anyone using phone Number check the To Phone Number have an account;
    public static boolean isPhNoRegistered(String toPhoneNumber)
    {
        SetRegisterDetails setRegisterDetailsObj=new SetRegisterDetails();
        return setRegisterDetailsObj.isPhNoAlreadyRegistered(toPhoneNumber);
    }


}
