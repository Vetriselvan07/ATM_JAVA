package DataLayer;

public interface InterAccountProcess {
    void addMoney(int depositAmount,int id);
    void getWithdraw(int withdrawAmount,int id);
    long getAccountBalanceInJdbc(int id);
}