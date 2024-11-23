package com.globetales.DTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.globetales.entity.CommentEntity;

public class BlogE {

	private Long id;
	
	private String title;
	
	private LocalDate date;
	
	private MultipartFile mainImage;
	
	private String content;
	
	private String bestTime;
	
	private String mustSee;
	
	private String duration;
	
	private List<MultipartFile> galleries;
	private List<String> captions;
	private List<CommentEntity> commentEntities = new ArrayList<>();
	
	public List<String> getCaptions() {
		return captions;
	}

	public void setCaptions(List<String> captions) {
		this.captions = captions;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public List<CommentEntity> getCommentEntities() {
		return commentEntities;
	}

	public void setCommentEntities(List<CommentEntity> commentEntities) {
		this.commentEntities = commentEntities;
	}

	public MultipartFile getMainImage() {
		return mainImage;
	}

	public void setMainImage(MultipartFile mainImage) {
		this.mainImage = mainImage;
	}

	public List<MultipartFile> getGalleries() {
		return galleries;
	}

	public void setGalleries(List<MultipartFile> galleries) {
		this.galleries = galleries;
	}

	
	
	
}
