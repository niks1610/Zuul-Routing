package com.craterzone.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craterzone.demo.dao.AddressDao;
import com.craterzone.demo.dao.PostDao;
import com.craterzone.demo.mapper.PostMapper;
import com.craterzone.demo.model.Post;
import com.craterzone.demo.repository.*;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepo;
	
	public Optional<Post> savePost(Post post)
	{
		Optional<PostDao> postDb=postRepo.findById(post.getId());
		if(postDb.isPresent()){
			return null;
		}
		
		PostDao postDao = PostMapper.PostToPostDao(post);
		AddressDao addressDao = PostMapper.addressToAddressDao(post.getAddress());
		addressDao.setPost(postDao);
		postDao = postRepo.save(postDao);
		return Optional.of(post);
		
	}
	
	public Optional<Post> getPostById(int id){
		Optional<PostDao> postDb = postRepo.findById(id);
		if(postDb.isPresent()) {
			return Optional.of(PostMapper.PostDaoToPost(postDb.get()));
		}
		return null;
	}
	
}
