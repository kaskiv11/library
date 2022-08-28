package com.example.library.service.impl;

import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.exeption.ReturnBookException;
import com.example.library.exeption.TakeBookException;
import com.example.library.service.BookService;
import com.example.library.service.LibraryService;
import com.example.library.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j
@Service
@RequiredArgsConstructor
public class LibraryServiceImp implements LibraryService {
    private final UserService userService;
    private final BookService bookService;

    @Override
    public void returnBook(final Long bookId) throws ReturnBookException {
        final Book book = bookService.findById(bookId);
        if (!book.getIsAvailable()) {
            book.setIsAvailable(true);
            book.setUser(null);
            bookService.saveBook(book);
        } else {
            throw new ReturnBookException("This book was not taken");
        }
    }
    @Override
    public void takeBook(final Long userId, final Long bookId) throws TakeBookException {
        final Book book = bookService.findById(bookId);
        if (book.getIsAvailable()) {
            final User user = userService.findUserById(userId);
            book.setIsAvailable(true);
            book.setUser(user);
            bookService.saveBook(book);
        } else {
            throw new TakeBookException("The current book has been already taken");
        }
    }
    @Override
    public List<User> allUserWithBooks() {
        log.info("All users with books");
        final List<User> users = userService
                .allUsers()
                .stream()
                .filter(s1->s1.getTakenBooks()!=null)
                .collect(Collectors.toList());
        return  users;
        }
    }


