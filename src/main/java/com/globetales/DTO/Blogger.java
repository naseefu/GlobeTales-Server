package com.globetales.DTO;

import java.time.LocalDate;
import java.util.List;

import com.globetales.entity.CommentEntity;
import com.globetales.entity.Gallery;

public class Blogger {

	private Long id;
	
	private String title;
	
	private String author;
	
	private LocalDate date;
	
	private String date1;
	
	private String description;
	
	private String image;
	
	private List<Gallery> gallery;
	
	private List<CommentEntity> comments;
	
	private String bestTime;
	
	private String mustSee;
	
	private String duration;

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public List<Gallery> getGallery() {
		return gallery;
	}

	public void setGallery(List<Gallery> gallery) {
		this.gallery = gallery;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public String getBestTime() {
		return bestTime;
	}

	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	public String getMustSee() {
		return mustSee;
	}

	public void setMustSee(String mustSee) {
		this.mustSee = mustSee;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
