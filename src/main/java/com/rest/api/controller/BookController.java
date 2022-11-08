package com.rest.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.entities.Book;
import com.rest.api.services.Bookservices;

@RestController
public class BookController {
	

	
	@Autowired
	private Bookservices bookservice ;
	
	

	@GetMapping(value = "/books")
	public  ResponseEntity<List<Book>>  getBooks() {
		
		List<Book> list =  Bookservices.getAllBooks();
		
		
		if(list.size() <= 0 )				
		{
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));	
	}
	
	
	@GetMapping(value = "/books/{id}")
	public ResponseEntity<Book> getbook(@PathVariable("id") int id) {
	
		Book book = bookservice.getBookById(id);
		if(book == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(book));	

}
	
	
	@PostMapping(value = "/books/{id}")
	public Book getbook(@RequestBody Book book) {
	
	     Book b = this.bookservice.addBook(book);
	     
	     System.out.println("book");
	     
	     return b ;
	     
	     
	     
	
}
}

