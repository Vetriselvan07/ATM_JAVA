package UiLayer;

import DataLayer.SeeTransactions;
import Main.TransactionHistory;

import java.sql.ResultSet;

public class GetTransactionDetails {
    public static void getTransactionDetails(int userId)
    {
        SeeTransactions seeTransactionsObj=new SeeTransactions();
        ResultSet rs=seeTransactionsObj.seeTransactions(userId);
        int count=1;
        try {
            while (rs.next()) {
                String transactionDate=rs.getString("transactionDate");
                String debitOrCredit=rs.getString("debitOrCredit");
                long amount=rs.getLong("amount");
                long accBal=rs.getLong("accountBalance");

                TransactionHistory transactionHistory=new TransactionHistory(userId,transactionDate,debitOrCredit,amount,accBal);

                System.out.println("***************************************");
                System.out.println("S.NO            : " + count);
                System.out.println("Date            : " + transactionHistory.getTodayDate());
                System.out.println("Status          : " + transactionHistory.getDebitOrCredit());
                System.out.println("Amount          : " + transactionHistory.getTransactionAmount());
                System.out.println("Account Balance : " + transactionHistory.getBalance());
                System.out.println("****************************************");
                count++;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
