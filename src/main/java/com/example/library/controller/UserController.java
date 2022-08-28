package com.example.library.controller;

import com.example.library.entity.User;
import com.example.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("{id}") //localhost:8050/user/1
    public User findById(@PathVariable("id") final Long userId) {
        return userService.findUserById(userId);
    }
    @GetMapping("all") //localhost:8050/user/all
    public List<User> getAllUsers() {
        return userService.allUsers();
    }

    @PostMapping("create-user")
    public void createNewUser(@RequestBody final User user) {
        userService.save(user);
    }

    @PutMapping("update/{id}")
    public void updateUser(@PathVariable final Long id,
                           @RequestBody final User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable final Long id) {
        userService.deleteUserId(id);
    }


}
