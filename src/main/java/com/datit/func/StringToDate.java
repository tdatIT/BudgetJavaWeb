package com.datit.func;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
    public static Date convertStringToDate(String str_date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try{
            date = formatter.parse(str_date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }
}
