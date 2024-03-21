package Main;

public class MoneySendByAccNo {
    private String fromAccNumber;
    private String toAccNumber;
    private String transactionDate;
    private long amountSent;

    public MoneySendByAccNo(String fromAccNumber, String toAccNumber, String transactionDate, long amountSent) {
        this.fromAccNumber = fromAccNumber;
        this.toAccNumber = toAccNumber;
        this.transactionDate = transactionDate;
        this.amountSent = amountSent;
    }

    public String getFromAccNumber() {
        return fromAccNumber;
    }

    public String getToAccNumber() {
        return toAccNumber;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public long getAmountSent() {
        return amountSent;
    }
}
