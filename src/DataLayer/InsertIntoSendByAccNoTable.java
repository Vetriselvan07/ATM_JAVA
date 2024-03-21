package DataLayer;

import Main.MoneySendByAccNo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertIntoSendByAccNoTable {
    public void insertIntoSendByAccNoTable(MoneySendByAccNo moneySendByAccNo)
    {
        try
        {
            String query="INSERT INTO sendMoneyByAccNo(fromAccountNumber,toAccountNumber,todayDate,amountSent) VALUES(?,?,?,?)";
            Connection con= Jdbc.getConnection();
            PreparedStatement stm=con.prepareStatement(query);
            stm.setString(1, moneySendByAccNo.getFromAccNumber());
            stm.setString(2, moneySendByAccNo.getToAccNumber());
            stm.setString(3,moneySendByAccNo.getTransactionDate());
            stm.setLong(4,moneySendByAccNo.getAmountSent());
            stm.executeUpdate();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }
}
