package com.library.repository;

import java.awt.print.Book;
import java.util.List;

import com.library.model.dto.BookDTO;

public interface BookRepository {
	int addBooks(BookDTO book);

	List<BookDTO> listOfBooks();

	BookDTO searchBook(int id);
}
