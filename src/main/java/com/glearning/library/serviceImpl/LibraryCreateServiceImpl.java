package com.glearning.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.library.entity.Library;
import com.glearning.library.repository.LibraryRepo;
import com.glearning.library.service.LibraryCreateService;

@Service
public class LibraryCreateServiceImpl implements LibraryCreateService {

	@Autowired
	LibraryRepo libraryRepo;

	@Override
	public String addSingleLibrary(Library library) {
		libraryRepo.save(library);
		libraryRepo.flush();
		return "Library saved";
	}
	
	@Override
	public String getAllLibraries(List<Library> libraries) {
		libraryRepo.saveAll(libraries);
		libraryRepo.flush();
		return "All Libraries are saved";
	}
	@Override
	public Library addLibraryWithSaveAndFlush(Library library) {
		return libraryRepo.saveAndFlush(library);
	}

}
