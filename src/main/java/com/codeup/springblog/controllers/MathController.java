package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

	@GetMapping({ "/add/{numberOne}/{numberTwo}"})
	@ResponseBody
	public String add(@PathVariable int numberOne, @PathVariable int numberTwo) {
		return (numberOne + " plus " + numberTwo) + " = " + (numberOne + numberTwo) + "!";
	}

	@RequestMapping(path = "/subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	@ResponseBody
	public String subtract(@PathVariable int numberOne, @PathVariable int numberTwo) {
		return (numberOne + " subtract " + numberTwo) + " = " +(numberOne - numberTwo) + "!";
	}

	@RequestMapping(path = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	@ResponseBody
	public String multiply(@PathVariable int numberOne, @PathVariable int numberTwo) {
		return (numberOne + " multiply " + numberTwo) + " = " +(numberOne * numberTwo) + "!";
	}

	@RequestMapping(path = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	@ResponseBody
	public String divide(@PathVariable int numberOne, @PathVariable int numberTwo) {
		return (numberOne + " divided by " + numberTwo) + " = " +(numberOne / numberTwo) + "!";
	}

}
