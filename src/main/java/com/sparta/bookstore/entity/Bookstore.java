package com.sparta.bookstore.entity;

import com.sparta.bookstore.dto.BookRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Bookstore {
    private Long bookId;
    private String bookName;
    private String bookInfo;
    private String userName;
    private String date;
    private Long password;

    public Bookstore(BookRequestDto requestDto) {
        this.bookName = requestDto.getBookName();
        this.bookInfo = requestDto.getBookInfo();
        this.userName = requestDto.getUserName();
        this.date = requestDto.getDate();

    }
}