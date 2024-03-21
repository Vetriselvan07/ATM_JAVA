package MiddleLayer;

import DataLayer.SaveTransactions;


public class TransactionHistory {
    public void transactionHistory(int userId,String debitOrCredit,long amount)
    {
        String todayDate=GetTodayDate.getTodayDate();

        Main.TransactionHistory transactionHistoryObj=new Main.TransactionHistory(userId,todayDate,debitOrCredit,amount,0);

        SaveTransactions.saveTransactions(transactionHistoryObj);
    }
}
