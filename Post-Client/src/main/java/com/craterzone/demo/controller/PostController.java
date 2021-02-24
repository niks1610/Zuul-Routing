package com.craterzone.demo.controller;

import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.craterzone.demo.model.Post;
import com.craterzone.demo.service.PostService;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);

	@PostMapping
	public ResponseEntity<Post> createPost(@Valid @RequestBody Post post){
		Optional<Post> post1 = postService.savePost(post);
		if(!Objects.isNull(post1)) {
			 logger.info("New Post Created.");
			 System.out.println("New Post Created");
			 return ResponseEntity.status(HttpStatus.CREATED).body(post);
		 }	
	
	return ResponseEntity.badRequest().build();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable(name = "id") int id){
		Optional<Post> post = postService.getPostById(id);//
		 if(post.isPresent())
		 {
			 return ResponseEntity.status(HttpStatus.OK).body(post.get());
		 }
             return ResponseEntity.badRequest().build();
	}
}
