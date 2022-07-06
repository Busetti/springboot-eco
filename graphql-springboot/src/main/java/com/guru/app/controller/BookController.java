package com.guru.app.controller;

import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.guru.app.model.Book;
import com.guru.app.model.BookRepository;

@Controller
public class BookController {

	@Autowired
	public BookRepository bookRepository;

	@QueryMapping
	public Iterable<Book> allBooks() {
		return bookRepository.findAll();
	}

	@QueryMapping
	public Iterable<Book> filterBooks(@Argument("filter") String name) {
		return bookRepository.findAll().stream().filter(filterByName(name)).collect(Collectors.toList());
	}

	@MutationMapping
	public Book createBook(@Argument String bookName, @Argument String author, @Argument Double price) {
		Book book = new Book(bookName, author, price);
		return bookRepository.save(book);
	}

	private Predicate<? super Book> filterByName(String name) {
		return t -> t.getBookName().equalsIgnoreCase(name);
	}

}
