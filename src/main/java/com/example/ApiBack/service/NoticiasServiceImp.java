package com.example.ApiBack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ApiBack.dao.INoticiasDao;
import com.example.ApiBack.models.Noticas;
import com.example.ApiBack.response.NoticiasResponseRest;

import jakarta.transaction.Transactional;
@Service
public class NoticiasServiceImp implements INoticiasService {
	
	@Autowired
	private INoticiasDao notdao;
	
	@Override	
	public ResponseEntity<NoticiasResponseRest>savefav(Noticas noticias) {
		NoticiasResponseRest response = new NoticiasResponseRest();
		int validator = validarDatosNulos(noticias);	
		if (validator == 0) {
			try {
				notdao.save(noticias);
				response.setMetadata("200", "OK");
				return new ResponseEntity<NoticiasResponseRest>(response, HttpStatus.OK);
				
			}catch(Exception e){
				response.setMetadata("500", "Error al guardar favorito: "+ e.getMessage());
				e.printStackTrace();
				return new ResponseEntity<NoticiasResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}else {
			switch (validator) {
	        case 1:	        	
				response.setMetadata("500", "Request sin data");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        case 2:	        	
				response.setMetadata("500", "Id es NULL");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        case 3:
				response.setMetadata("500", "title es NULL");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        case 4:
				response.setMetadata("500", "url es NULL");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        case 5:
				response.setMetadata("500", "image_url es NULL");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        case 6:
				response.setMetadata("500", "news_site es NULL");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        case 7:
				response.setMetadata("500", "summary es NULL");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        case 8:
				response.setMetadata("500", "published_at es NULL");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        case 9:
				response.setMetadata("500", "update_at es NULL");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        default:
				response.setMetadata("500", "Error al guardar");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
	//TODO valide que tomara los datos bien por debug no es aqui el error
	public int validarDatosNulos(Noticas noticias) {		
		if (noticias == null) {
	        return 1;
	    }	    
	    if (noticias.getId() == null) {
	        return 2;
	    }
	    if (noticias.getTitle() == null) {
	        return 3;
	    }	    
	    if (noticias.getUrl() == null) {
	        return 4;
	    }
	    if (noticias.getImageurl() == null) {
	        return 5;
	    }
	    if (noticias.getNews_site() == null) {
	        return 6;
	    }
	    if (noticias.getSummary() == null) {
	        return 7;
	    }
	    if (noticias.getPublishedat() == null) {
	        return 8;
	    }
	    if (noticias.getUpdatedat() == null) {
	        return 9;
	    }
	    return 0;
	}

	@Override
	@Transactional
	public ResponseEntity<NoticiasResponseRest>getfavs() {		
		NoticiasResponseRest response = new NoticiasResponseRest();
		try {
			Iterable<Noticas> noticias = notdao.findAll();
			if (noticias == null || !noticias.iterator().hasNext()) {
				response.setMetadata("404", "Favoritos no encontrados");
				return new ResponseEntity<NoticiasResponseRest>(response, HttpStatus.NOT_FOUND);
			}
			else{
				response.getNoticiasresponse().setNoticias(noticias);
				response.setMetadata("200", "OK");
				return new ResponseEntity<NoticiasResponseRest>(response, HttpStatus.OK);
			}
		} catch (Exception e) {
			response.setMetadata("500", "Error en consultar favoritos");
			return new ResponseEntity<NoticiasResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//TODO revisaste la base de datos por el delete?
	@Override
	@Transactional
	public ResponseEntity<NoticiasResponseRest> deletefav(Long id) {
		NoticiasResponseRest response = new NoticiasResponseRest();
		try {
			Optional<Noticas> optionalNoticia = notdao.findById(id);
			if(optionalNoticia.isPresent()){
				notdao.deleteById(id);
				response.setMetadata("200", "OK");
				return new ResponseEntity<NoticiasResponseRest>(response, HttpStatus.OK);
			}else {
				response.setMetadata("404", "Favorito no encontrado");
				return new ResponseEntity<NoticiasResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			response.setMetadata("500", "Error al borrar favorito: " + e.getMessage());
			return new ResponseEntity<NoticiasResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	@Transactional
	public ResponseEntity<NoticiasResponseRest> getbytilte(String title) {
		NoticiasResponseRest response = new NoticiasResponseRest();
		try {
			Iterable<Noticas> noticias = notdao.findByTitleContainingIgnoreCase(title);
			if(noticias == null || !noticias.iterator().hasNext()) {
				response.setMetadata("404", "Favorito no encontrado");
				return new ResponseEntity<NoticiasResponseRest>(response, HttpStatus.NOT_FOUND);
			}
			else {
				response.getNoticiasresponse().setNoticias(noticias);
				response.setMetadata("200", "OK");
				return new ResponseEntity<NoticiasResponseRest>(response, HttpStatus.OK);
			}
		}catch (Exception e) {
			response.setMetadata("500", "Error en consultar favorito");
			return new ResponseEntity<NoticiasResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
		
}
