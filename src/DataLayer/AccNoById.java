package DataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccNoById {
    public static String  getAccNoById(int userId)
    {
        try
        {
            String query="SELECT userAccountNumber from userDetails where userId='"+userId+"'";
            Connection con= Jdbc.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            return rs.getString("userAccountNumber");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}
