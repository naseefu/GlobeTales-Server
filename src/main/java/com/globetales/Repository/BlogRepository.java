package com.globetales.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.globetales.entity.BlogEntity;
import com.globetales.entity.CommentEntity;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long>{
	
	
}
