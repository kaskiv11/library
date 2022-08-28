package com.example.library.service;

import com.example.library.entity.User;
import com.example.library.exeption.ReturnBookException;
import com.example.library.exeption.TakeBookException;

import java.util.List;

public interface LibraryService {

    void returnBook(Long bookId) throws ReturnBookException;
    void takeBook(Long userId, Long bookId) throws TakeBookException;
    List<User> allUserWithBooks();
}
