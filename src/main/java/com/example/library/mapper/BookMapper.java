package com.example.library.mapper;

import com.example.library.dto.BookRequestDto;
import com.example.library.dto.BookResponseDto;
import com.example.library.entity.Book;
import com.example.library.entity.User;

public class BookMapper {

    public Book mapToModel(final BookRequestDto bookRequestDto, final User user) {
        final Book book = new Book();
        book.setName(bookRequestDto.getName());
        book.setAuthor(bookRequestDto.getAuthor());
        book.setPublicationYear(bookRequestDto.getPublicationYear());
        book.setIsAvailable(bookRequestDto.getIsAvailable());
        book.setUser(user);
        return book;
    }

    public BookResponseDto mapToDto(final Book book) {
        final BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setName(book.getName());
        bookResponseDto.setAuthor(book.getAuthor());
        bookResponseDto.setPublicationYear(book.getPublicationYear());
        bookResponseDto.setIsAvailable(book.getIsAvailable());

        return bookResponseDto;
    }
}
