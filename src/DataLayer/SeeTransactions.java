package DataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SeeTransactions {
    public ResultSet seeTransactions(int userId)
    {
        Connection con= Jdbc.getConnection();

        try
        {
            String query="SELECT * FROM transactionHistory where userId='"+userId+"'";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            return rs;

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}
