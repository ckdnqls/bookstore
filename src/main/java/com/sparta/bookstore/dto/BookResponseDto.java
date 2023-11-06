package com.sparta.bookstore.dto;

import com.sparta.bookstore.entity.Bookstore;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BookResponseDto {
    private Long bookId;
    private String bookName;
    private String bookInfo;
    private String userName;
    private LocalDate date;

    public BookResponseDto(Bookstore book) {
        this.bookName = book.getBookName();
        this.bookInfo = book.getBookInfo();
        this.userName = book.getUserName();
        this.date = book.getDate();
        this.bookId = book.getBookId();
    }
}