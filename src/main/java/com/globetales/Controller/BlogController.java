package com.globetales.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globetales.DTO.BlogE;
import com.globetales.DTO.Response;
import com.globetales.Service.BlogService;
import com.globetales.entity.CommentEntity;

@RestController
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@PostMapping("/add/{id}")
	public ResponseEntity<Response> addBlog(@ModelAttribute BlogE blogEntity,@PathVariable Long id){
		
		Response response = blogService.addBlog(blogEntity,id);
		return ResponseEntity.status(response.getStatusCode()).body(response);
		
	}
	
	@GetMapping("/all/{num}/{size}")
	public ResponseEntity<Response> getAllBlogs(@PathVariable int num,@PathVariable int size){
		
		Pageable pageable = PageRequest.of(num-1<0?0:num-1, size,Sort.by(Sort.Direction.DESC, "id"));
		Response response = blogService.getAllBlogs(pageable);
		return ResponseEntity.status(response.getStatusCode()).body(response);
		
	}
	@GetMapping("/each/{id}")
	public ResponseEntity<Response> getBlogById(@PathVariable Long id){
		
		Response response = blogService.getBlogById(id);
		return ResponseEntity.status(response.getStatusCode()).body(response);
		
	}
	
	@PostMapping("/comment/{id}")
	public ResponseEntity<Response> addComment(@PathVariable Long id,@RequestBody CommentEntity commentEntity){
		
		Response response = blogService.addComment(id,commentEntity);
		return ResponseEntity.status(response.getStatusCode()).body(response);
		
	}
	
}
