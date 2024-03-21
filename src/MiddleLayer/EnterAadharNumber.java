package MiddleLayer;

import DataLayer.IsCCAndAadharNumberAlreadyExists;

import java.util.Scanner;

import static java.lang.String.valueOf;

public class EnterAadharNumber {//check the aadhar number have only digits and length=16;
    public String aadharNumber()
    {
        Scanner sc=new Scanner(System.in);
        String aadharNo;
        System.out.println("Please enter aadhar card number without space");
        aadharNo=sc.nextLine();
        char arr[]=aadharNo.toCharArray();
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
            return  aadharNumber();

        }
        if((aadharNo.length()==16)&&numberCount==16) {
            if(IsCCAndAadharNumberAlreadyExists.isAadharNumberAlreadyExists(aadharNo)==0) {
                return aadharNo;
            }
            else {
                System.out.println("This Aadhar Number alredy have a Credit Card");
                return  aadharNumber();
            }
        }
        else
        {
            System.out.println("Please enter valid aadhar number");
            return aadharNumber();
        }
    }
}
