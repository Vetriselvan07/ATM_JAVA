package DataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IsAccNoReg {//while sending money to anyone using account number,check the Account number have an account;
    public boolean isAccNoReg(String accNo)
    {
        int a=1;
        try
        {
            String query="SELECT EXISTS(SELECT * FROM userDetails where userAccountNumber='"+accNo+"') as res";
            Connection con= Jdbc.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            a=rs.getInt("res");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        if(a==1) {

            return true;
        }
        return false;
    }
}
