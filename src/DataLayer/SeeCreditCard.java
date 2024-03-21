package DataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SeeCreditCard {
    public ResultSet seeCreditCard(int userId)
    {
        Connection con= Jdbc.getConnection();
        try
        {
            String query="SELECT * FROM creditCard WHERE userId='"+userId+"'";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            return rs;

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
    public static int isAccountHaveCC(int userId)//Check the user first have credit Card or not;
    {
        try
        {
            String query="SELECT EXISTS(SELECT * FROM creditCard WHERE userId='"+userId+"') as res";
            Connection con=Jdbc.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            return  rs.getInt("res");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return 0;

    }
}
