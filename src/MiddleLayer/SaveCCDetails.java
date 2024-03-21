package MiddleLayer;

import DataLayer.CreditCardDetails;
import Main.CreditCard;

public class SaveCCDetails {
    public void saveCreditCardDetails(CreditCard creditCard)
    {
        CreditCardDetails creditCardDetailsObj=new CreditCardDetails();
        creditCardDetailsObj.creditCardDetails(creditCard);
    }
}
