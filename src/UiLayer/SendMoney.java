package UiLayer;

import MiddleLayer.SendMoneyByPhAndAccNo;
import Validator.OnlyInt;

public class SendMoney {
    public void sendMoney(int userId)
    {
        SendMoneyByPhAndAccNo sendMoneyByPhAndAccNoObj=new SendMoneyByPhAndAccNo();
        int userInput=1;
        while(userInput==1||userInput==2) {
            System.out.println("----------------------------------------");
            System.out.println("||     using phone Number------>1     ||");
            System.out.println("||     using Account Number---->2     ||");
            System.out.println("||     Exit-------------------->3     ||");
            System.out.println("----------------------------------------");


            userInput= OnlyInt.onlyInt();
            if(userInput==1)
            {
                sendMoneyByPhAndAccNoObj.sendMoneyByPhNo(userId);
            }
            else if(userInput==2)
            {
                sendMoneyByPhAndAccNoObj.sendMoneyByAccNo(userId);
            }

        }
        if(!(userInput==1||userInput==2||userInput==3))
        {
            System.out.println("Please enter valid input");
            sendMoney(userId);
        }
    }

}
