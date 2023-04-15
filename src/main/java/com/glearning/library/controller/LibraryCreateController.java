package com.glearning.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.library.entity.Library;
import com.glearning.library.service.LibraryCreateService;

@RestController
@RequestMapping("/createService")
public class LibraryCreateController {
	
	@Autowired
	LibraryCreateService createService;
	
	@PostMapping("/addSingleLibrary")
	public String addSingleLibrary(Library library) {
		return createService.addSingleLibrary(library);
	}
	@PostMapping("/insertAllLibraries")
	public String insertAllLibraries(@RequestBody List<Library> libraries) {
		return createService.getAllLibraries(libraries);	
	}
	@PostMapping("/addLibrarywithSaveAndFlush")
	public Library addLibrarywithSaveAndFlush(Library library) {
		return createService.addLibraryWithSaveAndFlush(library);
	}

}
