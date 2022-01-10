package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codeup.springblog.services.EmailService;

@Controller
	public class PostController {
	private final UserRepository userDao;
	private final PostRepository postDao;
	private final EmailService emailService;

	public PostController(UserRepository userDao, PostRepository postDao, EmailService emailService){
		this.userDao = userDao;
		this.postDao = postDao;

		this.emailService = emailService;
	}


	@GetMapping("/posts")
	public String postIndex( Model model){
		model.addAttribute("posts", postDao.findAll());
		return "posts/index";
	}
	@GetMapping("/posts/{id}")
	public String individualPost(@PathVariable Long id, Model model){
		long showById = id;
		model.addAttribute("posts", postDao.findAll());
		userDao.findById(showById);
		return "posts/show";
	}



//	Create Post
	@GetMapping("/posts/create")
	public String showCreateForm(Model model) {
		model.addAttribute("post", new Post());
		return "posts/create";
	}
	@PostMapping("/posts/create")
	public String create(@ModelAttribute Post post) {
			post.setUser(userDao.getById(1L));
			String emailSubject = post.getUser().getUsername() + ", Your post has been created";
			emailService.prepareAndSend(post, emailSubject, "Congratulations, your post is available for viewing");
			postDao.save(post);
			return "redirect:/posts";
		}



//	Delete Post
	@PostMapping("/posts/delete/{id}")
	public String deletePost(@PathVariable Long id){
		long deletePostId = id;
		postDao.deleteById(deletePostId);
	return "redirect:/posts";
	}



//	Edit Post
	@GetMapping("/posts/edit/{id}")
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
