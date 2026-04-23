package com.goodwork.repository;

import java.util.ArrayList;

import com.goodwork.model.BookModel;

public interface BookRepository {
	ArrayList<BookModel> getBook();

	BookModel getBookbyId(int bookId);

	BookModel addBook(BookModel book);

	BookModel updateBook(int bookId, BookModel book);

	void deleteBook(int bookId);

}
