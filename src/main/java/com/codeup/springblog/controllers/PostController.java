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


	@GetMapping("/posts")
	public String postIndex( Model model){
		model.addAttribute("posts", postDao.findAll());
		return "posts/index";
	}


	@GetMapping("/posts/{id}")
	public String individualPost(@PathVariable int id){
		return "posts/show";
	}

////	Create Post
//	@GetMapping("/posts/create")
//	public String showCreateForm() {
////		model.addAttribute("post", new Post());
//		return "posts/create";
//	}
//
//	@PostMapping("/posts/create")
//	public String create(@RequestParam(name = "title") String title,
//						 @RequestParam(name = "body)") String body) {
//			Post post = new Post(title, body);
//			postDao.save(post);
//			return "redirect:/index";
//		}

//	Delete Post
	@PostMapping("/posts/delete/{id}")
	public String deletePost(@PathVariable Long id){
		long deletePostId = id;
		postDao.deleteById(deletePostId);
	return "redirect:/posts";
	}

//	Edit Post
	@PostMapping("/posts/edit/{id}")
	public String edit(@PathVariable long id, Model model) {
		Post editPost = postDao.getById(id);
		model.addAttribute("postToEdit", editPost);
		return "posts/edit";
	}

	@PostMapping("/posts/edit")
	public String savePostEdit(@RequestParam (name="postTitle") String postTitle,
							   @RequestParam (name="postBody") String postBody,
							   @RequestParam (name="postId") long id) {
		Post postToEdit = postDao.getById(id);
		postToEdit.setBody(postBody);
		postToEdit.setTitle(postTitle);
		postDao.save(postToEdit);
		return "redirect:/posts";
	}



}
