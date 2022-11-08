package com.rest.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.rest.api.entities.Book;

public interface Bookrepo extends CrudRepository<Book,Integer> {

	public Book findbyid(int id);
}
