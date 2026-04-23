package com.goodwork.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.goodwork.model.BookModel;
import com.goodwork.repository.BookRepository;

@Service
public class BookService implements BookRepository{
	private HashMap<Integer,BookModel> hmap = new HashMap<>();
	int uniqueId = 3;
	public BookService() {
		BookModel b1 = new BookModel(1,"The king","Theking.jpg");
		BookModel b2 = new BookModel(2,"The Lovely Boy in the ocean","Theboyundertheocen.jph");
		hmap.put(b1.getId(),b1);
		hmap.put(b2.getId(), b2);
	}
	
	@Override
	public ArrayList<BookModel> getBook(){
		Collection<BookModel> bookCollection = hmap.values();
		ArrayList<BookModel> books = new ArrayList<>(bookCollection);
		return books;
 	}
	
	@Override
	public BookModel getBookbyId(int bookId) {
		BookModel book = hmap.get(bookId);
		if(book == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return book;
	}
	@Override
	public BookModel addBook(BookModel book) {
		book.setId(uniqueId);
		hmap.put(uniqueId, book);
		uniqueId+=1;
		return book;
	}
	
	@Override
	public BookModel updateBook(int bookId,BookModel book) {
		BookModel existingbook = hmap.get(bookId);
		if(existingbook == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		if(book.getName() != null) {
			existingbook.setName(book.getName());
		}
		if(book.getImageUrl() != null) {
			existingbook.setImageUrl(book.getImageUrl());
		}
		
		return existingbook;
		
	}
	
	@Override
	public void deleteBook(int bookId) {
		BookModel book = hmap.get(bookId);
		if(book == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		if(book != null) {
			hmap.remove(bookId);
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
	}
}
