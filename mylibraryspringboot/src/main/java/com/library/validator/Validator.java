package com.library.validator;

import java.time.LocalDate;

import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.library.exception.BookException;
import com.library.model.dto.BookDTO;

@Component
public class Validator {

	public void validate(BookDTO book) throws BookException {
		try {
			String message = null;
			if (!validateId(book.getId())) {
				message = "Validator.INVALID_BOOK_ID";
			}
			if (!validateBookName(book.getName())) {
				message = "Validator.INVALID_BOOK_NAME";
			}
			if (!validateBookPublishDate(book.getPublishDate())) {
				message = "Validator.INVALID_BOOK_PUBLISH_DATE";
			}
			if (!validPrice(book.getPrice())) {
				message = "Validator.INVALID_BOOK_PRICE";
			}
			if (message != null) {
				BookException exception = new BookException(message);
				throw exception;
			}
		} catch (BookException exception) {
			LogFactory.getLog(getClass()).error(exception.getMessage(), exception);
			throw exception;
		}

	}

	public boolean validateId(int id) {
		boolean validId = true;
		if (id <= 0) {
			validId = false;
		}
		return validId;
	}

	public boolean validateBookName(String name) {
		boolean validBookName = true;
		String regex = "^([A-Z][a-z]+)(\\s[A-Z][a-z]+){1,}$";
		if (!name.matches(regex)) {
			validBookName = false;
		}
		return validBookName;

	}

	public boolean validateBookPublishDate(LocalDate publishDate) {

		boolean validDate = true;
		if (publishDate.isAfter(LocalDate.now())) {
			validDate = false;
		}
		return validDate;
	}

	public boolean validPrice(float price) {
		boolean validPrice = true;
		if (price <= 0) {
			validPrice = false;
		}
		return validPrice;
	}

}
