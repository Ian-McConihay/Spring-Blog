package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
	public class PostController {
	@GetMapping("/posts")
	@ResponseBody
	public String postIndex(@PathVariable String index){
		return "posts";
	}


	@GetMapping("/posts/{id}")
	@ResponseBody
	public String viewPostById(@PathVariable String id){
		return "";
	}
	@GetMapping("/posts/create")
	@ResponseBody
	public String viewFormNewPost(@PathVariable String name){
		return "create";
	}

	@PostMapping("/posts/create")
	@ResponseBody
	public String createPost(@PathVariable String name){
		return "";
	}
}
