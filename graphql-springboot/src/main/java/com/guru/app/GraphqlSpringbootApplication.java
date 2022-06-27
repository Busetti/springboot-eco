package com.guru.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guru.app.model.Author;
import com.guru.app.model.AuthorRepository;
import com.guru.app.model.Book;
import com.guru.app.model.BookRepository;

@SpringBootApplication
public class GraphqlSpringbootApplication implements CommandLineRunner {

	@Autowired
	public AuthorRepository authorRepository;
	
	@Autowired
	public BookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GraphqlSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Author a1 = new Author(1, "Chetan Bhagat");
		authorRepository.save(a1);
		
		Author a2 = new Author(2, "Paulo Cohelo");
		authorRepository.save(a2);
		
		Book b1 = new Book(1, "Two States", a1);
		bookRepository.save(b1);
	}

}
