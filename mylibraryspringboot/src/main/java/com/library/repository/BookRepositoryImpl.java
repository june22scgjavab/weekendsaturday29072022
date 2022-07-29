package com.library.repository;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.library.model.dto.BookDTO;

@Repository
public class BookRepositoryImpl implements BookRepository {

	List<BookDTO> listOfBooks = null;

	public BookRepositoryImpl() {
		listOfBooks = new ArrayList<>();
		BookDTO book1 = new BookDTO(2, "Learn HTML", LocalDate.of(2022, 10, 11), 50.00f, "Joanna");
		listOfBooks.add(book1);
		BookDTO book2 = new BookDTO(3, "Learn CSS", LocalDate.of(2022, 11, 23), 35.00f, "Rishi");
		listOfBooks.add(book2);

	}

	@Override
	public int addBooks(BookDTO book) {
		listOfBooks.add(book);
		return book.getId();
	}

	@Override
	public List<BookDTO> listOfBooks() {

		return listOfBooks;
	}

	@Override
	public BookDTO searchBook(int id) {
		BookDTO searched = null;
		for (BookDTO book : listOfBooks) {
			if (book.getId() == id) {
				searched = book;
				break;
			}
		}
		return searched;
	}

}
