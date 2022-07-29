package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.exception.BookException;
import com.library.model.dto.BookDTO;
import com.library.model.dto.BookReportDTO;
import com.library.repository.BookRepository;
import com.library.validator.Validator;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	Validator validator;

	@Override
	public int addBooks(BookDTO book) throws BookException {
		validator.validate(book);

		return bookRepository.addBooks(book);
	}

	@Override
	public List<BookReportDTO> listOfBooks(float price) throws BookException {
		List<BookReportDTO> bookReports = new ArrayList<>();
		List<BookDTO> books = bookRepository.listOfBooks();
		for (BookDTO book : books) {
			if (book.getPrice() > price) {
				BookReportDTO bookReport = new BookReportDTO();
				bookReport.setId(book.getId());
				bookReport.setName(book.getName());
				bookReport.setPublishDate(book.getPublishDate());
				bookReports.add(bookReport);
			}
		}
		if (bookReports.isEmpty()) {
			throw new BookException("Service.BOOKS_NOT_FOUND");
		}

		return bookReports;
	}

	@Override
	public BookDTO searchBook(int id) throws BookException {
		if (bookRepository.searchBook(id) == null) {
			throw new BookException("Service.BOOK_NOT_FOUND");
		}
		return bookRepository.searchBook(id);
	}

}
