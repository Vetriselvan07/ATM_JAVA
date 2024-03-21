package DataLayer;

import MiddleLayer.TransactionHistory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SendMoneyDL {
    public int sendMoney(int userId,int debitAmount,String phNoOrAccNo)
    {
        long accBalance=0;
        try
        {
            String query="SELECT userAccountBalance from userDetails where userId='"+userId+"'";
            Connection con= Jdbc.getConnection();
            Statement st=con.createStatement();
            ResultSet rt=st.executeQuery(query);
            rt.next();
            accBalance=rt.getLong("userAccountBalance");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        if(accBalance<debitAmount)
        {
            System.out.println("Your account balance is lesser than the debit amount,Account balance : "+accBalance);
            return  0;
        }

        else {
            try {
                String query = "UPDATE userDetails SET userAccountBalance=userAccountBalance-'"+debitAmount+"' WHERE userId='"+userId+"'";
                Connection con=Jdbc.getConnection();
                Statement st=con.createStatement();
                st.executeUpdate(query);
                System.out.println("Send SuccessFully");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            TransactionHistory transactionHistoryObj=new TransactionHistory();
            transactionHistoryObj.transactionHistory(userId,"Debited and sent to '"+phNoOrAccNo+"'",debitAmount);
            return 1;
        }
    }
}
