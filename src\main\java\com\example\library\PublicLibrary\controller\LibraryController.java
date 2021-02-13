
package com.example.library.PublicLibrary.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.PublicLibrary.model.Books;
import com.example.library.PublicLibrary.model.Library;
import com.example.library.PublicLibrary.repository.LibraryRepository;
import com.example.library.PublicLibrary.service.LibraryService;

@RestController
@RequestMapping("/api")
public class LibraryController {

	
	@Autowired
	LibraryService libraryService;
	
	@Autowired
	LibraryRepository libraryRepository;
	
		
	
	/**
	 * This service is used to get all the books in all Libraries
	 * @return ALL Data
	 */
	@GetMapping("/allLibrary")
	public ResponseEntity<List<Books>>  getAll() {
		List<Books>	libraryData = libraryService.getAll();
		if (libraryData!=null) {
			return new ResponseEntity<>(libraryData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * This Service is used to get all the books in that particular library
	 * @param id
	 * @return Set<Books>
	 */
	@GetMapping("/library/{id}")
	public ResponseEntity<Set<Books>>  getBooksByLibraryId(@PathVariable("id") Long id) {
		Set<Books> bookData = null;
		if (id!=null){
			Library	library = libraryService.getById(id);
			if(library!=null)
				bookData = library.getBooks();
		}

		if (bookData!=null) {
			return new ResponseEntity<>(bookData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * This Service is used to save the books in a particular library
	 * @param book
	 * @return saved Books data
	 */
	@PostMapping("/Books")
    public ResponseEntity<Books> saveBooks(@RequestBody Books book) {
        Books emp = libraryService.addBook(book);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
 
    /**
     * This Service is used to update the books in a particular library
     * @param book
     * @return updated Book data
     */
    @PutMapping("/Books")
    public ResponseEntity<Books> updateBooks(@RequestBody Books book) {
 
        Books emp = libraryService.editBookss(book);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
 
    /**
     * This Service is used to delete the books in a particular library
     * @param bookId
     * @return success if book is deleted
     */
    @DeleteMapping("/Books")
    public ResponseEntity<String> deleteBooks(@RequestParam(name = "id") Long bookId) {
    	libraryService.deleteBooks(bookId);
        return new ResponseEntity<>("Books with ID :" + bookId + " deleted successfully", HttpStatus.OK);
    }
}
