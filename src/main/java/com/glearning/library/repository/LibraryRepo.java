package com.glearning.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.library.entity.Library;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long>{
	
}
