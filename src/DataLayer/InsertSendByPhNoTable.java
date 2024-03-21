package DataLayer;

import Main.MoneySendByPhNo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertSendByPhNoTable {
    public void insertSendByPhNoTable(MoneySendByPhNo moneySendByPhNoObj)
    {
         try
         {
             String query="INSERT INTO sendMoneyByPhNo(fromPhoneNumber,toPhoneNumber,todayDate,amountSent) VALUES(?,?,?,?)";
             Connection con= Jdbc.getConnection();
             PreparedStatement stm=con.prepareStatement(query);
             stm.setString(1,moneySendByPhNoObj.getFromPhoneNumber());
             stm.setString(2,moneySendByPhNoObj.getToPhoneNumber());
             stm.setString(3,moneySendByPhNoObj.getTransactionDate());
             stm.setLong(4,moneySendByPhNoObj.getAmountSent());
             stm.executeUpdate();

         }
         catch (Exception e)
         {
             System.out.println(e);
         }


    }
}
