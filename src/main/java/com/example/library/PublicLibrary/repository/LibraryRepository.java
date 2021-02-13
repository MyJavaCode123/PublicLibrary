package com.example.library.PublicLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.PublicLibrary.model.Library;
@Repository
public interface LibraryRepository extends JpaRepository<Library, Long>{
	Library findByLibraryId(Long libraryId);
}
