package com.globetales.DTO;

import org.springframework.web.multipart.MultipartFile;

public class AdditionalImage {

	private MultipartFile file;
	

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
