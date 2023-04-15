package com.glearning.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.library.entity.Library;
import com.glearning.library.service.LibraryReadService;

@RestController
@RequestMapping("/readService")
public class LibraryReadController {

	@Autowired
	LibraryReadService readService;

	@GetMapping("/getAllLibrary")
	public List<Library> getAllLibrary() {
		return readService.getAllLibrary();
	}
	@GetMapping("/getAllLibrariesWithNoBooks")
	public List<Library> getAllLibrariesWithNoBooks() {
		return readService.getAllLibrariesWithNoBooks();
	}
	@GetMapping("/getLibrariesPaged")
	public Page<Library> getLibrariesPaged() {
		return readService.getLibrariesPaged();
	}
	// it will show page no and no of records on that page according to our inputs
	@GetMapping("/getLibrariesCustomPaged")
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage) {
		return readService.getLibrariesCustomPaged(pageNumber, numberOfRecordsOnAPage);
	}
	@GetMapping("/getLibrariesWithLatestAddedOrder")
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return readService.getLibrariesWithLatestAddedOrder();
	}
	@GetMapping("/getLibrariesCustomSortedById")
	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readService.getLibrariesCustomSortedById(direction);
	}
	@GetMapping("/getLibrariesCustomSortedByName")
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readService.getLibrariesCustomSortedByName(direction);
	}
	@GetMapping("/getLibrariesPagedAndSortedByNameAndWithTheseBooks")
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeperatedBookname) {
		return readService.getLibrariesPagedAndSortedByNameAndWithTheseBooks(commaSeperatedBookname);
	}
	@GetMapping("/getLibrariesCustomPagedAndSortedDefaultOrderByNameAndWithTheseBooks")
	public Page<Library> getLibrariesCustomPagedAndSortedDefaultOrderByNameAndWithTheseBooks(String commaSeperatedBookname,
			int pageNumber, int numOfRecordsOnAPage) {
		return readService.getLibrariesCustomPagedAndSortedDefaultOrderByNameAndWithTheseBooks(commaSeperatedBookname, pageNumber, numOfRecordsOnAPage);
	}
	@GetMapping("/getSortedByNameAndWithTheseBooks")
	public List<Library> getSortedByNameAndWithTheseBooks(String commaSeperatedBookname) {
		return readService.getSortedByNameAndWithTheseBooks(commaSeperatedBookname);	
	}
	@PostMapping("/getLibrariesByIds")
	public List<Library> getLibrariesByIds(@RequestBody List<Long> ids) {
		return readService.getLibrariesByIds(ids);
	}
	
    // if library does not exist then we get null as output
	@GetMapping("/getALibraryById")
	public Optional<Library> getALibraryById(Long id) {
		return readService.getALibraryById(id);
	}
	
	// this API fails if we have more than one libraries with same records
	@GetMapping("/getALibraryWithTheseBooks")
	public Optional<Library> getALibraryWithTheseBooks(String commaSeperatedBookname) {
		return readService.getALibraryWithTheseBooks(commaSeperatedBookname);
	}
	@GetMapping("/getLibrariesPagedAndSortedByName")
	public Page<Library> getLibrariesPagedAndSortedByName() {
		return readService.getLibrariesPagedAndSortedByName();
	}

}
