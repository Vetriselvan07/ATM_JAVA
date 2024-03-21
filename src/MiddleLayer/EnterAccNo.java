package MiddleLayer;

import java.util.Scanner;

import static java.lang.String.valueOf;

public class EnterAccNo {// while Sending money using Account number check the number have 14 digits;
    public String enterAccNo()
    {
        Scanner sc=new Scanner(System.in);
        String accNo;
        System.out.println("Please enter Account NUmber without space");
        accNo =sc.nextLine();
        char arr[]= accNo.toCharArray();
        int numberCount=1;
        try{
            numberCount=0;
            for (int i=0;i<arr.length;i++) {
                int i1 = Integer.parseInt(valueOf(arr[i]));
                if (i1>=0 && i1<=9) {
                    numberCount++;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Please enter valid format");
            return  enterAccNo();

        }
        if((accNo.length()==14)&&numberCount==14) {
            return accNo;
        }
        else
        {
            System.out.println("Please enter valid Account number");
            return enterAccNo();
        }


    }
}
