package DataLayer;

import MiddleLayer.GetTodayDate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreditToSendAccount {
    public void creditToSendAccountByPhNo(String phoneNumber, long amount,int fromUserId)
    {
        try {
            String query="UPDATE userDetails SET userAccountBalance=userAccountBalance+'"+amount+"' where userPhoneNumber='"+phoneNumber+"'";
            Connection con= Jdbc.getConnection();
            Statement st=con.createStatement();
            st.executeUpdate(query);
            String getIdQuery="SELECT userId,userAccountBalance from userDetails where userPhoneNumber='"+phoneNumber+"'";
            ResultSet rs=st.executeQuery(getIdQuery);
            rs.next();
            int userId=rs.getInt("userId");
            long userAccountBalance=rs.getLong("userAccountBalance");

            String dateStr= GetTodayDate.getTodayDate();
            //get Phone number from
            String getPhNoQuery="SELECT userPhoneNumber FROM userDetails WHERE userId='"+fromUserId+"'";
            ResultSet rs1=st.executeQuery(getPhNoQuery);
            rs1.next();
            String fromPhNo=rs1.getString("userPhoneNumber");


            String transactionQuery="INSERT INTO transactionHistory(userId,transactionDate,debitOrCredit,amount,accountBalance) values(?,?,?,?,?)";
            Connection con1=Jdbc.getConnection();

            PreparedStatement stm=con1.prepareStatement(transactionQuery);
            stm.setInt(1,userId);
            stm.setString(2,dateStr);
            stm.setString(3,"Credited from phone Number : '"+fromPhNo+"'" );
            stm.setLong(4,amount);
            stm.setLong(5,userAccountBalance);
            stm.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void creditToSendAccountByAccNo(String accNo,long amount,int fromUserId)
    {
        try {
            String query="UPDATE userDetails SET userAccountBalance=userAccountBalance+'"+amount+"' where userAccountNumber='"+accNo+"'";
            Connection con= Jdbc.getConnection();
            Statement st=con.createStatement();
            st.executeUpdate(query);
            String getIdQuery="SELECT userId,userAccountBalance from userDetails where userAccountNumber='"+accNo+"'";
            ResultSet rs=st.executeQuery(getIdQuery);
            rs.next();
            int userId=rs.getInt("userId");
            long userAccountBalance=rs.getLong("userAccountBalance");

            String dateStr=GetTodayDate.getTodayDate();
            //get Phone number from
            String getPhNoQuery="SELECT userAccountNumber FROM userDetails WHERE userId='"+fromUserId+"'";
            ResultSet rs1=st.executeQuery(getPhNoQuery);
            rs1.next();
            String fromAccNo=rs1.getString("userAccountNumber");


            String transactionQuery="INSERT INTO transactionHistory(userId,transactionDate,debitOrCredit,amount,accountBalance) values(?,?,?,?,?)";

            PreparedStatement stm=con.prepareStatement(transactionQuery);
            stm.setInt(1,userId);
            stm.setString(2,dateStr);
            stm.setString(3,"Credited from Account Number : '"+fromAccNo+"'" );
            stm.setLong(4,amount);
            stm.setLong(5,userAccountBalance);
            stm.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

