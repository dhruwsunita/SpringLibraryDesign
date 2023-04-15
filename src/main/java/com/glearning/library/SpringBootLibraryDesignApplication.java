package com.glearning.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.glearning.library.entity.Library;
import com.glearning.library.model.FullName;
import com.glearning.library.model.GreatLearning;
import com.glearning.library.service.LibraryCountService;
import com.glearning.library.service.LibraryCreateService;
import com.glearning.library.service.LibraryDeleteService;
import com.glearning.library.service.LibraryExistService;
import com.glearning.library.service.LibraryReadService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

	@Autowired
	LibraryReadService libraryReadServiceImpl;

	@Autowired
	LibraryCreateService createServiceImpl;

	@Autowired
	LibraryCountService countServiceImpl;

	@Autowired
	LibraryExistService existServiceImpl;

	@Autowired
	LibraryDeleteService deleteServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
		System.out.println("Hello Spring");
		System.out.println("Hello Dev-Tools");

	}

	// Testing by CommandLineRunner
	public void run(String... args) throws Exception {
		// readServiceImplMethodsExecution();
		// createServiceImplMethodsExecution();
		// countServiceImplMethodsExecution();
		// existServiceImplMethodsExecution();

//		log.info("Delete one Library -> {}", deleteServiceImpl.deleteOneLibrary(
//				Library.builder().id(10l).name("C library").commaSeperatedBookName("xyz, abc, efg").build()));
//
//		log.info("Prune Library Table -> {}", deleteServiceImpl.pruneTable());
		 
		// TO delete all these mentioned libraries
//		List<Library> libraries = new ArrayList<>();
//		libraries.add(Library.builder().id(3l).commaSeperatedBookName("").name("Animal library").build());
//		libraries.add(Library.builder().id(4l).commaSeperatedBookName("").name("Cloud library").build());
//		log.info("Delete all these -> {}", deleteServiceImpl.deleteAllThese(libraries));
//		log.info("Delete all in Batch -> {}", deleteServiceImpl.deleteAllInBatch());
//		log.info("Delete Library by id -> {}",deleteServiceImpl.deleteLibraryById(6l));
		/*
		 * List<Library> libraries = new ArrayList<>();
		 * libraries.add(Library.builder().id(3l).commaSeperatedBookName("").
		 * name("Animal library").build());
		 * libraries.add(Library.builder().id(4l).commaSeperatedBookName("").
		 * name("Cloud library").build());
		 * log.info("Deleting all the libraries in batch -> {}",deleteServiceImpl.
		 * deleteAllTheseInBatch(libraries));
		 */
	}

	private void existServiceImplMethodsExecution() {
		log.info("Check Library exists by id -> {}", existServiceImpl.checkLibraryExistsById(11l));

		log.info("Check Library with these books -> {}",
				existServiceImpl.checkLibraryExistsByExample("Mars Red Planet, Titan with water "));
	}

	private void countServiceImplMethodsExecution() {
		log.info("Count the number of Libraries  -> {}", countServiceImpl.countLibraries());

		// To count Libraries with zero books
		log.info("Count Libraries with zero books -> {}", countServiceImpl.countLibrariesWithZeroBooks());
	}

	private void createServiceImplMethodsExecution() {
		// To save one Library
		log.info("Persist a single library -> {}", createServiceImpl.addSingleLibrary(
				Library.builder().id(11l).name("E Library").commaSeperatedBookName("xyz,abc").build()));

		// To save all libraries
		List<Library> allLibraries = new ArrayList<Library>();
		allLibraries.add(Library.builder().id(12l).name("F Library").commaSeperatedBookName("abc,efg").build());
		allLibraries.add(Library.builder().id(13l).name("G Library").commaSeperatedBookName("efg").build());
		log.info("Persist all Libraries -> {}", createServiceImpl.getAllLibraries(allLibraries));

		// To use Save and Flush jointly
		log.info("Persist a library with SaveAndFlush -> {}", createServiceImpl.addLibraryWithSaveAndFlush(Library
				.builder().id(14l).name("E-Commerce Library").commaSeperatedBookName("Amazon, Flipcart").build()));
	}

	// Extracted method of all previous logs
	private void readServiceImplMethodsExecution() {
		log.info("Fetch all libraries -> {}", libraryReadServiceImpl.getAllLibrary());

		log.info("Fetch all library with no Books -> {}", libraryReadServiceImpl.getAllLibrariesWithNoBooks());

		// it will print the library details in page format in console first 3 lib
		log.info("Fetch Libraries in Page format -> {} ",
				libraryReadServiceImpl.getLibrariesPaged().get().collect(Collectors.toList()));
		log.info("Fetch all the Libraries in custom format - > {}",
				libraryReadServiceImpl.getLibrariesCustomPaged(2, 2).get().collect(Collectors.toList()));
		log.info("Fetch all Libraries with latest added order -> {}",
				libraryReadServiceImpl.getLibrariesWithLatestAddedOrder());

		log.info("Fetch Libraries Custom sorted by id -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedById(Direction.DESC));

		log.info("Fetch Libraries Custom sorted by name -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedByName(Direction.ASC));

		log.info("Fetch Libraries default Paged and sorted and with these books -> {} ", libraryReadServiceImpl
				.getLibrariesPagedAndSortedByNameAndWithTheseBooks("xyz, abc, efg").get().collect(Collectors.toList()));

		log.info("Fetch Libraries default paged and default sorted by name -> {}",
				libraryReadServiceImpl.getLibrariesPagedAndSortedByName().get().collect(Collectors.toList()));

		log.info("Fetch Libraries custom paged , sorted default order by name and with these books -> {}",
				libraryReadServiceImpl
						.getLibrariesCustomPagedAndSortedDefaultOrderByNameAndWithTheseBooks("xyz, abc, efg", 1, 2)
						.get().collect(Collectors.toList()));

		log.info("Fetch Libraries with default sorted by name -> {}",
				libraryReadServiceImpl.getSortedByNameAndWithTheseBooks("xyz, abc, efg"));

		// libraries by name
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(2l);
		log.info("Fetch Libraries by ids -> {}", libraryReadServiceImpl.getLibrariesByIds(ids));

		// Find by id only
		Long id = 12l;
		Optional<Library> optionallib = libraryReadServiceImpl.getALibraryById(id);
		if (optionallib.isPresent()) {
			log.info("Fetch Libraries by id -> {}", optionallib);
		} else {
			log.info("No matching Library with this id " + id + " in DB ");
		}

		// gives a library with matching books
		Optional<Library> optionalSingleLib = libraryReadServiceImpl
				.getALibraryWithTheseBooks("Tommy life, Brownie life");
		if (optionalSingleLib.isPresent()) {
			log.info("Fetch library with these books -> {}", optionalSingleLib.get());
		} else {
			log.info("No matching Library with this id " + id + " in DB ");
		}
	}

}
