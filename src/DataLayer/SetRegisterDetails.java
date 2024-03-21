package DataLayer;

import Main.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class SetRegisterDetails implements InterSetRegisterDetail{
    Jdbc jdbcObj=new Jdbc();
    Connection con=jdbcObj.getConnection();
    public void setRegisterDetails(User user){
        try
        {
            String query ="INSERT INTO userDetails(userName,userAge,userGender,userPhoneNumber,userPassword,userAccountBalance,userAccountNumber) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement stm=con.prepareStatement(query);
            stm.setString(1,user.getName());
            stm.setInt(2,user.getAge());
            stm.setString(3,user.getGender());
            stm.setString(4,user.getPhoneNumber());
            stm.setString(5,user.getPassword());
            stm.setLong(6,user.getAccountBalance());
            stm.setLong(7,user.getAccountNo());
            stm.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public boolean isPhNoAlreadyRegistered(String phNo)
    {
        String query="SELECT EXISTS(SELECT * FROM userDetails WHERE userPhoneNumber='"+phNo+"') AS RESULT";
        int result=1;
        try {
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            if(rs==null)
                return false;
            rs.next();
            result=rs.getInt("RESULT");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        if(result==1) {
            String query1="SELECT userName from userDetails WHERE userPhoneNumber='"+phNo+"'";
            try
            {
                Statement st1=con.createStatement();
                ResultSet rs1=st1.executeQuery(query1);
                rs1.next();
                //System.out.println("Account Holder Name : "+rs1.getString("userName"));
            }
            catch (Exception e)
            {

            }
            return true;
        }
        return false;
    }
}
