package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	@GetMapping("/home")
	public String welcome() {
		return "home";
//		if the return does not match the html then you will get a white
//		error
	}
}