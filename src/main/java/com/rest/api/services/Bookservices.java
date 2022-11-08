package com.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rest.api.dao.Bookrepo;
import com.rest.api.entities.Book;

public class Bookservices {
	@Autowired
	private Bookrepo bookrepo ;
	
	public List<Book> getAllBooks(){
		List<Book> list = (List <Book>)
		this.bookrepo.findAll();
		return list ;	
	}
	
	public Book getBookById(int id)
	{
		Book book = null ;
		try {
			
			book = this.bookrepo.findbyid(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return book ;
		
	}
	
	public Book addBook(Book b)
	{
		Book result = bookrepo.save(b);
		
		return result ;
	}
	
	public void deleteBook(int bid)
	{
		bookrepo.deleteById(bid);
		
	}
	
	public void update (Book book ,int bookid)
	{
		book.setId(bookid);
		bookrepo.save(book);
	}
	

}
