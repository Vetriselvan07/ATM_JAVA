package MiddleLayer;

import DataLayer.*;
import Main.MoneySendByAccNo;
import Main.MoneySendByPhNo;
import UiLayer.LoginController;
import Validator.OnlyInt;

public class SendMoneyByPhAndAccNo {
    public void sendMoneyByPhNo(int userId)
    {
        int res=0;
        int amount = 0;
        System.out.println("please enter phone number to send ");
        String toPhoneNumber;
        //Get Ten digit Phone Number from login Controller;
        LoginController loginControllerObj=new LoginController();
        toPhoneNumber =loginControllerObj.enterPhoneNumber();



        if(IsPhNoRegistered.isPhNoRegistered(toPhoneNumber)) {
            AccountHolderName accountHolderNameObj =new AccountHolderName();
            System.out.println();
            System.out.println("ACCOUNT HOLDER NAME : "+ accountHolderNameObj.getAccHolderNameByPhNo(toPhoneNumber));
            System.out.println();
            System.out.println("How much money want to send below 50000");
            amount = OnlyInt.onlyIntBelowFiftyTh();
            SendMoneyDL sendMoneyDLObj = new SendMoneyDL();
            res=sendMoneyDLObj.sendMoney(userId, amount,"Phone Number : '"+ toPhoneNumber +"'");
        }
        else {
            System.out.println("This phone Number have no account");
        }
        if(res==1)
        {
            String fromPhoneNumber= PhNoByID.getPhNoById(userId);
            String todayDate= GetTodayDate.getTodayDate();

            MoneySendByPhNo moneySendByPhNoObj=new MoneySendByPhNo(fromPhoneNumber,toPhoneNumber,todayDate,amount);

            InsertSendByPhNoTable insertSendByPhNoTableObj=new InsertSendByPhNoTable();
            insertSendByPhNoTableObj.insertSendByPhNoTable(moneySendByPhNoObj);

            CreditToSendAccount creditToSendAccount=new CreditToSendAccount();
            creditToSendAccount.creditToSendAccountByPhNo(toPhoneNumber,amount,userId);

        }
    }
    public void sendMoneyByAccNo(int userId)
    {
        int res=0;
        System.out.println("Please enter Account number 14 Digits");
        EnterAccNo enterAccNo=new EnterAccNo();

        String accountNumber=enterAccNo.enterAccNo();
        int amount = 0;


        IsAccNoReg isAccNoRegObj=new IsAccNoReg();

        if(isAccNoRegObj.isAccNoReg(accountNumber)) {

            AccountHolderName accountHolderNameObj =new AccountHolderName();
            System.out.println("ACCOUNT HOLDER NAME : "+ accountHolderNameObj.getAccHolderNameByAccNo(accountNumber));
            System.out.println();
            System.out.println("How much money want to send below 50000");
            amount=OnlyInt.onlyIntBelowFiftyTh();
            SendMoneyDL sendMoneyDLObj = new SendMoneyDL();
            res=sendMoneyDLObj.sendMoney(userId, amount,"Account NUmber : '"+accountNumber+"'");
        }
        else
        {
            System.out.println("This account Number is Not Valid Check again");
        }
        if(res==1)
        {
            String fromAccountNumber= AccNoById.getAccNoById(userId);
            String todayDate= GetTodayDate.getTodayDate();

            MoneySendByAccNo moneySendByAccNo=new MoneySendByAccNo(fromAccountNumber,accountNumber,todayDate,amount);

            InsertIntoSendByAccNoTable insertIntoSendByAccNoTableObj=new InsertIntoSendByAccNoTable();
            insertIntoSendByAccNoTableObj.insertIntoSendByAccNoTable(moneySendByAccNo);

            CreditToSendAccount creditToSendAccount=new CreditToSendAccount();
            creditToSendAccount.creditToSendAccountByAccNo(accountNumber,amount,userId);

        }

    }
}
