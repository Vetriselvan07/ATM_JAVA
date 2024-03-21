package DataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IsCCAndAadharNumberAlreadyExists {
    public int isCCNumberAlreadyExists(long creditCardNumber)
    {
        try
        {
            String query="SELECT EXISTS(SELECT * FROM creditCard where cardNumber='"+creditCardNumber+"') as res";
            Connection con= Jdbc.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            return rs.getInt("res");

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 0;
    }
    public static int isAadharNumberAlreadyExists(String aadharNumber)
    {
        try
        {
            String query="SELECT EXISTS(SELECT * FROM creditCard where aadharNumber='"+aadharNumber+"') as res";
            Connection con= Jdbc.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            return rs.getInt("res");

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 0;
    }
}
