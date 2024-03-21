package MiddleLayer;

import DataLayer.AtmProcesses;
import DataLayer.ChangePass;
import DataLayer.InterAccountProcess;
import DataLayer.UserIdByPhNo;
import UiLayer.Dashboard;
public class CallAtmProcesses {
    InterAccountProcess accountProcessObj =new AtmProcesses();
    AtmProcesses atmProcessesObj =new AtmProcesses();

    public  int getId(String phoneNumber,String password)
    {
        UserIdByPhNo userIdByPhNoObj =new UserIdByPhNo();

        return userIdByPhNoObj.getId(phoneNumber,password);
    }

    public void addMoney(int depositAmount, int idNumber)
    {
        accountProcessObj.addMoney(depositAmount,idNumber);

    }
    public void withdraw(int withdrawAmount,int idNumber)
    {
        Dashboard dashboardObj=new Dashboard();
        long accountBalance= accountProcessObj.getAccountBalanceInJdbc(idNumber);

        if(withdrawAmount>accountBalance) {
            dashboardObj.ifWithdrawGreaterBalance(accountBalance);
        }
        else {
            dashboardObj.ifWithdrawLesserBalance();
            accountProcessObj.getWithdraw(withdrawAmount,idNumber);
        }
    }
    public long accountBalance(int ID)
    {
        return accountProcessObj.getAccountBalanceInJdbc(ID);
    }
    public void changePass(String pass,int id)
    {
        ChangePass changePassObj=new ChangePass();
        changePassObj.changePassword(pass,id);
    }
}
