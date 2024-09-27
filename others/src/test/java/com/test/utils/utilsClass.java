package com.test.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class utilsClass {
	
	public String calDate() {
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		 LocalDateTime now = LocalDateTime.now();  
		 System.out.println(dtf.format(now)); 
		 return now.toString();
		 
	}
	
	private static final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    
    public ArrayList<String> calDatePlusListDays(int forYear, int forMonth, int forDay, int justDays) {
    	
    	String vcurrentDatePlusMonthNDay;
    	String vjustDays;
    	
    	ArrayList<String> dateList = new ArrayList<String> ();
        Date currentDate = new Date();
        //System.out.println(dateFormat.format(currentDate));
        dateList.add(dateFormat.format(currentDate));
        
        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        
        c.add(Calendar.YEAR, forYear);
        c.add(Calendar.MONTH, forMonth);
        c.add(Calendar.DATE, forDay); //same with c.add(Calendar.DAY_OF_MONTH, 1);
        
      
        // convert calendar to date
        Date currentDatePlusMonthNDay = c.getTime();
        //System.out.println(dateFormat.format(vcurrentDatePlusMonthNDay));
        
        vcurrentDatePlusMonthNDay = dateFormat.format(currentDatePlusMonthNDay);
        //System.out.println("value is " + value);
        
        dateList.add(vcurrentDatePlusMonthNDay);
        //System.out.println("dateList value is : " + dateList);
        
        Calendar d = Calendar.getInstance();
        d.setTime(currentDate);
        
        d.add(Calendar.DATE, justDays); 
        Date dateJustDays = d.getTime();
        vjustDays = dateFormat.format(dateJustDays);
        
        dateList.add(vjustDays);
        return dateList;

    }
    
    public String splitDates(String dateValue) {
    	String[] dayValue;
    	dayValue = dateValue.split("/");
    	return dayValue[1];
    }
	

}
