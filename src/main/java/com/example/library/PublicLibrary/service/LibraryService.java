package com.example.library.PublicLibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.PublicLibrary.model.Books;
import com.example.library.PublicLibrary.model.Library;
import com.example.library.PublicLibrary.repository.BookRepository;
import com.example.library.PublicLibrary.repository.LibraryRepository;
@Service
public class LibraryService {
	@Autowired
	LibraryRepository libraryRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	
	/**
	 * This method is used to add the books in a Library
	 * @param book
	 * @return added book data
	 */
	public Books addBook(Books book) {	
 
        Library library = libraryRepository.findByLibraryId(book.getLibraryData().getLibraryId());
        if (null == library) {
        	library = new Library();
        	library.setLibraryName(book.getLibraryData().getLibraryName());
        }else{
        	library.setLibraryId(book.getLibraryData().getLibraryId());
        	library.setLibraryName(book.getLibraryData().getLibraryName());
        }
        
        book.setLibraryData(library);
        return bookRepository.save(book);
    }
 
    /**
     * This method is used to edit the books in a Library
     * @param book entity
     * @return edited book data
     */
    public Books editBookss(Books entity) {
 
        return bookRepository.save(entity);
    }
 
    /**
     * This method is used to delete the books in a Library
     * @param id 
     */
    public void deleteBooks(Long id) {
 
    	bookRepository.deleteById(id);
    }
    
    /**
     * This method is used to get all the books in all Libraries
     * @return all data
     */
    public List<Books> getAll() {
    	return bookRepository.findAll();
    }
    
    
    /**
     * This method is used to get all the books in a particular Libraries
     * @param id
     * @return
     */
    public Library getById(Long id) {
    	return libraryRepository.findByLibraryId(id);
    }
    
}	
