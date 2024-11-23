package com.globetales.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.globetales.DTO.CohereDTO;
import com.globetales.DTO.Response;
import com.globetales.Exception.OurException;

@Service
public class CohereService {

	@Value("${cohere.api.url}")
    private String apiUrl;

    @Value("${cohere.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;
	
	
    public Response getContentSuggestion(String content) {
        Response response = new Response();

        try {

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer Zo3EO15E7HxnVe33cvcYgpamEuJA9LODGcfm6SuH");
            headers.set("Content-Type", "application/json");

            String prompt = content+", iam stuck here give me continuation with the content i given no other comments by you,start with '"+content+"' "
                          + "maximum of 100 words";        
            
            CohereDTO requestPayload = new CohereDTO(prompt);

            HttpEntity<CohereDTO> requestEntity = new HttpEntity<>(requestPayload, headers);

            ResponseEntity<Response> apiResponse = restTemplate.exchange(
                "https://api.cohere.ai/v1/generate",
                HttpMethod.POST,
                requestEntity,
                Response.class
            );

            if (apiResponse.getBody() != null && 
                apiResponse.getBody().getGenerations() != null && 
                !apiResponse.getBody().getGenerations().isEmpty()) {

                String generatedText = apiResponse.getBody().getGenerations().get(0).getText();
                response.setStatusCode(200);
                response.setMessage("Success");
                response.setGeneratedContent(generatedText);
            } else {
                response.setStatusCode(500);
                response.setMessage("Invalid response from the content generation API");
            }

        } catch (OurException e) {
            response.setStatusCode(400);
            response.setMessage("Error occurred during content generation: " + e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Unexpected error occurred: " + e.getMessage());
        }

        return response;
    }

}

