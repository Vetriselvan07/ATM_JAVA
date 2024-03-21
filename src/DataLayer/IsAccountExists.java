package DataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class IsAccountExists{
    Jdbc jdbcObj=new Jdbc();
    Connection con=jdbcObj.getConnection();
    public boolean isAccountExists(String phNo, String password)
    {
        int a=1;
        try
        {
            String query ="SELECT EXISTS(SELECT * FROM userDetails WHERE userPhoneNumber='"+phNo+"' AND userPassword='"+password+"') AS RES";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            a=rs.getInt("RES");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        if(a==1)
            return true;
        return false;
    }

}
