package com.globetales.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globetales.DTO.ContentDTO;
import com.globetales.DTO.Response;
import com.globetales.Service.CohereService;

@RestController
@RequestMapping("/cohere")
public class CohereController {
	
	@Autowired
	private CohereService cohereService;

	@PostMapping("/generate")
	public ResponseEntity<Response> generateContent(@RequestBody ContentDTO contentDTO){
		
		Response response = cohereService.getContentSuggestion(contentDTO.getContent());
		return ResponseEntity.status(response.getStatusCode()).body(response);
		
	}
	
}
