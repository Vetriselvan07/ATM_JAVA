package MiddleLayer;

import DataLayer.IsCCAndAadharNumberAlreadyExists;

public class GenerateCreditCard {//Generate Credit card number and cvv using Math.random() and then return them;
    public static long generateCreditCardNumber()
    {
        IsCCAndAadharNumberAlreadyExists isCCNumberAlreadyExistsObj=new IsCCAndAadharNumberAlreadyExists();
        long creditCardNumber=123;
        double dummy;
        while(Long.toString(creditCardNumber).length()<16)
        {
            dummy= Math.random();
            long d= (long) (dummy*1000);
            creditCardNumber= creditCardNumber*d;
            if(Long.toString(creditCardNumber).length()==16)
            {
                if(isCCNumberAlreadyExistsObj.isCCNumberAlreadyExists(creditCardNumber)==0)
                {
                    return creditCardNumber;
                }
                else {
                    return generateCreditCardNumber();
                }
            }
            else if(Long.toString(creditCardNumber).length()>16)
            {
                while(!(Long.toString(creditCardNumber).length()==16))
                {
                    creditCardNumber=creditCardNumber/10;
                }
                //Check whether generated Credit Card number Already Exists;
                if(isCCNumberAlreadyExistsObj.isCCNumberAlreadyExists(creditCardNumber)==0)
                {
                    return creditCardNumber;
                }
                else {
                    return generateCreditCardNumber();
                }
            }

        }
        return creditCardNumber;
    }

    public static int generateCVV()
    {
        int cvv=123;
        double dummy;
        while(Long.toString(cvv).length()<16)
        {
            dummy= Math.random();
            int d= (int) (dummy*1000);
            cvv= cvv*d;
            if(Long.toString(cvv).length()==3)
            {
                return cvv;
            }
            else if(Long.toString(cvv).length()>3)
            {
                while(!(Long.toString(cvv).length()==3))
                {
                    cvv=cvv/10;
                }
                return cvv;
            }
        }
        return cvv;
    }
}
