package com.ashu.practice.service;

import java.util.List;

import com.ashu.practice.model.Book;

public interface BookService {

	Book create(Book book);

	Book findById(Long id);

	List<Book> findByName(String name);

	List<Book> findAll();

	Book update(Long id, Book book);

	void delete(Long id);
}
