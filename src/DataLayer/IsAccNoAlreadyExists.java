package DataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IsAccNoAlreadyExists {//check The generated Account Number already Registered or not;
    public static int isAccNoAlreadyExists(long accountNumber)
    {
        try
        {
            String query="SELECT EXISTS(SELECT * FROM userDetails where userAccountNumber='"+accountNumber+"') as res";
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
