package com.globetales.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globetales.DTO.Response;
import com.globetales.Service.AuthService;
import com.globetales.entity.UserEntity;

@RestController
@RequestMapping("/auth")
public class AuthController {

		
	@Autowired
	private AuthService authService;
	
	
	@PostMapping("/register/{confirmPass}")
	public ResponseEntity<Response> registerUser(@RequestBody UserEntity userEntity,@PathVariable String confirmPass){
		
		Response response = authService.registerNormal(userEntity, confirmPass);
		return ResponseEntity.status(response.getStatusCode()).body(response);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<Response> registerUser(@RequestBody UserEntity userEntity){
		
		Response response = authService.loginUser(userEntity);
		return ResponseEntity.status(response.getStatusCode()).body(response);
		
	}
	
}
