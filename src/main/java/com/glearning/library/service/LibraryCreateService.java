package com.glearning.library.service;

import java.util.List;

import com.glearning.library.entity.Library;

public interface LibraryCreateService {

	String addSingleLibrary(Library library);

	String getAllLibraries(List<Library> libraries);

	Library addLibraryWithSaveAndFlush(Library library);

}