package com.library.service;

import java.util.List;

import com.library.exception.BookException;
import com.library.model.dto.BookDTO;
import com.library.model.dto.BookReportDTO;

public interface BookService {
	int addBooks(BookDTO book) throws BookException;

	List<BookReportDTO> listOfBooks(float price) throws BookException;

	BookDTO searchBook(int id) throws BookException;
}
