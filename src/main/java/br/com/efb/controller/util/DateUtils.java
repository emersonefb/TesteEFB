package br.com.efb.controller.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static Date getDataInicial(Date data) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(data);  
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        return cal.getTime();  
    }
	
	public static Date getDataFinal(Date data) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(data);  
        cal.set(Calendar.HOUR_OF_DAY, 23);  
        cal.set(Calendar.MINUTE, 59);  
        cal.set(Calendar.SECOND, 59);  
        return cal.getTime();  
    }

	public String getStringFromDate(Date data, String pattern){
		Calendar instance = Calendar.getInstance();
		instance.setTime(data);
		return this.getStringFromCalendar(instance, pattern);
	}

	public String getStringFromCalendar(Calendar data, String pattern){
		if (pattern == null || "".equals(pattern)){
			pattern = "dd/MM/yyyy HH:mm:ss";
		}
		DateFormat formatador = new SimpleDateFormat(pattern);
		String format = formatador.format(data.getTime());
		return format;
	}
	
	public Calendar getCalendarFromString(String data, String pattern) throws ParseException{
		if (pattern == null || "".equals(pattern)){
			pattern = "dd/MM/yyyy HH:mm:ss";
		}
		DateFormat formatador = new SimpleDateFormat(pattern);
		Date parse = formatador.parse(data);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(parse.getTime());
		return calendar;
	}

}
