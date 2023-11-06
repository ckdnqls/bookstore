package com.sparta.bookstore.controller;

import com.sparta.bookstore.dto.BookRequestDto;
import com.sparta.bookstore.dto.BookResponseDto;
import com.sparta.bookstore.entity.Bookstore;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.*;

@RestController
@RequestMapping("/api")
public class BookController {
    private final Map<Long, Bookstore> bookList = new HashMap<>();
    @PostMapping("/books")
    public BookResponseDto createBook(@RequestBody BookRequestDto requestDto){
        Bookstore book = new Bookstore(requestDto);

        Long maxId = bookList.size() > 0 ? Collections.max(bookList.keySet())+1 : 1;
        book.setBookId(maxId);

        bookList.put(book.getBookId(), book);
        BookResponseDto bookResponseDto = new BookResponseDto(book);

        return bookResponseDto;
    }

    @GetMapping("/books")
    public List<BookResponseDto> getBooks(){
        List<BookResponseDto> responseList = bookList.values().stream()
                .map(BookResponseDto::new).toList();

        return responseList;
    }
}
