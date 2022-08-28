package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.entity.User;

import java.util.List;

public interface BookService {
    Book findById(Long bookId);

    List<Book> allBooks();

    void saveBook(Book book);
    void updateBook(Long id, Book book);

    boolean deleteBookId(Long bookId);
}
