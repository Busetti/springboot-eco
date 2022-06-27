package com.guru.app.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Author {
	
	@Id
	private Integer id;
	private String name;
	
	@OneToMany
	@JoinColumn(name = "bookId")
	private Set<Book> booksWritten;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Book> getBooksWritten() {
		return booksWritten;
	}
	public void setBooksWritten(Set<Book> booksWritten) {
		this.booksWritten = booksWritten;
	}
	public Author(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Author [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", booksWritten=");
		builder.append(booksWritten);
		builder.append("]");
		return builder.toString();
	}
	
	
}
