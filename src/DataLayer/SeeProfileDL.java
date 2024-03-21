package DataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SeeProfileDL {
    public ResultSet seeProfileDL(int userId)
    {
        try
        {
            String query="SELECT * from userDetails where userId='"+userId+"'";
            Connection con= Jdbc.getConnection();
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
}
