package com.glearning.library.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.glearning.library.entity.Library;
import com.glearning.library.repository.LibraryRepo;
import com.glearning.library.service.LibraryReadService;

@Service
public class LibraryReadServiceImpl implements LibraryReadService {

	@Autowired
	LibraryRepo readRepository;

	@Override
	public List<Library> getAllLibrary() {
		return readRepository.findAll();
	}

	@Override
	public List<Library> getAllLibrariesWithNoBooks() {
		Library libraryWithNoBooksLibrary = new Library();
		libraryWithNoBooksLibrary.setCommaSeperatedBookName("");
		// Below exampleMatcher will make sure that only commaSeperatedBookName is
		// considered
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithNoBooksLibrary, exampleMatcher);
		return readRepository.findAll(example);
	}

	@Override
	public Page<Library> getLibrariesPaged() {
		// Page no starts with 0
		Pageable first3records = PageRequest.of(0, 3);
		return readRepository.findAll(first3records);
	}

	@Override
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage) {

		Pageable first3records = PageRequest.of(pageNumber, numberOfRecordsOnAPage);
		return readRepository.findAll(first3records);
	}

	@Override
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return readRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "name"));
	}

	// This method is combination of example matcher, sorting and paging
	@Override
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeperatedBookname) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBookName(commaSeperatedBookname);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		Pageable first4records = PageRequest.of(0, 4, Sort.by("name"));
		return readRepository.findAll(example, first4records);
	}

	@Override
	public Page<Library> getLibrariesPagedAndSortedByName() {
		Pageable pageble = PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(pageble);
	}

	@Override
	public Page<Library> getLibrariesCustomPagedAndSortedDefaultOrderByNameAndWithTheseBooks(
			String commaSeperatedBookname, int pageNumber, int numOfRecordsOnAPage) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBookName(commaSeperatedBookname);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		Pageable customPage = PageRequest.of(pageNumber, numOfRecordsOnAPage, Sort.by("name"));
		return readRepository.findAll(example, customPage);

	}

	@Override
	public List<Library> getSortedByNameAndWithTheseBooks(String commaSeperatedBookname) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBookName(commaSeperatedBookname);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		return readRepository.findAll(example, Sort.by("name"));

	}

	@Override
	public List<Library> getLibrariesByIds(List<Long> ids) {
		return readRepository.findAllById(ids);
	}

	@Override
	public Optional<Library> getALibraryById(Long id) {
		return readRepository.findById(id);
	}

	@Override
	public Optional<Library> getALibraryWithTheseBooks(String commaSeperatedBookname) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBookName(commaSeperatedBookname);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		return readRepository.findOne(example);
	}

}
