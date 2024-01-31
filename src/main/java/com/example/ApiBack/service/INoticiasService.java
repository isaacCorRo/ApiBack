package com.example.ApiBack.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ApiBack.models.Noticas;
import com.example.ApiBack.response.NoticiasResponseRest;

public interface INoticiasService {
	
	public ResponseEntity<NoticiasResponseRest>savefav(Noticas noticia);
	public ResponseEntity<NoticiasResponseRest>deletefav(Long id);
	public ResponseEntity<NoticiasResponseRest> getbytilte(String title);
	public ResponseEntity<NoticiasResponseRest> getfavs();

}
