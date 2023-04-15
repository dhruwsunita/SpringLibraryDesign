package com.glearning.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.library.entity.Library;
import com.glearning.library.service.LibraryDeleteService;

@RestController
@RequestMapping("/deleteService")
public class LibraryDeleteController {
	
	@Autowired
	LibraryDeleteService deleteService;
	
	@DeleteMapping("/deleteOneLibrary")
	public String deleteOneLibrary(Library library) {
		return deleteService.deleteOneLibrary(library);
	}
	@DeleteMapping("/pruneTable")
	public String pruneTable() {
		return deleteService.pruneTable();
	}
	@PostMapping("/deleteAllThese")
	public String deleteAllThese(@RequestBody List<Library> libraries) {
		return deleteService.deleteAllThese(libraries);
	}
	@DeleteMapping("/deleteAllInBatch")
	public String deleteAllInBatch() {
		return deleteService.deleteAllInBatch();
	}
	@DeleteMapping("/deleteLibraryById")
	public String deleteLibraryById(Long id) {
		return deleteService.deleteLibraryById(id);
	}
	@PostMapping("/deleteAllTheseInBatch")
	public String deleteAllTheseInBatch(@RequestBody List<Library> libraries) {
		return deleteService.deleteAllTheseInBatch(libraries);
	}

}
