package com.example.library.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class BookRequestDto {

    @NotNull
    @Min(5)
    @NotEmpty(message = "Enter title")
    private String name;

    @NotNull
    @Min(5)
    @NotEmpty(message = "Enter title")
    @Column(name = "name")
    private String author;

    @NotNull()
    @Min(value = 1900, message = "The year of publication can be no less than 1900")
    @Max(value = 2200, message = "The year of publication may not be more than 2200")
    private Integer publicationYear;

    @NotNull
    private Boolean isAvailable;
}
