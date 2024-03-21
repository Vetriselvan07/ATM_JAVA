package DataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountHolderName {
    public String getAccHolderNameByPhNo(String phoneNumber)
    {
        String query="SELECT userName FROM userDetails Where userPhoneNumber='"+phoneNumber+"'";
        return getAccHolderName(query);
    }
    public String getAccHolderNameByAccNo(String userAccountNumber)
    {
        String query="SELECT userName FROM userDetails Where userAccountNumber='"+userAccountNumber+"'";
        return getAccHolderName(query);

    }
    private String getAccHolderName(String query)
    {
        Connection con= Jdbc.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            return  rs.getString("userName");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

}
