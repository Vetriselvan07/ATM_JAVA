package UiLayer;

import Validator.CreationValidator;
import Validator.OnlyInt;
import Validator.Validator;

import java.util.Scanner;
public class EnterRegisterDetails {

    Validator creationValidatorObj =new CreationValidator();


    public String enterName()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter ur name in only upper case without any special characters except space");
        String name= sc.nextLine();
        boolean isValidName=creationValidatorObj.checkValidName(name);
        if(isValidName) {
            return name;
        }
        else
        {
            System.out.println("Please enter Valid name");
            return enterName();
        }
    }

    public int enterAge()
    {
        OnlyInt onlyIntObj=new OnlyInt();
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter ur age");
        System.out.println("your age is must be higher than 18");

        int age= onlyIntObj.onlyInt();
        boolean isValidAge=creationValidatorObj.checkValidAge(age);
        if(isValidAge) {
            return age;
        }
        else {
            System.out.println("Please enter valid Age");
            return enterAge();
        }
    }

    public String selectGender()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Select Your Gender");
        System.out.println("Male--------->1");
        System.out.println("Female------>2");
        System.out.println("Prefer not to say-->3");
        OnlyInt onlyIntObj=new OnlyInt();
        int gender= onlyIntObj.onlyInt();
        boolean isValidGender=creationValidatorObj.checkValidGender(gender);
        if(isValidGender)
        {
            if(gender==1)
                return "Male";
            else if(gender==2)
                return "Female";
            else if(gender==3)
                return "Prefer not to say";
        }
        else {
            System.out.println("Please select valid GENDER");
            return selectGender();
        }
        return null;
    }
    public String enterPhoneNumber()
    {
        System.out.println("Please enter ur phone number must be 10 digits");
        Scanner scan=new Scanner(System.in);
        String phoneNumber= scan.nextLine();
        boolean isValidPhNo=creationValidatorObj.checkValidPhoneNumber(phoneNumber);
        if(isValidPhNo) {
            return phoneNumber;
        }
        else
        {
            System.out.println("Please enter valid Phone number");
            return enterPhoneNumber();
        }
    }

    public String enterPassword()
    {
        System.out.println("Please enter ur password");
        Scanner sc=new Scanner(System.in);
        String pass= sc.nextLine();
        System.out.println("Please reenter the password");
        String reEnterPass= sc.nextLine();
        boolean isValidPass=creationValidatorObj.checkValidPassword(pass,reEnterPass);
        if(isValidPass) {
            return pass;
        }
        else
        {
            System.out.println("The passwords are Not Same");
            return enterPassword();
        }

    }
    public void ifPhoneNumberAlreadyInRegisteredList()
    {
        System.out.println("This phone number is already Registered with our ATM");
    }

}
