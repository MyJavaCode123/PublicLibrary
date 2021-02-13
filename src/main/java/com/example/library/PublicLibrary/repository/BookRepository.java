package com.example.library.PublicLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.PublicLibrary.model.Books;
@Repository
public interface BookRepository extends JpaRepository<Books, Long>{
}
