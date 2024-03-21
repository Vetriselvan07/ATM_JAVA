package DataLayer;

import java.sql.Connection;
import java.sql.Statement;

public class ChangePass {
    public void changePassword(String newPass,int id)
    {
        String query ="UPDATE userDetails SET userPassword='"+newPass+"' WHERE userId='"+id+"'";
        try
        {
            Connection con=Jdbc.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate(query);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
