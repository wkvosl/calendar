package com.practice.data.calendar;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service
public class Cal {
	
	
	public  int getStartDayofWeek(int year, int month) {
		
		Calendar cal = Calendar.getInstance();

			cal.set(year, month-1,1);
		return  cal.get(Calendar.DAY_OF_WEEK);
	}

	public  int getLastDay(int year, int month) {
		
		Calendar cal = Calendar.getInstance();

			cal.set(year, month-1,1);
		return cal.getActualMaximum(Calendar.DATE);
	}

}