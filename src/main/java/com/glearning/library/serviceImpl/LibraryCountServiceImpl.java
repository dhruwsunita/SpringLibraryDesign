package com.glearning.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.glearning.library.entity.Library;
import com.glearning.library.repository.LibraryRepo;
import com.glearning.library.service.LibraryCountService;

@Service
public class LibraryCountServiceImpl implements LibraryCountService {

	@Autowired
	LibraryRepo libraryRepo;

	@Override
	public long countLibraries() {
		return libraryRepo.count();

	}

	@Override
	public long countLibrariesWithZeroBooks() {
		Library library = new Library();
		library.setCommaSeperatedBookName("");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(library, exampleMatcher);
		return libraryRepo.count(example);
	}

}
