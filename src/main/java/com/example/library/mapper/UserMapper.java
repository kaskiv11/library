package com.example.library.mapper;

import com.example.library.dto.UserRequestDto;
import com.example.library.dto.UserResponseDto;
import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class UserMapper {
    public User mapToModel(final UserRequestDto userRequestDto, final List<Book> bookList) {
        final User user = new User();
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setEmail(userRequestDto.getEmail());
        user.setPhone(userRequestDto.getPhone());
        user.setTakenBooks(bookList);
        return user;
    }

    public UserResponseDto mapToDto(final User user) {
        final UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPhone(user.getPhone());
        return userResponseDto;
    }


}
