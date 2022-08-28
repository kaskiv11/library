package com.example.library.dto;
import lombok.Data;

@Data
public class BookResponseDto {
    private Long id;
    private String name;
    private String author;
    private Integer publicationYear;
    private Boolean isAvailable;
}
