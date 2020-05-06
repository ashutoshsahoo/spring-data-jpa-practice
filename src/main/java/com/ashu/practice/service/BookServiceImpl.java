package com.ashu.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ashu.practice.exception.BookNotFoundException;
import com.ashu.practice.exception.IsbnAlreadyExistsException;
import com.ashu.practice.model.Book;
import com.ashu.practice.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepo;

	public BookServiceImpl(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}

	@Override
	public Book create(Book book) {
		validateIsbn(book.getIsbn());
		return bookRepo.saveAndFlush(book);
	}

	@Override
	public Book findById(Long id) {
		return findBookById(id);
	}

	@Override
	public List<Book> findByName(String name) {
		return bookRepo.findByName(name);
	}

	@Override
	public List<Book> findAll() {
		return bookRepo.findAll();
	}

	@Override
	public Book update(Long id, Book book) {
		Book bookFound = findBookById(id);
		String isbn = book.getIsbn();
		Book BookWithIsbnFound = bookRepo.findByIsbn(isbn);
		if (BookWithIsbnFound != null && BookWithIsbnFound.getId() != bookFound.getId()) {
			throw new IsbnAlreadyExistsException(isbn);
		}
		book.setId(bookFound.getId());
		return bookRepo.saveAndFlush(book);
	}

	@Override
	public void delete(Long id) {
		Book bookFound = findBookById(id);
		bookRepo.delete(bookFound);

	}

	private Book findBookById(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		if (book.isPresent()) {
			return book.get();
		}
		throw new BookNotFoundException(id);
	}

	private void validateIsbn(String isbn) {
		Book bookFound = bookRepo.findByIsbn(isbn);
		if (bookFound != null) {
			throw new IsbnAlreadyExistsException(isbn);
		}
	}

}
