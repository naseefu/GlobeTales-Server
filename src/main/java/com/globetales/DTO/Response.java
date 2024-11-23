package com.globetales.DTO;

import java.util.List;

public class Response {

	private int statusCode;
	
	private String message;
	
	private String token;
	
	private UserDTO userDTO;
	
	private List<Blogger> blogger;
	
	private Blogger blogger2;
	
	private Long totalNumOfBlogs;
	
	private List<Generation> generations;
	
	private String generatedContent;
	
	public String getGeneratedContent() {
		return generatedContent;
	}

	public void setGeneratedContent(String generatedContent) {
		this.generatedContent = generatedContent;
	}

	public void setGenerations(List<Generation> generations) {
		this.generations = generations;
	}

	public List<Generation> getGenerations() {
        return generations;
    }

    public static class Generation {
        private String text;

        public String getText() {
            return text;
        }
    }

	public Long getTotalNumOfBlogs() {
		return totalNumOfBlogs;
	}

	public void setTotalNumOfBlogs(Long totalNumOfBlogs) {
		this.totalNumOfBlogs = totalNumOfBlogs;
	}

	public Blogger getBlogger2() {
		return blogger2;
	}

	public void setBlogger2(Blogger blogger2) {
		this.blogger2 = blogger2;
	}

	public List<Blogger> getBlogger() {
		return blogger;
	}

	public void setBlogger(List<Blogger> blogger) {
		this.blogger = blogger;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	
	
}
