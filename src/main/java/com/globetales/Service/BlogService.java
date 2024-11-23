package com.globetales.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.globetales.DTO.BlogE;
import com.globetales.DTO.Blogger;
import com.globetales.DTO.Response;
import com.globetales.Exception.OurException;
import com.globetales.Repository.BlogRepository;
import com.globetales.Repository.CommentRepository;
import com.globetales.Repository.UserRepository;
import com.globetales.Utils.Utils;
import com.globetales.entity.BlogEntity;
import com.globetales.entity.CommentEntity;
import com.globetales.entity.Gallery;
import com.globetales.entity.UserEntity;

@Service
public class BlogService {

		
	@Autowired
	private CloudinaryService cloudinaryService;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	
	public Response addBlog(BlogE blogEntity, Long id) {
		
		Response response = new Response();
		
		try {
			
			if(id==null) {
				response.setStatusCode(400);
				response.setMessage("Login First");
				return response;
			}
			
			else {
				
				if(blogEntity.getTitle().isBlank()||blogEntity.getContent().isBlank()||blogEntity.getMainImage().isEmpty()) {
					
					response.setStatusCode(400);
					response.setMessage("Fill all the fields");
					return response;
					
				}
				
				if(blogEntity.getCaptions().size()!=blogEntity.getGalleries().size()) {
					
					response.setStatusCode(400);
					response.setMessage("Each Image must have caption");
					return response;
					
				}
				
				BlogEntity b = new BlogEntity();
				
				b.setTitle(blogEntity.getTitle());
				
				UserEntity userEntity = userRepository.findById(id).orElseThrow(()->new OurException("No User Found"));
				
				String fileUrl = cloudinaryService.uploadFile(blogEntity.getMainImage());
				
				b.setMainImage(fileUrl);
				b.setContent(blogEntity.getContent());
				b.setBestTime(blogEntity.getBestTime());
				b.setDuration(blogEntity.getDuration());
				b.setMustSee(blogEntity.getMustSee());
				b.setUserEntity(userEntity);
				
				List<Gallery> g = new ArrayList<Gallery>();
				
				for(int i=0;i<blogEntity.getGalleries().size();i++) {
					
					Gallery gal = new Gallery();
					
					String furl = cloudinaryService.uploadFile(blogEntity.getGalleries().get(i));
					String cap = blogEntity.getCaptions().get(i);
					
					gal.setUrl(furl);
					gal.setCaption(cap);
					
					g.add(gal);
					
				}
				
				b.setGalleries(g);
				
				LocalDate d = LocalDate.now();
				
				b.setDate(d);
				
				blogRepository.save(b);
				
				response.setStatusCode(200);
				response.setMessage("Success");
				return response;
				
			}
			
			
		}
		catch(OurException e) {
			
			response.setStatusCode(400);
			response.setMessage("Failed to add blog");
			return response;
			
		}
		catch(Exception e) {
			
			response.setStatusCode(500);
			response.setMessage("Failed to add blog");
			return response;
			
		}
		
	}
	

	public Response getAllBlogs(Pageable pageable) {
		
		Response response = new Response();
		
		try {
		
			Page<BlogEntity> blogEntities = blogRepository.findAll(pageable);
			
			Long totalNumOfBlogs = blogRepository.count();
			
			response.setTotalNumOfBlogs(totalNumOfBlogs);
			
			List<Blogger> bloggers = Utils.mapBlogPageToBlogger(blogEntities);
			
			response.setBlogger(bloggers);
			response.setStatusCode(200);
			response.setMessage("Success");
			return response;
			
		}
		catch(OurException e) {
			
			response.setStatusCode(400);
			response.setMessage("Failed to get blog");
			return response;
			
		}
		catch(Exception e) {
			
			response.setStatusCode(500);
			response.setMessage("Failed to get blog");
			return response;
			
		}
	}


	public Response getBlogById(Long id) {
		
		Response response = new Response();
		
		try {
			
			if(id==null) {
				response.setStatusCode(400);
				response.setMessage("Failed to get block");
				return response;
			}
			
			BlogEntity blogEntity = blogRepository.findById(id).orElseThrow(()->new OurException("No Such Blog Found"));
			
			Blogger blog = Utils.mapBlogEntityTOBlogger(blogEntity);
			
			for(CommentEntity c:blog.getComments()) {
				
				c.setBlogEntity(null);
				
			}
			
			String[] m = blog.getDate().toString().split("-");
			
			LocalDate date = LocalDate.of(Integer.parseInt(m[0]), Integer.parseInt(m[1]), Integer.parseInt(m[2]));
			
			String month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
			String day = m[2];
			int year = date.getYear();
			
			System.out.println(month+" "+day+" "+year);
			
			blog.setDate1(month+" "+day+", "+year);
			
			response.setBlogger2(blog);
			
			response.setStatusCode(200);
			response.setMessage("Success");
			
			return response;
			
			
		}
		catch(OurException e) {
			
			response.setStatusCode(400);
			response.setMessage("Failed to get blog");
			return response;
			
		}
		catch(Exception e) {
			
			response.setStatusCode(500);
			response.setMessage("Failed to get blog");
			return response;
			
		}
	}


	public Response addComment(Long id, CommentEntity commentEntity) {
		
		Response response = new Response();
		
		try {
			
			if(commentEntity.getComment().isBlank()|| commentEntity.getName().isBlank()) {
				
				response.setStatusCode(400);
				response.setMessage("Fill all the fields");
				return response;
				
			}
			
			BlogEntity blogEntity = blogRepository.findById(id).orElseThrow(()->new OurException("No Blog Found"));
			
			commentEntity.setDate(LocalDate.now());
			commentEntity.setBlogEntity(blogEntity);
			
			commentRepository.save(commentEntity);
			
			response.setStatusCode(200);
			response.setMessage("Success");
			
			return response;
			
		}
		
		catch(OurException e) {
			
			response.setStatusCode(400);
			response.setMessage("Failed to get comment");
			return response;
			
		}
		catch(Exception e) {
			
			response.setStatusCode(500);
			response.setMessage("Failed to get comment");
			return response;
			
		}
		
		
	}

}
