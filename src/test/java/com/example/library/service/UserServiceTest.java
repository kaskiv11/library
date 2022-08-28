package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.repository.UserRepository;
import com.example.library.service.impl.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.Collections;
import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private final User ACTUAL_USER = new User(3L,"John","Smith","someEmail.@gmail.com", "098873445",
             Collections.singletonList(new Book()));

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;



    @Test
    public void saveUserExpectedFalseTest(){
        when(userRepository.findUserByEmail("someEmail.@gmail.com")).thenReturn(ACTUAL_USER);
        final boolean expected = userService.save(ACTUAL_USER);
       Assert.assertFalse(expected);
    }

    @Test
    public void updateUserTest(){
        userService.updateUser(3L,ACTUAL_USER);
        verify(userRepository,times(1)).save(eq(ACTUAL_USER));
    }

//    @Test
//    @Order(1)
//    @Rollback(value = false)
//    public void saveUserTest(){
//
//        final User user = User.builder()
//                .firstName("Ramesh")
//                .lastName("Fadatare")
//                .email("ramesh@gmail.com")
//                .phone("380957377347")
//                .build();
//
//        userRepository.save(user);
//
//        Assertions.assertThat(user.getId()).isGreaterThan(0);
//    }
}
