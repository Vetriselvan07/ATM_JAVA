package Validator;

import java.util.Scanner;

public class OnlyInt {
    public static int onlyInt()
    {
        Scanner sc=new Scanner(System.in);
        int input=1;
        try
        {
            input=sc.nextInt();
        }
        catch (Exception e)
        {
            System.out.println("Please Enter Valid Input");
            return  onlyInt();
        }
        return input;

    }
    public static int onlyIntBelowFiftyTh()
    {
        Scanner sc=new Scanner(System.in);
        int input=1;
        try
        {
            input=sc.nextInt();
        }
        catch (Exception e)
        {
            System.out.println("Please Enter Valid Input");
            return  onlyIntBelowFiftyTh();
        }
        if(input<=50000) {
            return input;
        }
        else {
            System.out.println("Please enter below Or Equal to 50000");
            return onlyIntBelowFiftyTh();
        }
    }
}
