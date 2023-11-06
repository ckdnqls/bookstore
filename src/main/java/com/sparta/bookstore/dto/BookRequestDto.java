package com.sparta.bookstore.dto;

import com.sparta.bookstore.entity.Bookstore;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BookRequestDto {
    private String bookName;
    private String bookInfo;
    private String userName;
    private LocalDate date;
    private Long password;
}