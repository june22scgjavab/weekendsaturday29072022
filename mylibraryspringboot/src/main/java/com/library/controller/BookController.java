package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.library.exception.BookException;
import com.library.model.dto.BookDTO;
import com.library.model.dto.BookReportDTO;
import com.library.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	public int addBook(BookDTO books) throws BookException {
		return bookService.addBooks(books);
	}

	public List<BookReportDTO> getBooks(float price) throws BookException {

		return bookService.listOfBooks(price);
	}

	public BookDTO searchBook(int id) throws BookException {
		return bookService.searchBook(id);

	}

}
