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
	public String showCreateForm() {
//		model.addAttribute("post", new Post());
		return "posts/create";
	}

	@PostMapping("/posts/create")
	public String create(@RequestParam(name = "title") String title,
						 @RequestParam(name = "body)") String body) {
			Post post = new Post(title, body);
			postDao.save(post);
			return "redirect:/index";
		}

	@PostMapping("delete/{id}")
	public String deletePost(@PathVariable Long id){
		postDao.deleteById(id);
	return "redirect:/index";
	}

	@PostMapping("/posts/edit")
	public String savePostedit(@RequestParam (name="postTitle") String postTitle,
							   @RequestParam (name="postBody") String postBody,
							   @RequestParam (name="postId") Long id) {
		return "redirect:/posts";
	}

	@PostMapping("/posts/edit/{id}")
	public String edit(@PathVariable long id, Model model) {
		Post editPost = postDao.getById(id);
		model.addAttribute("postToEDit", editPost);
		return "posts/edit";
	}





}
