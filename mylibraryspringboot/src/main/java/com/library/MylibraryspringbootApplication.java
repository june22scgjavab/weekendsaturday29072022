package com.library;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.library.controller.BookController;
import com.library.exception.BookException;
import com.library.model.dto.BookDTO;
import com.library.model.dto.BookReportDTO;

@SpringBootApplication
public class MylibraryspringbootApplication implements CommandLineRunner {

	@Autowired
	private BookController bookController;

	@Autowired
	private Environment environment;

	private final Log LOGGER = LogFactory.getLog(getClass());

	public static void main(String[] args) {
		SpringApplication.run(MylibraryspringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("------------------BOOK ADD-----------------\n");
		addBook();
		LOGGER.info("------------------BOOK LIST-----------------\n");
		listOfBooks();
		LOGGER.info("------------------SEARCH BOOK-----------------\n");
		searchBook();

	}

	private void addBook() {
		BookDTO book = new BookDTO(1, "Complete Reference", LocalDate.now(), 45.67f, "Jim");
		try {
			int id = bookController.addBook(book);
			LOGGER.info("The book is registered with id " + id);
		} catch (BookException e) {
			LOGGER.error(environment.getProperty(e.getMessage()));

		}

	}

	private void listOfBooks() {
		try {
			List<BookReportDTO> bookList = bookController.getBooks(40);
			LOGGER.info(bookList);
		} catch (BookException e) {

			LOGGER.error(environment.getProperty(e.getMessage()));
		}

	}

	private void searchBook() {
		try {
			BookDTO book = bookController.searchBook(10);
			LOGGER.info(book);
		} catch (BookException e) {
			LOGGER.error(environment.getProperty(e.getMessage()));
		}

	}

}
