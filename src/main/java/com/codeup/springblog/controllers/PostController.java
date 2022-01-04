package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
	public class PostController {
	private final PostRepository postDao;

	public PostController(PostRepository postDao){
		this.postDao = postDao;
	}


	@GetMapping("posts/index")
	public String postIndex( Model model){
		model.addAttribute("posts", postDao.findAll());
		return "posts/index";
	}


//	@GetMapping("/posts/index")
//	public String viewPostById(Model model){
//		model.addAttribute("posts", postDao);
//		return "posts/index";
//	}


	@GetMapping("/posts/create")
	public String showCreateForm(Model model) {
		model.addAttribute("post", new Post());
		return "posts/create";
	}

	@PostMapping("/posts/create")
	public String create(@RequestParam(name = "title") String title,
						 @RequestParam(name = "body)") String body) {
			Post post = new Post();
			post.setTitle(title);
			post.setBody(body);
			return "posts/create";
		}

	@PostMapping("delete/{id}")
	public String deletePost(@PathVariable Long id){
		postDao.deleteById(id);
	return "redirect:/index";
	}
}
