package com.ashu.practice.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.practice.model.Book;
import com.ashu.practice.service.BookService;
import com.ashu.practice.util.BookConstants;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/books", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class BookController {

	private final BookService bookService;

	public BookController(final BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@PostMapping
	public Book create(@RequestBody Book book) {
		log.debug("Request received for book creation", book.toString());
		return bookService.create(book);
	}

	@GetMapping
	public List<Book> findAll() {
		log.debug("Request received for listAll books");
		return bookService.findAll();
	}

	@GetMapping(path = "/{id}")
	public Book findById(@PathVariable(name = "id") Long id) {
		log.debug("Request received for findById for id=" + id);
		return bookService.findById(id);
	}

	@GetMapping(path = "/search")
	public List<Book> findByName(
			@Valid @Pattern(regexp = BookConstants.NAME_REGEX, message = BookConstants.NAME_REGEX_FAILURE_MSG) @RequestParam(name = "name") String name) {
		log.debug("Request received for findByName for name=" + name);
		return bookService.findByName(name);
	}

	@PutMapping(path = "/{id}")
	public Book update(@PathVariable(name = "id") Long id, @RequestBody Book book) {
		log.debug("Request received for book updation with id=" + id, book.toString());
		return bookService.update(id, book);
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		log.debug("Request received for book deletion with id=" + id);
		bookService.delete(id);
	}

}
