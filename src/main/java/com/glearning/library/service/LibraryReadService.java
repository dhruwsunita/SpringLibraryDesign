package com.glearning.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.glearning.library.entity.Library;

public interface LibraryReadService {

	List<Library> getAllLibrary();

	List<Library> getAllLibrariesWithNoBooks();

	Page<Library> getLibrariesPaged();

	Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage);

	List<Library> getLibrariesWithLatestAddedOrder();

	List<Library> getLibrariesCustomSortedById(Direction direction);

	List<Library> getLibrariesCustomSortedByName(Direction direction);

	// This method is combination of example matcher, sorting and paging
	Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeperatedBookname);

	Page<Library> getLibrariesPagedAndSortedByName();

	Page<Library> getLibrariesCustomPagedAndSortedDefaultOrderByNameAndWithTheseBooks(String commaSeperatedBookname,
			int pageNumber, int numOfRecordsOnAPage);

	List<Library> getSortedByNameAndWithTheseBooks(String commaSeperatedBookname);

	List<Library> getLibrariesByIds(List<Long> ids);

	Optional<Library> getALibraryById(Long id);

	Optional<Library> getALibraryWithTheseBooks(String commaSeperatedBookname);

}