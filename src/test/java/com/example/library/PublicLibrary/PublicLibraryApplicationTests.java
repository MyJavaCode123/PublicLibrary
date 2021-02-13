package com.example.library.PublicLibrary;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.library.PublicLibrary.model.Books;
import com.example.library.PublicLibrary.model.Library;
import com.example.library.PublicLibrary.repository.BookRepository;
import com.example.library.PublicLibrary.repository.LibraryRepository;
import com.example.library.PublicLibrary.service.LibraryService;

@SpringBootTest
@AutoConfigureMockMvc

class PublicLibraryApplicationTests {
	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Autowired
	BookRepository bookRepository;
	
    @Autowired
    private LibraryService libraryService;
    
 
    
	@Test
	void contextLoads() {	
	}

	
	@Test
	public void allBooksinLibrary()
	  throws Exception {
		insertTestData();
		Library lbData = libraryService.getById(1L);
		assertEquals(lbData.getLibraryName(),"Central Library");
		assertEquals(lbData.getBooks().size(),3);
	}

	@Test
	public void deleteBooksinLibrary()  throws Exception {
		insertTestData();
		libraryService.deleteBooks(1L);
		Library lbData = libraryService.getById(1L);
		assertEquals(lbData.getLibraryName(),"Central Library");
		assertEquals(lbData.getBooks().size(),2);
	}

	
	@Test
	public void editBooksinLibrary()
	  throws Exception {
		Library library = new Library("North Library++");
		library.setLibraryId(1L);
        Books b1 = new Books("JAVA", "David", "Introduction to JAVA","1.1", library);
        b1.setId(1L);
        
        Books b1Data = libraryService.editBookss(b1);
        
        assertEquals(b1Data.getLibraryData().getLibraryName(),"North Library++");
	}

	
	@Test
	public void addBooksinLibrary()
	  throws Exception {
		Library library = new Library("Central Library++");
		library.setLibraryId(1L);
        Books b1 = new Books("JAVA", "David", "Introduction to JAVA","1.1", library);
        b1.setId(1L);
        
		Books bbData = libraryService.addBook(b1);
		
		assertEquals(bbData.getLibraryData().getLibraryName(),"Central Library++");
	}

	

	
	private void insertTestData(){
       	Library library = new Library("Central Library");

        // save the library
    	libraryRepository.save(library);
    		        	
    	// create and save new books
    	bookRepository.save(new Books("JAVA", "David", "Introduction to JAVA","1.1", library));
    	bookRepository.save(new Books("ORACLE", "John", "Introduction to ORACLE","1.2",library));
    	bookRepository.save(new Books("ECONOMICS", "William", "Concurrency Theory","1", library));
	}
}
