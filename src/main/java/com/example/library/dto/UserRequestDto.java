package com.example.library.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class UserRequestDto {

    @NotNull
    @Min(5)
    @NotEmpty(message = "Enter firstname")
    private String firstName;

    @NotNull
    @Min(5)
    @NotEmpty(message = "Enter firstname")
    private String lastName;

    @NotNull
    @Email(message = "Wrong format of the email. Use like: somemail@mail.com")
    private String email;

    @NotNull
    @Pattern(regexp = "\\+[0-9]{12}",
            message = "Wrong format of the phone number. Use like: +380930000000")
    private String phone;
}
