package com.practice.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/* 주소 변수 읽어보셈
--------------------------------------------------
    @GetMapping("/{Id}/{name}")
    public String user(@PathVariable Stirng id, 
        			   @PathVariable String name, 
        			   Model model) {
	}
	-> http://localhost:8080/a/hong
--------------------------------------------------
	@GetMapping("/")
	public String user(@RequestParam Stirng id, 
	                   @RequestParam Stirng name, 
	                   Model model) {
	}
	-> http://localhost:8080?id=a&name=hong
--------------------------------------------------
*/

@Controller
public class MainController {

	@RequestMapping("/home")
	public String home() {
		return "/home";
	}
	
}
