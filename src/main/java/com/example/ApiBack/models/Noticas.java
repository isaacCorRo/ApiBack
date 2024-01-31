package com.example.ApiBack.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name= "tablefavs")
public class Noticas {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id_fav", nullable = false, unique = true)
	private Long idfav;
	
	@Column (name = "id")
	private String id;
	
	@Column (name="title")
	private String title;
	
	@Column (name= "url")
	private String url;
	
	@Column (name= "image_url")
	private String image_url;
	
	@Column (name= "news_site")
	private String news_site;
	
	@Column (name= "summary", length = 1024)
	private String summary;
	
	@Column (name= "published_at")
	private LocalDateTime published_at;
	
	@Column (name= "updated_at")	
	private LocalDateTime updated_at;
	
	@Column (name= "featured")
	private boolean featured;

	public Long getIdfav() {
		return idfav;
	}

	public void setIdfav(Long idfav) {
		this.idfav = idfav;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImageurl() {
		return image_url;
	}

	public void setImageurl(String image_url) {
		this.image_url = image_url;
	}

	public String getNews_site() {
		return news_site;
	}

	public void setNews_site(String news_site) {
		this.news_site = news_site;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public LocalDateTime getPublishedat() {
		return published_at;
	}

	public void setPublishedat(LocalDateTime publishedat) {
		this.published_at = publishedat;
	}

	public LocalDateTime getUpdatedat() {
		return updated_at;
	}

	public void setUpdatedat(LocalDateTime updatedat) {
		this.updated_at = updatedat;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}
	
	

}
