package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index(){
		return "test";
	}
}
