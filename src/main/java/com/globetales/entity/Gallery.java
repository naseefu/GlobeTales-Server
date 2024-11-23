package com.globetales.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;

@Embeddable
public class Gallery {

	@Lob
	private String url;
	
	private String caption;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
}
