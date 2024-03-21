package MiddleLayer;

import DataLayer.CreditCardDetails;

public class IsAccAlreadyHaveCC {//while user click apply credit card,check the user already have a credit card or not;
    public int isAccAlreadyHaveCC(int userId)
    {
        CreditCardDetails creditCardDetailsObj=new CreditCardDetails();
        return creditCardDetailsObj.checkCreditCardAlreadyExits(userId);
    }
}
