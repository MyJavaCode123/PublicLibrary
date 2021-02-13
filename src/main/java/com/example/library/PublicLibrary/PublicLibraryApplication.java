package com.example.library.PublicLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PublicLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicLibraryApplication.class, args);
	}
	
	/*  @Bean
	    public CommandLineRunner mappingDemo(BookRepository bookRepository,LibraryRepository libraryRepository) {
	        return args -> {

	            // create a new Library
	        	Library library = new Library("Central Library");

	            // save the library
	        	libraryRepository.save(library);
	        		        	
	        	// create and save new books
	        	bookRepository.save(new Books("JAVA", "David", "Introduction to JAVA","1.1", library));
	        	bookRepository.save(new Books("ORACLE", "John", "Introduction to ORACLE","1.2",library));
	        	bookRepository.save(new Books("ECONOMICS", "William", "Concurrency Theory","1", library));
	        	
	        };
	    }*/
}
