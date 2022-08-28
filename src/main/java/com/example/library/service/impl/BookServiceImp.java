package com.example.library.service.impl;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book findById(final Long bookId) {
        log.info("Method find book by id");
        return bookRepository.findBookById(bookId);
    }
    @Override
    public List<Book> allBooks() {
        log.info("Find all books ");
        return (List<Book>) bookRepository.findAll();
    }
    @Override
    public void saveBook(final Book book) {
        log.info("Create user :" + book);
        bookRepository.save(book);
    }
    @Override
    public void updateBook(final Long id, final Book book) {
        log.info("Method update book");
        final Book bookDB = bookRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Cannot change the book"));
        bookDB.setName(bookDB.getName());
        bookDB.setAuthor(book.getAuthor());
        bookDB.setPublicationYear(book.getPublicationYear());
        bookDB.setIsAvailable(book.getIsAvailable());
        bookRepository.save(book);
    }
    @Override
    public boolean deleteBookId(final Long bookId) {
        log.info("Delete book by id");
        if (bookRepository.findById(bookId).isPresent()) {
            bookRepository.deleteById(bookId);
            return true;
        }
        log.info("The book has not been deleted");
        return false;
    }

}
