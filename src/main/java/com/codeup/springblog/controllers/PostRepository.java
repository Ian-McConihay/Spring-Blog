package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
	Object findPostById(long id);
//	 void deleteById(Long id);

//	Object findById();
}
