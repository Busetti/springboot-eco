package com.guru.app.controller;

import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.guru.app.model.Author;
import com.guru.app.model.AuthorRepository;


@Controller
public class AuthorController {
	

	
	@Autowired
	public AuthorRepository authorRepository;
	
	@QueryMapping
	public Iterable<Author> allAuthors() {
		return authorRepository.findAll();
	}

	@QueryMapping
	public Iterable<Author> filterAuthors(@Argument("filter") String name) {
		return authorRepository.findAll().stream().filter(filterByName(name))
				.collect(Collectors.toList());
	}

	private Predicate<? super Author> filterByName(String name) {
		return t -> t.getName().equalsIgnoreCase(name);
	}

}
