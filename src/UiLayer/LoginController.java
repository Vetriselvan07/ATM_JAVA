package UiLayer;

import MiddleLayer.CallAtmProcesses;
import MiddleLayer.GetAccountByPhNoPass;
import Validator.CreationValidator;

import java.util.Scanner;

public class LoginController {
    public void checkAccount(){
        Scanner sc=new Scanner(System.in);
        String phoneNumber,password;
        System.out.println("Please enter Registered Phone Number");
        phoneNumber =enterPhoneNumber();
        System.out.println("Please enter your Password");
        password = sc.nextLine();
        loginPage(phoneNumber,password);
    }
    public String enterPhoneNumber()
    {
        Scanner sc=new Scanner(System.in);
        String phoneNumber =sc.nextLine();
        CreationValidator creationValidatorObj=new CreationValidator();
        int res=creationValidatorObj.isPhNoHaveTenDigit(phoneNumber);
        if(res==1)
            return phoneNumber;
        else
        {
            System.out.println("Please enter correct format PhoneNumber");
            return enterPhoneNumber();
        }
    }
    public void loginPage( String phoneNumber, String password) {
        Dashboard dashboardObj =new Dashboard();
        GetAccountByPhNoPass getAccountByPhNoPassObj=new GetAccountByPhNoPass();
        boolean isAccountThere =getAccountByPhNoPassObj.getAccountByPhNoPass(phoneNumber,password);
        if (isAccountThere ==false) {
            System.out.println("Sorry something went wrong,try again");
        }
        else
        {
            CallAtmProcesses callAtmProcessesObj =new CallAtmProcesses();
            int id= callAtmProcessesObj.getId(phoneNumber,password);

            int UserInputForAccountProcess=1;
            while(UserInputForAccountProcess!=10)
            {
                UserInputForAccountProcess= dashboardObj.enterProcess();
                if(UserInputForAccountProcess<10)
                {
                    switch (UserInputForAccountProcess)
                    {
                        case 1:
                            dashboardObj.enterDepositAmount(id);
                            break;
                        case 2:
                            dashboardObj.accountBalance(id);
                            break;
                        case 3:
                            dashboardObj.enterWithdrawAmount(id);
                            break;
                        case 4:
                            dashboardObj.enterChangePassword(id);
                            break;
                        case 5:
                            SendMoney sendMoneyObj=new SendMoney();
                            sendMoneyObj.sendMoney(id);
                            break;
                        case 6:
                            ApplyCreditCard applyCreditCardObj=new ApplyCreditCard();
                            applyCreditCardObj.applyCreditCard(id,phoneNumber);
                            break;
                        case 7:
                            GetTransactionDetails.getTransactionDetails(id);
                            break;
                        case 8:
                            GetCreditCardDetails.getCreditCardDetails(id);
                            break;
                        case 9:
                            SeeProfile seeProfileObj=new SeeProfile();
                            seeProfileObj.seeProfile(id);
                            break;

                    }
                }
            }
        }
    }
}
