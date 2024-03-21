package Main;

public class User {
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;
    private String password;
    private long accountNo;
    private long accountBalance;

    public User(String name, int age, String gender, String phoneNumber, String password, long accountNo, long accountBalance) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.accountNo = accountNo;
        this.accountBalance=accountBalance;
    }

    public long getAccountBalance() {
        return accountBalance;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public long getAccountNo() {
        return accountNo;
    }
}
