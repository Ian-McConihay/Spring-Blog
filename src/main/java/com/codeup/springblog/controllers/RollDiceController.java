package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {

	@GetMapping("/rolldice")
	public String showDice(){
		return "rolldice";
	}



	@GetMapping( "/rolldice/{number}")
	@ResponseBody
	public String guessDice(@PathVariable String number, Model model) {
		int rannumber = (int) (Math.random()*6+1);
		String parse = Integer.toString(rannumber);
		model.addAttribute("number", number);
		if(parse.equals(number)) {
			return "<h1> Was correct! </h1>";
		}
		return "<h1> Wrong! Go back and re-roll </h1>";
	}

}

