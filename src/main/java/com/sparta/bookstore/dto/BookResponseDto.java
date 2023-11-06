package com.sparta.bookstore.dto;

import com.sparta.bookstore.entity.Bookstore;
import lombok.Getter;

@Getter
public class BookResponseDto {
    private Long bookId;
    private String bookName;
    private String bookInfo;
    private String userName;
    private String date;
    private Long password;

    public BookResponseDto(Bookstore book) {
        this.bookName = book.getBookName();
        this.bookInfo = book.getBookInfo();
        this.userName = book.getUserName();
        this.date = book.getDate();
        this.password = book.getPassword();
        this.bookId = book.getBookId();
    }
}