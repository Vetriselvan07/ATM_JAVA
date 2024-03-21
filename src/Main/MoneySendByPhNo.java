package Main;

public class MoneySendByPhNo {
    private String fromPhoneNumber;
    private String toPhoneNumber;
    private String transactionDate;
    private long amountSent;

    public MoneySendByPhNo(String fromPhoneNumber, String toPhoneNumber, String transactionDate, long amountSent) {
        this.fromPhoneNumber = fromPhoneNumber;
        this.toPhoneNumber = toPhoneNumber;
        this.transactionDate = transactionDate;
        this.amountSent = amountSent;
    }

    public String getFromPhoneNumber() {
        return fromPhoneNumber;
    }

    public String getToPhoneNumber() {
        return toPhoneNumber;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public long getAmountSent() {
        return amountSent;
    }
}
