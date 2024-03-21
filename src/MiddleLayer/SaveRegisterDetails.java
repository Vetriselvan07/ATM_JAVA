package MiddleLayer;

import DataLayer.InterSetRegisterDetail;
import DataLayer.SetRegisterDetails;
import Main.User;
public class SaveRegisterDetails {
    public void saveRegisterDetails(User user){
        InterSetRegisterDetail setRegisterDetailsObj=new SetRegisterDetails();
        setRegisterDetailsObj.setRegisterDetails(user);
    }
}
