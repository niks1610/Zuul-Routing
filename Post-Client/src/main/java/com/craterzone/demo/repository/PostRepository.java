package com.craterzone.demo.repository;



import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import com.craterzone.demo.dao.AddressDao;
import com.craterzone.demo.dao.PostDao;

public interface PostRepository extends JpaRepository<PostDao,Integer>{
		
		

}
