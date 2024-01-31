package com.example.ApiBack.response;

import com.example.ApiBack.models.Noticas;

public class NoticiasResponse {

	private Iterable <Noticas> noticias;

	public Iterable<Noticas> getNoticias() {
		return noticias;
	}

	public void setNoticias(Iterable<Noticas> noticias) {
		this.noticias = noticias;
	}
	
	
}
