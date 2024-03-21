package UiLayer;

import DataLayer.SeeCreditCard;
import Main.CreditCard;
import MiddleLayer.IsUserHaveCC;

import java.sql.ResultSet;

public class GetCreditCardDetails {
    public static void getCreditCardDetails(int userId)
    {
        SeeCreditCard seeCreditCardObj=new SeeCreditCard();
        ResultSet rs=seeCreditCardObj.seeCreditCard(userId);

        if(IsUserHaveCC.isUserHaveCC(userId)) {
            try {
                rs.next();
                long cardNumber=rs.getLong("cardNumber");
                String phoneNumber=rs.getString("userPhoneNumber");
                String expirydate=rs.getString("expiryDate");
                int cvv=rs.getInt("cvv");
                long aadharN0=rs.getLong("aadharNumber");
                String aadharNumberStr= String.valueOf(aadharN0);

                CreditCard creditCardObj=new CreditCard(userId,phoneNumber,aadharNumberStr,cardNumber,expirydate,cvv);

                System.out.println("***********************************");
                System.out.println("Credit card Number : " + creditCardObj.getCreditCardNumber());
                System.out.println("Expiry Date        : " + creditCardObj.getExpiryDate());
                System.out.println("cvv                : " + creditCardObj.getCvv());
                System.out.println("Aadhar card Number : " + creditCardObj.getAadharNumber());
                System.out.println("************************************");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            System.out.println("Please First apply for credit Card");
        }
    }
}
