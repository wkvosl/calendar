package com.practice.data.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.data.calendar.Cal;

@Controller
public class CalController {

	@Autowired
	Cal cal;
	
	@RequestMapping("/cal")
		public String cal() {
			return "/cal";
	}
	
	@PostMapping("/cal")
	public String cal(@RequestParam int year, 
					  @RequestParam int month,
					  Model model
					  ) throws Exception {
		
		
		int startDayofWeek = cal.getStartDayofWeek(year, month);
		model.addAttribute("startDayofWeek", startDayofWeek);
		
		int lastDay = cal.getLastDay(year, month);
		model.addAttribute("lastDay", lastDay);

		return "/cal";
	}
	
//	@GetMapping("/cal")
//	public String cal(@RequestParam int day) {
//		return "cal";
//	}
	
	
	
	
}
