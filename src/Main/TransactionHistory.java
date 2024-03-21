package Main;

public class TransactionHistory {
    private int userId;
    private String todayDate;
    private String debitOrCredit;
    private long transactionAmount;
    private long balance;

    public TransactionHistory(int userId, String todayDate, String debitOrCredit, long transactionAmount, long balance) {
        this.userId = userId;
        this.todayDate = todayDate;
        this.debitOrCredit = debitOrCredit;
        this.transactionAmount = transactionAmount;
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public String getTodayDate() {
        return todayDate;
    }

    public String getDebitOrCredit() {
        return debitOrCredit;
    }

    public long getTransactionAmount() {
        return transactionAmount;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
