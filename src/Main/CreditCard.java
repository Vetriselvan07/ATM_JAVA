package Main;

public class CreditCard {
    private int userId;
    private String phoneNumber;
    private String aadharNumber;
    private long creditCardNumber;
    private String expiryDate;
    private int cvv;

    public CreditCard(int userId,String phoneNumber, String aadharNumber, long creditCardNumber, String expiryDate, int cvv) {
        this.userId=userId;
        this.phoneNumber = phoneNumber;
        this.aadharNumber = aadharNumber;
        this.creditCardNumber = creditCardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public int getUserId() {
        return userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public int getCvv() {
        return cvv;
    }
}
