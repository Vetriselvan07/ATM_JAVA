package DataLayer;

import Main.CreditCard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreditCardDetails {
    public void creditCardDetails(CreditCard creditCard){
        Jdbc jdbcObj=new Jdbc();
        Connection con= jdbcObj.getConnection();
        try {
            String query = "INSERT INTO creditCard(userId,userPhoneNumber,aadharNumber,cardNumber,cvv,expiryDate) VALUES(?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, creditCard.getUserId());
            st.setString(2, creditCard.getPhoneNumber());
            st.setString(3, creditCard.getAadharNumber());
            st.setLong(4, creditCard.getCreditCardNumber());
            st.setInt(5, creditCard.getCvv());
            st.setString(6, creditCard.getExpiryDate());
            st.executeUpdate();
            System.out.println("Applied successfully");
        }
        catch (Exception e)
        {

        }
    }
    public int checkCreditCardAlreadyExits(int userId)
    {
        //Jdbc jdbcObj=new Jdbc();
        Connection con= Jdbc.getConnection();
        int a=0;
        try
        {
            String query="SELECT EXISTS(SELECT * FROM creditCard WHERE userId='"+userId+"') as res";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            a=rs.getInt("res");
            return a;

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return a;
    }
}
