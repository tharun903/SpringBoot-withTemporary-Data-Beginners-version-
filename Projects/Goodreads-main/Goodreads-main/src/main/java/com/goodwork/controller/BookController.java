package com.goodwork.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goodwork.model.BookModel;
import com.goodwork.service.BookService;

@RestController
public class BookController {
	
	private final BookService service;
	
	public BookController(BookService service) {
        this.service = service;
    }
	@GetMapping("/books")
	public ArrayList<BookModel> getBooks(){
		return service.getBook();
		
	}
	
	@GetMapping("/books/{bookId}")
	public BookModel getBook(@PathVariable("bookId") int bookId) {
		return service.getBookbyId(bookId);
	}
	
	@PostMapping("/books")
	public BookModel addBook(@RequestBody BookModel book) {
		return service.addBook(book);
		
	}
	
	@PutMapping("/books/{bookId}")
	public BookModel updateBook(@PathVariable("bookId") int bookId,@RequestBody BookModel book) {
		return service.updateBook(bookId,book);
	}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		service.deleteBook(bookId);
	}
}
