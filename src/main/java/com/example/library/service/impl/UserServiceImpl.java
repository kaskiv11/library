package com.example.library.service.impl;

import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;
import com.example.library.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Log4j
@SuppressWarnings("ALL")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
     private  UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public User findUserById(final Long userId) {
        log.info("Method find user by id");
        return userRepository.findUserById(userId);
    }

    @Override
    public List<User> allUsers(){
        log.info("Method all users");
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUserId(Long userId) {
        log.info("Delete user by id");
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;

        }
        log.info("The user has not been deleted");
        return false;
    }
    @Override
    public boolean save(User user) {
        log.info("Create user :" + user);

        User emailUser = userRepository.findUserByEmail(user.getEmail());
        if (emailUser != null) {
            return false;
        }
        log.info("Save user :" + user);
        List<Book> bookList = new ArrayList<>();
        user.setTakenBooks(bookList);
        userRepository.save(user);

        return true;
    }
    @Override
    public void updateUser(Long id, User user) {
        log.info("Method update user");
        User userDB = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("Сannot change the user"));
        userDB.setFirstName(user.getFirstName());
        userDB.setLastName(user.getLastName());
        userDB.setEmail(user.getEmail());
        userDB.setPhone(user.getPhone());
        userRepository.save(userDB);
    }
    @Override
    public String addBookToUser(final int user_id, final int book_id) {
        log.info("Method add book to user");
        final User user = userRepository.findById((long) user_id).orElse(null);
        final Book book = bookRepository.findById((long) book_id).orElse(null);
        if (Objects.requireNonNull(book).getIsAvailable()) {
            user.setTakenBooks((List<Book>)  book);
            userRepository.save(user);
            return user.getEmail() + " took \"" + book.getName() + "\".";
        } else {
            return "Book \"" + book.getName() + "\" is not available.";
        }
    }


}
