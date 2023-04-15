package com.glearning.library.service;

public interface LibraryExistService {

	boolean checkLibraryExistsById(Long id);

	boolean checkLibraryExistsByExample(String commaSeperatedBookname);

}