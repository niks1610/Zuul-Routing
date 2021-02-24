package com.craterzone.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.craterzone.demo.dao.AddressDao;
import com.craterzone.demo.dao.PostDao;
import com.craterzone.demo.model.Address;
import com.craterzone.demo.model.Post;


public class PostMapper {
	
	
	public static Post PostDaoToPost(PostDao postDao){
		Post post = new Post();
		BeanUtils.copyProperties(postDao, post);
		post.setAddress(PostMapper.addressDaoToAddress(postDao.getAddress()));
		return post;
	}
	
	public static PostDao PostToPostDao(Post post){
		PostDao postDao = new PostDao();
		BeanUtils.copyProperties(post, postDao);
		postDao.setAddress(PostMapper.addressToAddressDao(post.getAddress()));
		postDao.getAddress().setPost(postDao);
		return postDao;
	}
	
	public static List<Post> UserDaoListToUserList(List<PostDao> list){
		return list.stream().map(x -> PostDaoToPost(x)).collect(Collectors.toList());
	}
	
	public static AddressDao addressToAddressDao(Address address){
		AddressDao addressDao = new AddressDao();
		BeanUtils.copyProperties(address, addressDao);
		return addressDao;
	}
	
	public static Address addressDaoToAddress(AddressDao addressDao){
		Address address = new Address();
		BeanUtils.copyProperties(addressDao, address);
		return address;
	}

}
