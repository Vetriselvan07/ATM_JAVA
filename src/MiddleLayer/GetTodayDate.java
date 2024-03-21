package MiddleLayer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTodayDate {//Get Today date as a String and format of yyyy-MM-dd;
    public static String getTodayDate()
    {
        Date date=new Date();
        SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd-hh-mm");
        String date1=d.format(date);
        return  date1;
    }
}
