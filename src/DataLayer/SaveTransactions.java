package DataLayer;

import Main.TransactionHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SaveTransactions {
    public static void saveTransactions(TransactionHistory transactionHistory)
    {
        Connection con=Jdbc.getConnection();
        try {
            String query1="SELECT userAccountBalance FROM userDetails WHERE userId='"+transactionHistory.getUserId()+"'";
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(query1);
            rs.next();
            transactionHistory.setBalance(rs.getLong("userAccountBalance"));

            String query = "INSERT INTO transactionHistory(userId,transactionDate,debitOrCredit,amount,accountBalance) VALUES(?,?,?,?,?)";
            PreparedStatement st =con.prepareStatement(query);
            st.setInt(1,transactionHistory.getUserId());
            st.setString(2,transactionHistory.getTodayDate());
            st.setString(3,transactionHistory.getDebitOrCredit());
            st.setLong(4,transactionHistory.getTransactionAmount());
            st.setLong(5,transactionHistory.getBalance());
            st.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}
