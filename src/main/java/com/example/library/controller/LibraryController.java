package com.example.library.controller;

import com.example.library.entity.User;
import com.example.library.exeption.ReturnBookException;
import com.example.library.exeption.TakeBookException;
import com.example.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    @PutMapping("return-book")
    public void returnBook(@RequestParam("book") final Long bookId) throws ReturnBookException {
        libraryService.returnBook(bookId);
    }
    @PutMapping("take-book")
    public void takeBook(@RequestParam("user") final Long userId,
                         @RequestParam("book") final Long bookId) throws TakeBookException {
        libraryService.takeBook(userId, bookId);
    }

    @GetMapping("user-with-books/all")
    public List<User> getAllUsersWithTheirBooks() {
        return libraryService.allUserWithBooks();
    }

}
