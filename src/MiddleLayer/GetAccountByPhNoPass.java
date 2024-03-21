package MiddleLayer;


import DataLayer.IsAccountExists;

public class GetAccountByPhNoPass {
    public boolean getAccountByPhNoPass(String phNo,String pass){
        IsAccountExists isAccountExistsObj=new IsAccountExists();
        return isAccountExistsObj.isAccountExists(phNo,pass);
    }
}
