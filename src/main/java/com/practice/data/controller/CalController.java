package com.practice.data.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.data.calendar.Cal;
import com.practice.data.dto.Cal_dto;
import com.practice.data.dto.Cal_dto_mapper;

@Controller
@RequestMapping("/cal")
public class CalController {

	@Autowired
	Cal cal;
	
	@Autowired
	Cal_dto_mapper cal_dto_mapper ;

	
	
	@RequestMapping("/cal")
	public String cal2(@RequestParam(value = "year" , defaultValue = "0") int year,
					  @RequestParam(value = "month" , defaultValue = "0") int month,
					  Model model
					  ) throws Exception {
		
		int startDayofWeek = cal.getStartDayofWeek(year, month);
		model.addAttribute("startDayofWeek", startDayofWeek);
		
		int lastDay = cal.getLastDay(year, month);
		model.addAttribute("lastDay", lastDay);
		
		return "/cal/cal";
	}
	
	@PostMapping("/cal_memo_insert")
	public String cal_memo_insert(
			@RequestParam(value = "memo_date") String memo_date,
			@RequestParam(value = "memo_title" , defaultValue = "0") String memo_title,
			@RequestParam(value = "memo_write" , defaultValue = "0") String memo_write) {
		
		cal_dto_mapper.insertMemo(memo_date, memo_title, memo_write);
		
		return "/cal/cal";
	}
	
	@GetMapping("/cal_memo")
	public String cal_memo_select(
			  @RequestParam(value = "year") String year,
			  @RequestParam(value = "month") String month,
			  @RequestParam(value = "day") String day,
								 Model model) {
		
		String memo_date = year + month + day;
		
		List<Cal_dto> cal_member = cal_dto_mapper.listMemo(memo_date);
		model.addAttribute("cal_member", cal_member);
		System.out.println("셀렉터: "+cal_member);
			
		return "/cal/cal_memo";
	}
	
	@PostMapping("/cal_memo_update")
	public String cal_memo_update(
			@RequestParam(value = "memo_date") String memo_date,
			@RequestParam(value = "memo_title" , defaultValue = "0") String memo_title,
			@RequestParam(value = "memo_write" , defaultValue = "0") String memo_write,
			@RequestParam(value = "memo_id") String memo_id,
			HttpServletRequest request) {

			String referer = request.getHeader("Referer");
		
			cal_dto_mapper.updateMemo(memo_date, memo_title, memo_write, memo_id);
		
		return "redirect:"+referer;
	}
	
	@GetMapping("/cal_memo_delete")
	public String cal_memo_delete(
			@RequestParam(value = "memo_id") String memo_id) {
		
			cal_dto_mapper.deleteMemo(memo_id);
		
		return "redirect:/cal/cal";
	}
	
}
