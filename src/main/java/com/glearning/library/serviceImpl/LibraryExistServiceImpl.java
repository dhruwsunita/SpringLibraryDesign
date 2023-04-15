package com.glearning.library.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.glearning.library.entity.Library;
import com.glearning.library.repository.LibraryRepo;
import com.glearning.library.service.LibraryExistService;

@Service
public class LibraryExistServiceImpl implements LibraryExistService {

	@Autowired
	LibraryRepo libraryRepo;

	@Override
	public boolean checkLibraryExistsById(Long id) {
		return libraryRepo.existsById(id);
	}

	@Override
	public boolean checkLibraryExistsByExample(String commaSeperatedBookname) {
		Library library = new Library();
		library.setCommaSeperatedBookName(commaSeperatedBookname);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(library, exampleMatcher);
		return libraryRepo.exists(example);
	}

}
