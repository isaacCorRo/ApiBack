package com.example.ApiBack.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiBack.models.Noticas;
import com.example.ApiBack.response.NoticiasResponseRest;
import com.example.ApiBack.service.INoticiasService;

@CrossOrigin
@RestController
@RequestMapping("/Apiback")
public class NoticiasController {
	
	@Autowired
	private INoticiasService service;
	
	@PostMapping("/savefav")
	public ResponseEntity<NoticiasResponseRest> saveFav (@RequestBody Noticas request){
		ResponseEntity<NoticiasResponseRest> response = service.savefav(request);
		return response;
	}
	
	@DeleteMapping("/deletefav/{idfav}")
	public ResponseEntity<NoticiasResponseRest> deletefav(@PathVariable Long idfav){
		ResponseEntity<NoticiasResponseRest>response = service.deletefav(idfav);
		return response;
	}
	
	@GetMapping("/getfavs")
	public ResponseEntity<NoticiasResponseRest>getfavs(){
		ResponseEntity<NoticiasResponseRest> response =  service.getfavs();
		return response;
	}
	
	@GetMapping("/getbytitle/{title}")
	public ResponseEntity<NoticiasResponseRest>getbytitle(@PathVariable String title){
		ResponseEntity<NoticiasResponseRest> response =  service.getbytilte(title);
		return response;
	}
		
	
}
