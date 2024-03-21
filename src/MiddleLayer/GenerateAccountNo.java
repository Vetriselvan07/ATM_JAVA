package MiddleLayer;

import DataLayer.IsAccNoAlreadyExists;

public class GenerateAccountNo {
    public static long generateAccNo()
    {
        long accountNumber=1;
        double dummy;
        while(Long.toString(accountNumber).length()<14)
        {
            dummy= Math.random();
            long d= (long) (dummy*1000);
            accountNumber= accountNumber*d;
            if(Long.toString(accountNumber).length()==14)
            {
                if(IsAccNoAlreadyExists.isAccNoAlreadyExists(accountNumber)==0) {
                    return accountNumber;
                }
                else
                {
                    return generateAccNo();
                }

            }
            else if(Long.toString(accountNumber).length()>14)
            {
                while(!(Long.toString(accountNumber).length()==14))
                {
                    accountNumber=accountNumber/10;
                }
                if(IsAccNoAlreadyExists.isAccNoAlreadyExists(accountNumber)==0) {
                    return accountNumber;
                }
                else
                {
                    return generateAccNo();
                }
            }

        }
        return accountNumber;
    }
}
