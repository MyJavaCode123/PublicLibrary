package com.example.library.PublicLibrary.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")	
public class Books implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "description")
	private String description;

	@Column(name = "published_version")
	private String publishedVersion;
	
	
	@ManyToOne(cascade = {
	        CascadeType.PERSIST, 
	        CascadeType.MERGE
	    })
	@JoinColumn(name = "library_id")
	private Library libraryData;


	
	public Books() {
		
	}

	public Books(String title, String author, String description, String publishedVersion, Library libraryData) {
		this.title =title;
		this.author=author;
		this.description=description;
		this.publishedVersion=publishedVersion;
		this.libraryData=libraryData;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPublishedVersion() {
		return publishedVersion;
	}


	public void setPublishedVersion(String publishedVersion) {
		this.publishedVersion = publishedVersion;
	}


	public Library getLibraryData() {
		return libraryData;
	}


	public void setLibraryData(Library libraryData) {
		this.libraryData = libraryData;
	}


		
	
	
	
}
