package Validator;

public interface Validator{
     boolean checkValidName(String name);
     boolean checkValidAge(int age);
     boolean checkValidPhoneNumber(String phoneNumber);
     boolean checkValidGender(int gender);
     boolean checkValidPassword(String pass, String reEnterPass);
}
