package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.service.BookService;
import com.example.library.service.impl.BookServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookService bookService;

    @GetMapping("{id}")
    public Book find(@PathVariable final Long id) {
        return bookService.findById(id);
    }

    @GetMapping("all")
    public List<Book> getAllBooks() {
        return bookService.allBooks();
    }

    @PostMapping("create-book")
    public void createNewBook(@RequestBody final Book book) {
        bookService.saveBook(book);
    }

    @PutMapping("update/{id}")
    public void updateBook(@PathVariable final Long id,
                           @RequestBody final Book book) {
        bookService.updateBook(id, book);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable final Long id) {
        bookService.deleteBookId(id);
    }
}
