package com.guru.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guru.app.model.Book;
import com.guru.app.model.BookRepository;

@SpringBootApplication
public class GraphqlSpringbootApplication implements CommandLineRunner {

	@Autowired
	public BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Book b1 = new Book(1, "Two States", "Chetan Bhagat", 200.0);
		bookRepository.save(b1);
	}

}
