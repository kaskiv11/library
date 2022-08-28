package com.example.library.service;

import com.example.library.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    User findUserById(Long userId);
    List<User> allUsers();
    boolean deleteUserId(Long userId);
    boolean save(User user);
    void updateUser(Long id, User user);
    String addBookToUser(int user_id, int book_id);
}
