package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//View all
	public class PostController {
	@GetMapping("/posts")
	@ResponseBody
	public String postIndex(@PathVariable String index){
		return "posts";
	}

//View one
//	@GetMapping("/posts/{id}")
//	@ResponseBody
//	public Post viewPostById(@PathVariable Post id){
//		Post id = new Post("Hello", "This is a post.");
//		return id;
//	}

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
