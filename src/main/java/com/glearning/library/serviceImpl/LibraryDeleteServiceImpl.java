package com.glearning.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.library.entity.Library;
import com.glearning.library.repository.LibraryRepo;
import com.glearning.library.service.LibraryDeleteService;

@Service
public class LibraryDeleteServiceImpl implements LibraryDeleteService {

	@Autowired
	LibraryRepo libraryRepo;

	@Override
	public String deleteOneLibrary(Library library) {
		libraryRepo.delete(library);
		return "Deleted Library" + library;
	}

	@Override
	public String pruneTable() {
		libraryRepo.deleteAll();
		return "prune complete";
	}

	@Override
	public String deleteAllThese(List<Library> Libraries) {
		libraryRepo.deleteAll(Libraries);
		return "Delete All Complete";
	}

	@Override
	public String deleteAllInBatch() {
		libraryRepo.deleteAllInBatch();
		return "Deleted in Batch completed";
	}

	@Override
	public String deleteLibraryById(Long id) {
		libraryRepo.deleteById(id);
		return "Library with this id " + id + " is deleted";
	}

	@Override
	public String deleteAllTheseInBatch(List<Library> libraries) {
		libraryRepo.deleteInBatch(libraries);
		return "Deleted all Libraries in the list in batch mode";
	}

}
