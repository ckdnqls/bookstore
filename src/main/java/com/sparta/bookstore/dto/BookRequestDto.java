package com.sparta.bookstore.dto;

import com.sparta.bookstore.entity.Bookstore;
import lombok.Getter;

@Getter
public class BookRequestDto {
    private String bookName;
    private String bookInfo;
    private String userName;
    private String date;
    private Long password;


}