package DataLayer;

import MiddleLayer.TransactionHistory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class AtmProcesses implements InterAccountProcess{
    Jdbc jdbc=new Jdbc();
    Connection con=jdbc.getConnection();

    public void addMoney(int depositAmount,int id)
    {
        String query ="UPDATE userDetails SET userAccountBalance=userAccountBalance+'"+depositAmount+"' WHERE userId='"+id+"'";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(query);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        TransactionHistory transactionHistoryObj=new TransactionHistory();
        transactionHistoryObj.transactionHistory(id,"Credited",depositAmount);
    }
    public void getWithdraw(int withdrawAmount,int id)
    {
        String query ="UPDATE userDetails SET userAccountBalance=userAccountBalance-'"+withdrawAmount+"' WHERE userId='"+id+"'";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(query);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        TransactionHistory transactionHistoryObj=new TransactionHistory();
        transactionHistoryObj.transactionHistory(id,"Debited",withdrawAmount);
    }
    public long getAccountBalanceInJdbc(int id)
    {
        String query="SELECT userAccountBalance FROM userDetails WHERE userId='"+id+"'";
        try {
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            return rs.getLong("userAccountBalance");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 0;
    }
}
