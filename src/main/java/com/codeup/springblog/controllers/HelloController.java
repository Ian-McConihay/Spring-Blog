package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//defines that our class is a controller
@Controller
public class HelloController {
//	defines a method that should be invoked when a GET request is received for the specified URI
	@GetMapping("/hello")
//	 tells Spring that whatever is returned from this method should be the body of our response
	@ResponseBody
	public String hello(){
		return "Hello from Quasar! Happy Holidays!";
	}


	@GetMapping("/hello/{name}")
	@ResponseBody
	public String sayHello(@PathVariable String name){
		return "Hello there " + name + "!";
	}

	@RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
	@ResponseBody
	public String addOne(@PathVariable int number) {
		return number + " plus one is " + (number + 1) + "!";
	}
}
