package com.globetales.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.globetales.DTO.Blogger;
import com.globetales.DTO.UserDTO;
import com.globetales.entity.BlogEntity;
import com.globetales.entity.UserEntity;

public class Utils {

public static UserDTO mapUserEntityToUserDTO(UserEntity user) {
		
		UserDTO u = new UserDTO();
		
		if(user==null) {
			return null;
		}
		else {
			
			u.setId(user.getId());
			u.setFirstname(user.getFirstname());
			u.setLastname(user.getLastname());
			u.setEmail(user.getEmail());
			u.setPhonenumber(user.getPhonenumber());
			u.setDob(user.getDob());
			u.setAvatar(user.getAvatar());
			
			return u;
			
		}
	}

public static List<Blogger> mapBlogListToBlogger(List<BlogEntity> blogEntities) {
	
	List<Blogger> bloggers = new ArrayList<Blogger>();
	
	if(blogEntities==null) {
		return null;
	}
	
	else {
		
		for(BlogEntity b:blogEntities) {
			
			Blogger bb = new Blogger();
			bb.setId(b.getId());
			bb.setAuthor(b.getUserEntity().getFirstname());
			bb.setDate(b.getDate());
			bb.setDescription(b.getContent()); 
			bb.setImage(b.getMainImage());
			bb.setTitle(b.getTitle());
			
			bloggers.add(bb);
		}
		
		return bloggers;
		
	}
	
}

public static Blogger mapBlogEntityTOBlogger(BlogEntity blogEntity) {
	
	Blogger b = new Blogger();
	
	if(blogEntity==null) {
		return null;
	}
	else {
		
		b.setTitle(blogEntity.getTitle());
		b.setDate(blogEntity.getDate());
		b.setAuthor(blogEntity.getUserEntity().getFirstname());
		b.setImage(blogEntity.getMainImage());
		b.setDescription(blogEntity.getContent());
		b.setBestTime(blogEntity.getBestTime());
		b.setMustSee(blogEntity.getMustSee());
		b.setDuration(blogEntity.getDuration());
		b.setGallery(blogEntity.getGalleries());
		b.setComments(blogEntity.getCommentEntities());
		
		return b;
		
	}
	
}

public static List<Blogger> mapBlogPageToBlogger(Page<BlogEntity> blogEntities) {
	
	List<Blogger> bloggers = new ArrayList<Blogger>();
	
	if(blogEntities==null) {
		
		return null;
		
	}
	
	for(BlogEntity b:blogEntities) {
		
		Blogger bb = new Blogger();
		bb.setId(b.getId());
		bb.setAuthor(b.getUserEntity().getFirstname());
		bb.setDate(b.getDate());
		bb.setDescription(b.getContent()); 
		bb.setImage(b.getMainImage());
		bb.setTitle(b.getTitle());
		
		bloggers.add(bb);
		
	}
	
	return bloggers;
}
	

}
