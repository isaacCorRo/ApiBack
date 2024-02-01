package com.example.ApiBack.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.ApiBack.models.Noticas;

public interface INoticiasDao extends CrudRepository<Noticas, Long>{

	Iterable<Noticas> findByTitleContainingIgnoreCase(String title);

}
