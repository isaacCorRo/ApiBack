package com.example.ApiBack.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ApiBack.models.Noticas;

public interface NoticiasInterface extends JpaRepository<Noticas, Long> {

}
