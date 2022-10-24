package com.practice.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.data.calendar.Cal;

@Controller
public class CalController {

	@Autowired
	Cal cal;

	@RequestMapping("/cal" )
	public String cal(@RequestParam(value = "year" , defaultValue = "0") int year,
					  @RequestParam(value = "month" , defaultValue = "0") int month,
					  Model model
					  ) throws Exception {
		
		int startDayofWeek = cal.getStartDayofWeek(year, month);
		model.addAttribute("startDayofWeek", startDayofWeek);
		
		int lastDay = cal.getLastDay(year, month);
		model.addAttribute("lastDay", lastDay);

		return "/cal";
	}
	

	
	
}
