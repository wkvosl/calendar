package com.practice.data;

import java.util.Calendar;

public class test1111 {

	public static void main(String[] args) {
		
		
		Calendar cal1 = Calendar.getInstance();
		
		cal1.set(2022, 9,1);
		
		int firstDay = cal1.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal1.getActualMaximum(Calendar.DATE);
		
		System.out.println(firstDay+"\n");
		System.out.println(lastDay+"\n");
		
		for (int i = 1; i < firstDay; i++) {
			System.out.print("\t");
		}
		
		for (int i = 1; i < lastDay+1; i++) {
			System.out.print(i+"\t");
			if(firstDay % 7 == 0) {
				System.out.println("\n");
			}
			firstDay++;
		}
		
	}
	
}
