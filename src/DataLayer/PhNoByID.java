package DataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PhNoByID {
    public static String  getPhNoById(int userId)
    {
        try
        {
            String query="SELECT userPhoneNumber from userDetails where userId='"+userId+"'";
            Connection con= Jdbc.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            return rs.getString("userPhoneNumber");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}
